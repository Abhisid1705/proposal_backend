package com.sbdigital.webapp.SecurityService.Controller;

import com.sbdigital.webapp.SecurityService.Domain.File;
import com.sbdigital.webapp.SecurityService.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "*")  // Replace with your frontend URL
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<File> uploadFile(@RequestParam("file") MultipartFile file,
                                           @RequestParam("taskId") Long taskId,
                                           @RequestParam("userId") Long userId) throws IOException {
        File savedFile = fileService.saveFile(file, taskId, userId);
        return ResponseEntity.ok(savedFile);
    }

// ...

    @GetMapping("/task/{taskId}/user/{userId}")
    public ResponseEntity<Resource> getFileByTaskIdAndUserId(@PathVariable Long taskId, @PathVariable Long userId) {
        File file = fileService.getFileByTaskIdAndUserId(taskId, userId);
        Path path = Paths.get("uploads/" + file.getFileName());
        Resource resource;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

        String mimeType;
        try {
            mimeType = Files.probeContentType(path);
        } catch (IOException e) {
            mimeType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}