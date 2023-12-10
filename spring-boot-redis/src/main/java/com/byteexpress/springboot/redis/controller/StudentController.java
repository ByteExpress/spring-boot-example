package com.byteexpress.springboot.redis.controller;

import com.byteexpress.springboot.redis.annotation.Cache;
import com.byteexpress.springboot.redis.annotation.ReloadCache;
import com.byteexpress.springboot.redis.base.entity.R;
import com.byteexpress.springboot.redis.domain.Student;
import com.byteexpress.springboot.redis.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生 controller
 * @Author: ByteExpress
 * @Date: 2023-11-12 22:02:10
 */
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService iStudentService;

    @GetMapping("/{id}")
    @Cache(name = "get student")
    public R get(@PathVariable("id") Long id) {
        return R.ok(iStudentService.getById(id));
    }

    @PutMapping
    @ReloadCache(name = "update student")
    public R update(@RequestBody Student student) {
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
