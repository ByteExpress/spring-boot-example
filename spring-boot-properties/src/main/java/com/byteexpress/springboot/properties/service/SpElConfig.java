package com.byteexpress.springboot.properties.service;

import com.byteexpress.springboot.properties.constant.SpElConstant;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p><strong>SpEl动态注入</strong></p><br>
 *
 * <p>SpEl支持和不支持操作：</p>
 * <ul>
 *     <li>不支持直接注入配置文件中的配置</li>
 *     <li>支持动态注入实例，类似于Autowire</li>
 *     <li>支持调用静态方法和实例方法。
 *          静态方法：@Value("#{T(package.ClassName).ConstFieldName")</li>
 *     <li>支持调用静态类或常量</li>
 *     <li>支持运算符运算</li>
 *     <li>支持操作集合</li>
 *     <li>支持查询筛选集合和投影</li>
 * </ul>
 *
 * @Author: ByteExpress
 * @Date: 2024/3/3 11:59
 * @Version V1.0
 */
@Data
@Component
public class SpElConfig {
    /**
     * 对象注入
     */
    @Value("#{spElConstant}")
    private SpElConstant spElConstant;
    /**
     * 注入ID为spElConstant Bean中的STR常量/变量
     */
    @Value("#{spElConstant.name}")
    private String name;
    /**
     * 调用无参方法
     */
    @Value("#{spElConstant.showProperty()}")
    private String method1;
    /**
     * 有参接收字符串的方法
     */
    @Value("#{spElConstant.showProperty('Hell SpringEL')}")
    private String method2;
    /**
     * 方法返回的String为大写
     */
    @Value("#{spElConstant.showProperty('转大写').toUpperCase()}")
    private String method3;
    /**
     * 若使用method3这种方式，若果showProperty返回为null
     * 将会抛出NullPointerException,可以使用以下方式避免
     * 使用?.符号代表左边的值不为null，才执行右边方法
     */
    @Value("#{spElConstant.showProperty('防止null异常')?.toUpperCase()}")
    private String method4;
    /**
     * 注入math常量
     */
    @Value("#{T(java.lang.Math).PI}")
    private double pi;
    /**
     * 用random方法获取返回值
     */
    @Value("#{T(java.lang.Math).random()}")
    private double random;
    /**
     * 获取文件路径符号
     */
    @Value("#{T(java.io.File).separator}")
    private String separator;
    /**
     * 拼接字符串
     */
    @Value("#{spElConstant.nickname + ' ' + spElConstant.name}")
    private String concatString;
    /**
     * 数字运算
     */
    @Value("#{3 * T(java.lang.Math).PI + spElConstant.num}")
    private double operation;
    /**
     * 逻辑运算
     */
    @Value("#{spElConstant.num > 100 and spElConstant.num <= 200}")
    private boolean logicOperation;
    /**
     * 或非逻辑操作
     */
    @Value("#{not (spElConstant.num == 100) or spElConstant.num <= 200}")
    private boolean logicOperation2;
    /**
     * 使用三元运算符
     */
    @Value("#{spElConstant.num > 100 ? spElConstant.num : spElConstant.num + 100}")
    private Integer tripleComputingSymbol;
    /**
     * 获取列表下标为0的元素
     */
    @Value("#{spElConstant.productList[0]}")
    private String str;
    /**
     * 获取列表下标为0元素的大写形式
     */
    @Value("#{spElConstant.productList[0]?.toUpperCase()}")
    private String upperStr;
    /**
     * 获取map中key为xiaomi14的value
     */
    @Value("#{spElConstant.productMap['xiaomi14']}")
    private String mapValue;
    /**
     * 根据productList下标为0元素作为key获取productMap的value
     */
    @Value("#{spElConstant.productMap[spElConstant.productList[1]]}")
    private String mapStrByproduct;
    /**
     * 销量大于等于999的商品
     */
    @Value("#{spElConstant.salesList.?[salesVolume >= 999]}")
    private List<SpElConstant.Sales> salesList;
    /**
     * 销量等于900的商品
     */
    @Value("#{spElConstant.salesList.?[salesVolume == 998]}")
    private SpElConstant.Sales sales;
    /**
     * 销量大于等于999的商品，且只保留商品名称
     */
    @Value("#{spElConstant.salesList.?[salesVolume >= 999].![productName]}")
    private List<String> productNames;

}