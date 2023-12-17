package com.byteexpress.springboot.attachment.controller;

import com.byteexpress.springboot.attachment.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传下载
 *
 * @Author: ByteExpress
 * @Date: 2023/12/16 08:35
 * @Version V1.0
 */
@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok("File uploaded successfully. Download link: " + fileService.upload(file));
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws IOException {
        return fileService.download(fileName);
    }
}
