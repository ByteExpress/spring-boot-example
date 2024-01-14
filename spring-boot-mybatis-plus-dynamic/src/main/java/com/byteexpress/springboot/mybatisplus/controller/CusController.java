package com.byteexpress.springboot.mybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.byteexpress.springboot.mybatisplus.base.vo.R;
import com.byteexpress.springboot.mybatisplus.domain.bo.CusFormQueryBo;
import com.byteexpress.springboot.mybatisplus.domain.bo.CusFormSaveBo;
import com.byteexpress.springboot.mybatisplus.service.CusService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 通用表单控制器
 *
 * @Author: ByteExpress
 * @Date: 2024/1/13 07:57
 * @Version V1.0
 */
@RestController
@RequestMapping("/common/form")
@RequiredArgsConstructor
public class CusController {
    private final CusService commonService;
    private final ObjectMapper objectMapper;

    /**
     * 表单新增
     *
     * @param formKey
     * @param bo
     * @return
     */
    @PostMapping("/{formKey}")
    public R<Serializable> insert(@PathVariable("formKey") String formKey, @RequestBody CusFormSaveBo bo) {
        Serializable id = commonService.add(formKey, bo);
        return R.success(id);
    }



    @PutMapping("/{formKey}")
    public R<Boolean> update(@PathVariable("formKey") String formKey, @RequestBody CusFormSaveBo bo) {
        Boolean flag = commonService.update(formKey, bo);
        return R.success(flag);
    }

    @GetMapping("/{formKey}")
    public R<IPage<Object>> list(@PathVariable("formKey") String formKey, CusFormQueryBo bo) {
        List list = commonService.list(formKey, bo);
        return R.success(list);
    }

    @GetMapping("/{formKey}/{id}")
    public R<Object> detail(@PathVariable("formKey") String formKey, @PathVariable("id") Long id) {
        Object table = commonService.detail(formKey, id);
        return R.success(table);
    }

    @DeleteMapping("/{formKey}")
    public void delete(@PathVariable("formKey") String formKey, @RequestBody List<Serializable> ids) {
        commonService.delete(formKey, ids);
    }
}
