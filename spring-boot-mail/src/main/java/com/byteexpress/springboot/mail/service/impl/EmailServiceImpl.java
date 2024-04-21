package com.byteexpress.springboot.mail.service.impl;

import com.byteexpress.springboot.mail.domain.bo.SendEmailBo;
import com.byteexpress.springboot.mail.domain.bo.SendSimpleEmailBo;
import com.byteexpress.springboot.mail.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 邮件发送
 *
 * @Author: ByteExpress
 * @Date: 2024/4/20 08:12
 * @Version V1.0
 */
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;
    private final MailProperties mailProperties;

    @Override
    public MimeMessage createMimeMsg(SendEmailBo bo) throws UnsupportedEncodingException, MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msg, true);
        Map<String, String> properties = mailProperties.getProperties();
        mimeMessageHelper.setFrom(properties.get("from"), properties.get("personal"));
        mimeMessageHelper.setTo(bo.getEmail());
        mimeMessageHelper.setSubject(bo.getSubject());
        mimeMessageHelper.setText(bo.getText());
        mimeMessageHelper.addAttachment(bo.getAttachmentName(),
                new ClassPathResource(bo.getAttachmentClassPath()));
        return msg;
    }

    @Override
    public SimpleMailMessage createSimpleMsg(SendSimpleEmailBo bo) {
        Map<String, String> properties = mailProperties.getProperties();
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(properties.get("from"));
        msg.setTo(bo.getEmail());
        msg.setSubject(bo.getSubject());
        msg.setText(bo.getText());
        return msg;
    }
}
