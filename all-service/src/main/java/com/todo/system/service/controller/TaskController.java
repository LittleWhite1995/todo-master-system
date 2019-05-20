package com.todo.system.service.controller;

import com.todo.system.util.web.UrlRegulation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com-todo-sysytem-parent
 * @description: TaskController
 * @author: littleWhite
 * @create: 2019/5/20 15:23
 **/
@RestController
@RequestMapping(UrlRegulation.BizPrefix.TASK)
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);



}
