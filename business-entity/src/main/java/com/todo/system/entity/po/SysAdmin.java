package com.todo.system.entity.po;

import java.util.Date;
/**
 * @program: com-todo-sysytem-parent
 * @description: SysAdmin
 * @author: littleWhite
 * @create: 2019/5/5 15:47
 **/
public class SysAdmin {

    private Long id;

    private String userName;

    private String password;

    private Integer enabled;

    private Integer userType;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getUserType() { return userType; }

    public void setUserType(Integer userType) { this.userType = userType; }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
