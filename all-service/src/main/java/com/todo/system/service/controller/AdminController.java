package com.todo.system.service.controller;

import com.todo.system.entity.po.SysAdmin;
import com.todo.system.service.service.SysAdminService;
import com.todo.system.util.exception.ParamNullException;
import com.todo.system.util.utils.PasswordUtil;
import com.todo.system.util.utils.StringUtil;
import com.todo.system.util.web.UrlRegulation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: com-todo-sysytem-parent
 * @description: AdminController
 * @author: littleWhite
 * @create: 2019/5/10 11:23
 **/
@RestController
@RequestMapping(UrlRegulation.BizPrefix.ADMIN)
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    SysAdminService sysAdminService;

    /**
     * 用户名和密码取用户信息
     * @param userName
     * @param password
     * @return
     */
    @PostMapping("/login")
    public SysAdmin getAdminByLogin(String userName, String password) throws ParamNullException {
        if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password))
            throw new ParamNullException("参数为空");
        return sysAdminService.getSingleAdmin(userName, PasswordUtil.md5Encrypt(password));
    }

    @PostMapping("/oauth/login")
    public SysAdmin getAdminByName(String userName) throws ParamNullException {
        Map<String,Object> map = new HashMap<>();
        map.put("a","b");
        if (StringUtil.isEmpty(userName))
            throw new ParamNullException("参数为空");
        return sysAdminService.getSingleAdminByName(userName);

    }
}
