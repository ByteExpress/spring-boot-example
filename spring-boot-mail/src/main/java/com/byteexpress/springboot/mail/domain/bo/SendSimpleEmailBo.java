package com.byteexpress.springboot.mail.domain.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * 发送简单邮件BO
 * @Author: ByteExpress
 * @Date: 2024/4/20 08:01
 * @Version V1.0
 */
@Setter
@Getter
public class SendSimpleEmailBo {
    /**
     * 收件人邮箱
     */
    private String email;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String text;
}
