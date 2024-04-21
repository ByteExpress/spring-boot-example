package com.byteexpress.springboot.mail.controller;

import com.byteexpress.springboot.mail.domain.bo.SendEmailBo;
import com.byteexpress.springboot.mail.domain.bo.SendSimpleEmailBo;
import com.byteexpress.springboot.mail.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 邮件发送 controller
 *
 * @Author: ByteExpress
 * @Date: 2024/4/20 08:01
 * @Version V1.0
 */
@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;
    private final JavaMailSender javaMailSender;

    /**
     * 发送简单邮件
     *
     * @param bo
     * @return
     */
    @PostMapping("/sendSimpleEmail")
    public ResponseEntity<String> sendSimpleEmailBo(@RequestBody SendSimpleEmailBo bo) {
        SimpleMailMessage simpleMsg = emailService.createSimpleMsg(bo);
        javaMailSender.send(simpleMsg);
        return ResponseEntity.ok("success");
    }

    /**
     * 发送带附件的邮件
     *
     * @param bo
     * @return
     * @throws MessagingException
     * @throws IOException
     */
    @PostMapping("/sendMail")
    public ResponseEntity<String> sendMail(@RequestBody SendEmailBo bo) throws MessagingException, UnsupportedEncodingException {
        MimeMessage simpleMsg = emailService.createMimeMsg(bo);
        javaMailSender.send(simpleMsg);
        return ResponseEntity.ok("success");
    }
}
