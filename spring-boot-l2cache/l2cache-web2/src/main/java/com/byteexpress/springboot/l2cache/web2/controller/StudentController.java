package com.byteexpress.springboot.l2cache.web2.controller;

import com.byteexpress.springboot.l2cache.base.entity.R;
import com.byteexpress.springboot.l2cache.domain.Student;
import com.byteexpress.springboot.l2cache.service.IStudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生 controller
 * @Author: ByteExpress
 * @Date: 2023-11-12 22:02:10
 */
@Slf4j
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService iStudentService;

    @GetMapping("/{id}")
    public R get(@PathVariable("id") Long id) {
        log.info("get method student");
        return R.ok(iStudentService.getById(id));
    }

    @PutMapping
    public R update(@RequestBody Student student) {
        log.info("put method student");
        return R.ok(iStudentService.updateById(student));
    }

    @PostMapping
    public R insert(@RequestBody Student student) {
        return R.ok(iStudentService.save(student));
    }

    @DeleteMapping
    public R delete(@RequestBody List<Long> ids) {
        return R.ok(iStudentService.removeBatchByIds(ids));
    }
}
