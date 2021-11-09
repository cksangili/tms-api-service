package com.tms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name ="TASK")
public class TaskEntity {

    @Id
    private Integer taskId;

    @Column(name= "role")
    private String role;

    @Column(name= "responsible")
    private String responsible;

    @Column(name= "status")
    private String status;

    @Column(name= "taskDescription")
    private String taskDescription;

    @Column(name= "dueDate")
    private Date dueDate;

    @Column(name= "createDate")
    private Date createDate;

    @Column(name= "comments")
    private String comments;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
