package com.byteexpress.springboot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.byteexpress.springboot.mybatisplus.base.domain.BaseCusEntity;
import com.byteexpress.springboot.mybatisplus.domain.bo.CusFormQueryBo;
import com.byteexpress.springboot.mybatisplus.domain.bo.CusFormSaveBo;
import com.byteexpress.springboot.mybatisplus.facotry.CusFormFactory;
import com.byteexpress.springboot.mybatisplus.service.CusService;
import com.byteexpress.springboot.mybatisplus.util.FieldUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 通用表单服务实现类
 *
 * @Author: ByteExpress
 * @Date: 2024/1/13 08:01
 * @Version V1.0
 */
@Service
@RequiredArgsConstructor
public class CusServiceImpl implements CusService {
    private final CusFormFactory cusFormFactory;

    @Override
    public Serializable add(String formKey, CusFormSaveBo bo) {
        IService iService = cusFormFactory.getByType(formKey);
        Map<String, Object> table = bo.getTable();
        table.put(FieldUtil.getJavaField(BaseCusEntity::getCreateBy), "admin");
        table.put(FieldUtil.getJavaField(BaseCusEntity::getCreateTime), LocalDateTime.now());
        iService.save(table);

        return (Serializable) table.get("id");
    }

    @Override
    public Boolean update(String formKey, CusFormSaveBo bo) {
        IService iService = cusFormFactory.getByType(formKey);
        Map<String, Object> table = bo.getTable();
        table.put(FieldUtil.getJavaField(BaseCusEntity::getUpdateBy), "admin");
        table.put(FieldUtil.getJavaField(BaseCusEntity::getUpdateTime), LocalDateTime.now());
        return iService.updateById(table);
    }

    @Override
    public List list(String formKey, CusFormQueryBo bo) {
        IService iService = cusFormFactory.getByType(formKey);
        return iService.list();
    }

    @Override
    public Object detail(String formKey, Long id) {
        IService iService = cusFormFactory.getByType(formKey);
        return iService.getById(id);
    }

    @Override
    public void delete(String formKey, List<Serializable> ids) {
        IService iService = cusFormFactory.getByType(formKey);
        iService.removeBatchByIds(ids);
    }
}
