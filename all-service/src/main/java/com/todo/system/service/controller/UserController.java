package com.todo.system.service.controller;

import com.todo.system.entity.po.SysAdmin;
import com.todo.system.util.exception.ParamNullException;
import com.todo.system.util.utils.StringUtil;
import com.todo.system.util.web.UrlRegulation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlRegulation.BizPrefix.USER)
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

}
