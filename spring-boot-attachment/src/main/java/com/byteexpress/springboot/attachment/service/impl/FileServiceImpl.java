package com.byteexpress.springboot.attachment.service.impl;

import com.byteexpress.springboot.attachment.service.FileService;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件上传下载
 *
 * @Author: ByteExpress
 * @Date: 2023/12/16 08:36
 * @Version V1.0
 */
@Service
public class FileServiceImpl implements FileService {

    public String getTargetDirectoryPath() {
        return new ApplicationHome(FileServiceImpl.class).getSource().getAbsolutePath() + File.separator;
    }

    @Override
    public String upload(MultipartFile file) {
        // 保存文件到服务器或者云存储
        // 这里只是一个简单的演示，你可以根据实际需求进行处理

        // 获取文件名
        String fileName = file.getOriginalFilename();

        // 构建文件在服务器上的存储路径
        // 这里使用了临时路径，实际应用中应根据需求设置正确的文件路径
        String filePath = getTargetDirectoryPath() + fileName;
        System.out.println("filePath = " + filePath);

        // 保存文件到指定路径
        // 可以使用第三方存储服务，如AWS S3或阿里云OSS
        // 这里仅作演示，实际项目中应根据需要进行配置
        // 请注意处理文件重名等问题
        // 这里应该加上异常处理
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File upload failed");
        }

        // 返回文件的下载链接
        String downloadLink = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/files/download/")
                .path(fileName)
                .toUriString();
        return downloadLink;
    }

    @Override
    public ResponseEntity<Resource> download(String fileName) throws MalformedURLException {
        // 获取文件路径
        Path filePath = Paths.get(getTargetDirectoryPath() + fileName);
        // 尝试加载文件
        Resource resource = new UrlResource(filePath.toUri());

        // 检查文件是否存在并且可读
        if (resource.exists() && resource.isReadable()) {
            // 设置响应头
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", fileName);

            // 返回文件资源
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
        } else {
            // 文件不存在或无法读取
            return ResponseEntity.notFound().build();
        }
    }
}
