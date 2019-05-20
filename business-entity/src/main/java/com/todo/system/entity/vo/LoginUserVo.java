package com.todo.system.entity.vo;


/**
 * @program: com-todo-sysytem-parent
 * @description: LoginUserVo
 * @author: littleWhite
 * @create: 2019/5/5 15:30
 **/
public class LoginUserVo {

    private String username;

    private String sessionId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
