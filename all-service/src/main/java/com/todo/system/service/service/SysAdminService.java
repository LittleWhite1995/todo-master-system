package com.todo.system.service.service;

import com.todo.system.entity.po.SysAdmin;

public interface SysAdminService {

    // 用户名和密码取用户信息
    SysAdmin getSingleAdmin(String userName, String password);

}
