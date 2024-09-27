package com.sbdigital.webapp.SecurityService.Domain;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "file_name")
    private String fileName;

    public Long getId() {
        return id;
    }

    public File setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getTaskId() {
        return taskId;
    }

    public File setTaskId(Long taskId) {
        this.taskId = taskId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public File setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public File setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    // Getters and Setters
    // ...
}