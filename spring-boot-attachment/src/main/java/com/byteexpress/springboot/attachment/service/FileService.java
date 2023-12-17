package com.byteexpress.springboot.attachment.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;

/**
 * 文件上传下载
 *
 * @Author: ByteExpress
 * @Date: 2023/12/16 08:35
 * @Version V1.0
 */
public interface FileService {
    String upload(MultipartFile file);

    ResponseEntity<Resource> download(String fileName) throws MalformedURLException;
}