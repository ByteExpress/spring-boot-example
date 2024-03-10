package com.byteexpress.springboot.l2cache.service;

import com.alicp.jetcache.anno.*;
import com.baomidou.mybatisplus.extension.service.IService;
import com.byteexpress.springboot.l2cache.domain.Student;

/**
 * 学生 Service
 * @Author: ByteExpress
 * @Date: 2024/03/10 20:03
 * @Version V1.0
 */
public interface IStudentService extends IService<Student> {
    /**
     * <p>查询学生信息</p>
     * 开启缓存、自动刷新缓存、并发缓存更新保护
     * syncLocal
     * @param id
     * @return
     */
    @Cached(name = "studentCache-", key = "#id", expire = 3600, cacheType = CacheType.BOTH, syncLocal = true)
    @CacheRefresh(refresh = 120, stopRefreshAfterLastAccess = 30)
    @CachePenetrationProtect
    Student getById(Long id);

    /**
     * 更新学生信息
     * @param student 实体对象
     * @return
     */
    @CacheUpdate(name = "studentCache-", key = "#student.id", value = "#student")
    boolean updateById(Student student);
}
