package com.byteexpress.springboot.mail.service;

import com.byteexpress.springboot.mail.domain.bo.SendEmailBo;
import com.byteexpress.springboot.mail.domain.bo.SendSimpleEmailBo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;

import java.io.UnsupportedEncodingException;

/**
 * 邮件发送
 *
 * @Author: ByteExpress
 * @Date: 2024/4/20 08:12
 * @Version V1.0
 */
public interface EmailService {

    /**
     * <p>生成邮件对象</p>
     * 用来发送html邮件、带附件的邮件、有静态资源（图片）的邮件
     * @param bo
     */
    MimeMessage createMimeMsg(SendEmailBo bo) throws UnsupportedEncodingException, MessagingException;

    /**
     * <p>生成简单邮件对象</p>
     * 用来发送简单的文本邮件
     * @param bo
     */
    SimpleMailMessage createSimpleMsg(SendSimpleEmailBo bo);
}