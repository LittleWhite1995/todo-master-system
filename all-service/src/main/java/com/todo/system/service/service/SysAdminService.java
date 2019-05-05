package com.todo.system.service.service;

import com.todo.system.entity.po.SysAdmin;
import com.todo.system.util.exception.ParamNullException;

public interface SysAdminService {

    // 用户名和密码取用户信息
    SysAdmin getSingleAdmin(String userName, String password) throws ParamNullException;

}
