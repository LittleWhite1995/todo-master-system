package com.todo.system.entity.bo;

import javax.validation.constraints.NotBlank;

/**
 * @program: com-todo-sysytem-parent
 * @description: LoginUserBo
 * @author: littleWhite
 * @create: 2019/5/5 15:30
 **/
public class LoginUserBo {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
