# 简介
通过自定义注解的方式，实现简单易用的redis缓存服务。获取数据会自动缓存，更新数据会自动刷新缓存。

## 使用方式
1、如[StudentController.java](src%2Fmain%2Fjava%2Fcom%2Fbyteexpress%2Fspringboot%2Fredis%2Fcontroller%2FStudentController.java)类，在get方法上添加@Cache注解，添加缓存
1、如[StudentController.java](src%2Fmain%2Fjava%2Fcom%2Fbyteexpress%2Fspringboot%2Fredis%2Fcontroller%2FStudentController.java)类，在update方法上添加@ReloadCache注解，刷新缓存

## 测试方式
1. 执行[init.sql](doc%2Finit.sql)，初始化测试数据库
2. 运行[SpringBootRedisApplication.java](src%2Fmain%2Fjava%2Fcom%2Fbyteexpress%2Fspringboot%2Fredis%2FSpringBootRedisApplication.java) main方法，启动web项目
3. 多次访问 GET http://localhost:8080/student/1 ，观察控制台日志打印，会发现第一次会打印SQL查询，之后每次访问都不会查询DB，说明缓存生效
4. 访问 PUT http://localhost:8080/student ，更新学生信息，再访问 GET http://localhost:8080/student/1 ，会发现学生信息已经更新

