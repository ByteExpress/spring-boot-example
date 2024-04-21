package com.byteexpress.springboot.mail.domain.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * 发送复杂邮件BO
 * @Author: ByteExpress
 * @Date: 2024/4/20 08:01
 * @Version V1.0
 */
@Setter
@Getter
public class SendEmailBo {
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
    /**
     * 附件名称
     */
    private String attachmentName = "li.jpg";
    /**
     * 附件路径
     */
    private String attachmentClassPath = "static/li.jpg";
}
