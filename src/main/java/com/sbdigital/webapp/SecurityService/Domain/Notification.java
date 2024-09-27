package com.sbdigital.webapp.SecurityService.Domain;

import javax.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notification_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "read")
    private int read;

    @Column(name = "task_id")
    private int taskId;

    public Long getNotification_id() {
        return notification_id;
    }

    public Notification setNotification_id(Long notification_id) {
        this.notification_id = notification_id;
        return this;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Notification setUser_id(Long user_id) {
        this.user_id = user_id;
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
}