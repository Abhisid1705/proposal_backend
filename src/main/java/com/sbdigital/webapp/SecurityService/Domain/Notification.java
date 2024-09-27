package com.sbdigital.webapp.SecurityService.Domain;

import javax.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notification_id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "read")
    private int read;

    @Column(name = "task_id")
    private int taskId;

    @Column(name ="message")
    private String message;
    public Long getNotification_id() {
        return notification_id;
    }

    public Notification setNotification_id(Long notification_id) {
        this.notification_id = notification_id;
        return this;
    }

    public Long getUser_id() {
        return userId;
    }

    public Notification setUser_id(Long user_id) {
        this.userId = user_id;
        return this;
    }

    public int getRead() {
        return read;
    }

    public Notification setRead(int read) {
        this.read = read;
        return this;
    }

    public int getTaskId() {
        return taskId;
    }

    public Notification setTaskId(int taskId) {
        this.taskId = taskId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Notification setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Notification setMessage(String message) {
        this.message = message;
        return this;
    }
}