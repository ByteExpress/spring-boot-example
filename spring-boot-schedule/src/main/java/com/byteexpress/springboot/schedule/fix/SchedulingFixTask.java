package com.byteexpress.springboot.schedule.fix;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 静态定时任务
 * <p>
 * 第一位，表示秒，取值0-59
 * 第二位，表示分，取值0-59
 * 第三位，表示小时，取值0-23
 * 第四位，日期天/日，取值1-31
 * 第五位，日期月份，取值1-12
 * 第六位，星期，取值1-7，1表示星期天，2表示星期一
 * 第七位，年份，可以留空，取值1970-2099
 *
 * @Author: ByteExpress
 * @Date: 2023/12/10 09:01
 * @Version V1.0
 */
@Component
public class SchedulingFixTask {
    /**
     * <p>直接在注解中配置cron表达式</p>
     * 每五秒执行一次
     */
    @Scheduled(cron = "*/5 * * * * ?")
    private void basic() {
        System.out.println("注解中配置固定定时任务:--->" + LocalDateTime.now());
    }

    /**
     * <p>在配置文件中配置完整的cron表达式</p>
     */
    @Scheduled(cron = "${scheduled.cron.fullCron}")
    private void propertiesFullCron() {
        System.out.println("配置文件中配置完整cron定时任务:--->" + LocalDateTime.now());
    }

    /**
     * <p>在配置文件中配置秒级间隔</p>
     */
    @Scheduled(cron = "0/${scheduled.cron.interval} * * * * *")
    public void propertiesIntervalCron() {
        System.out.println("配置文件中配置间隔定时任务:--->" + LocalDateTime.now());
    }
}