package com.byteexpress.springboot.mybatisplus.facotry;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.byteexpress.springboot.mybatisplus.base.domain.BaseCusEntity;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: ByteExpress
 * @Date: 2024/1/10 21:50
 * @Version V1.0
 */
@Slf4j
@Component
public class CusFormFactory implements InitializingBean {
    private static final String ENTITY_BASE_PACKAGE = "com.byteexpress.springboot.mybatisplus.domain";
    private static final String MAPPER_BASE_PACKAGE = "com.byteexpress.springboot.mybatisplus.domain.mapper";
    private static final String SERVICE_BASE_PACKAGE = "com.byteexpress.springboot.mybatisplus.domain.service";

    @Resource
    private List<IService> formServices;

    /**
     * 表单service缓存map
     * <p>用于根据formKey获取对应的service</p>
     */
    private Map<String, IService> formServiceMap = new HashMap<>();


    /**
     * 根据formKey获取对应的service
     *
     * @param formKey
     * @return
     */
    public IService getByType(String formKey) {
        return this.getByType(formKey, true);
    }

    /**
     * 根据formKey获取对应的service
     *
     * @param formKey
     * @param isThrowException     找不到时是否抛出异常
     * @return
     */
    public IService getByType(String formKey, boolean isThrowException) {
        IService baseFormService = formServiceMap.get(formKey);
        if (baseFormService == null && isThrowException) {
            throw new RuntimeException(String.format("%s 未找到", formKey));
        }
        return baseFormService;
    }

    private String getFullMapperClassName(Class<?> entityClass) {
        return MAPPER_BASE_PACKAGE + "." + entityClass.getSimpleName() + "Mapper";
    }

    private String getFullServiceClassName(Class<?> entityClass) {
        return SERVICE_BASE_PACKAGE + "." + entityClass.getSimpleName() + "Service";
    }

    private String getBeanName(String fullClassName) {
        int index = fullClassName.indexOf(".");
        return StrUtil.lowerFirst(fullClassName.substring(index));
    }

    @Override
    public void afterPropertiesSet() {
        /**
         * 1、获取已经注册到Spring容器的BaseFormService实例
         */
        formServices.forEach(e -> {
            //获取表单对应的formKey，即表单实体对应的数据库表名
            Class entityClass = e.getEntityClass();
            Assert.isFalse(null == entityClass, () -> new RuntimeException(String.format("%s 类需要继承com.baomidou.mybatisplus.extension.service.impl.ServiceImpl", e.getClass().getSuperclass().getName())));
            Annotation annotation = entityClass.getAnnotation(TableName.class);
            Assert.isFalse(null == annotation, () -> new RuntimeException("请为表单实体类添加@TableName注解！"));
            String formKey = ((TableName) annotation).value();

            formServiceMap.put(formKey, e);
        });

        /**
         * 2、找到没有写Mapper、Service类的实体，并动态生成
         */
        Set<Class<?>> entityClassSet = ClassUtil.scanPackage(ENTITY_BASE_PACKAGE);
        Map<String, Class> serviceClassSet = ClassUtil.scanPackage(SERVICE_BASE_PACKAGE).stream().collect(Collectors.toMap(Class::getName, e -> e));
        Map<String, Class> mapperClassSet = ClassUtil.scanPackage(MAPPER_BASE_PACKAGE).stream().collect(Collectors.toMap(Class::getName, e -> e));
        entityClassSet.stream()
                //过滤不需要动态生成的
                .filter(e -> null != e.getAnnotation(TableName.class)
                        //实体类必须继承自BaseEntity
                        && e.getSuperclass() == BaseCusEntity.class
                        //排除已经存在Service，且已注册到Spring容器中的
                        && !formServiceMap.containsKey(e.getAnnotation(TableName.class).value())
                )
                .forEach(e -> {
                    //生成mapper文件
                    Class<?> mapperClass = !mapperClassSet.containsKey(getFullMapperClassName(e))
                            ? createMapper(e, getFullMapperClassName(e))
                            : mapperClassSet.get(getFullMapperClassName(e));

                    //生成service文件
                    if (!serviceClassSet.containsKey(getFullServiceClassName(e))) {
                        IService baseFormService = createService(e, getFullServiceClassName(e), mapperClass);
                        formServiceMap.put(e.getAnnotation(TableName.class).value(), baseFormService);
                    }
                });
    }

    /**
     * 创建mapper类
     *
     * @param entityClass     实体class
     * @param mapperClassName mapper全路径名
     * @return
     */
    private Class<?> createMapper(Class<?> entityClass, String mapperClassName) {
        //创建mapper
        Class<?> mapperClass = new ByteBuddy()
                .makeInterface()
                .implement(TypeDescription.Generic.Builder.parameterizedType(BaseMapper.class, entityClass).build())
                .name(mapperClassName)
                .annotateType(AnnotationDescription.Builder.ofType(Mapper.class).build())
                .make()
                .load(getClass().getClassLoader(), new ClassLoadingStrategy.ForBootstrapInjection(null, null))
                .getLoaded();

        SqlSessionFactory sqlSessionFactory = SpringUtil.getBean(SqlSessionFactory.class);
        MapperFactoryBean<?> factoryBean = new MapperFactoryBean<>(mapperClass);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        sqlSessionFactory.getConfiguration().addMapper(mapperClass);

        //注册mapper
        try {
            SpringUtil.registerBean(getBeanName(mapperClassName), factoryBean.getObject());

        } catch (Exception e) {
            log.warn("register BaseMapper error", e);
        }
        return mapperClass;
    }

    /**
     * 创建service类
     *
     * @param entityClass      实体类class
     * @param serviceClassName service全路径名
     * @param mapperClass      mapper class
     * @return
     */
    private IService createService(Class<?> entityClass, String serviceClassName, Class<?> mapperClass) {
        //创建service
        Class<?> serviceClass = new ByteBuddy()
                .subclass(TypeDescription.Generic.Builder.parameterizedType(ServiceImpl.class, mapperClass, entityClass).build())
                .implement(IService.class)
                .name(serviceClassName)
                .annotateType(AnnotationDescription.Builder.ofType(Service.class).build())
                .make()
                .load(getClass().getClassLoader(), new ClassLoadingStrategy.ForBootstrapInjection(null, null))
                .getLoaded();

        //注册service
        try {
            Object bean = serviceClass.newInstance();
            SpringUtil.registerBean(getBeanName(serviceClassName), bean);
            return (IService) bean;

        } catch (Exception e) {
            log.warn("register ServiceImpl error", e);
        }
        return null;
    }
}
