# 简介
基于阿里开源二级缓存框架jetcache，实现本地+远程二级缓存架构。有如下特点：
* 支持本地缓存和远程缓存
* 支持缓存自动刷新
* 支持自动同步缓存到其它实例

## 多实例部署时，自动同步缓存的配置方式
Cache更新的时候，将其它机器的本地Cache失效，这个是2.7才支持的可选功能，只针对Both类型有效，默认没有开。打开需要设置（比如在yml中）broadcastChannel，并在Cached注解（手工构造时在QuickConfig类）上面设置syncLocal = true。

## 测试方式
1. 执行[init.sql](doc%2Finit.sql)，初始化测试数据库
2. 运行[l2cache-web1](l2cache-web1)、[l2cache-web1](l2cache-web1)中的启动类，启动两个web项目（这里为了方便测试，添加了两个web项目，用于测试多实例缓存同步）
3. 访问 GET http://localhost:8081/student/1 和 http://localhost:8082/student/1， 观察控制台日志打印，会发现第一次会打印SQL查询，之后每次访问都不会查询DB，说明缓存生效
4. 访问 PUT http://localhost:8081/student ，更新学生信息，再访问 GET http://localhost:8081/student/1 和 http://localhost:8082/student/1， ，会发现学生信息已经更新

