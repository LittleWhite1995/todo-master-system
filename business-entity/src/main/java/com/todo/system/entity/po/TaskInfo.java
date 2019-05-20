package com.todo.system.entity.po;

import java.util.Date;

/**
 * @program: com-todo-sysytem-parent
 * @description: TaskInfo
 * @author: littleWhite
 * @create: 2019/5/20 11:02
 **/
public class TaskInfo {

    private Long id;

    private String title;

    private String follow;

    private Integer instancy;

    private Date done_date;

    private Integer status;

    private String category;

    private String description;

    private Date create_time;

    private Date update_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFollow() {
        return follow;
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }

    public Integer getInstancy() {
        return instancy;
    }

    public void setInstancy(Integer instancy) {
        this.instancy = instancy;
    }

    public Date getDone_date() {
        return done_date;
    }

    public void setDone_date(Date done_date) {
        this.done_date = done_date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
