package com.todo.system.service.controller;

import com.todo.system.entity.bo.TaskInfoBo;
import com.todo.system.entity.po.TaskInfo;
import com.todo.system.service.service.TaskService;
import com.todo.system.util.utils.PageVo;
import com.todo.system.util.web.UrlRegulation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    TaskService taskService;

    @RequestMapping("/addTask")
    public String addMemberGift(@RequestBody TaskInfoBo memberContactBo){
        return taskService.addTask(memberContactBo);
    }

    @RequestMapping("/getTask")
    public TaskInfo getTask(String id){ return taskService.getTask(id); }

    @RequestMapping("/taskList")
    public PageVo<TaskInfoBo> memberContactList(TaskInfoBo memberListBo){
        return taskService.taskList(memberListBo);
    }

    @RequestMapping("/deleteTask")
    public String deleteTask(String id){
        return taskService.deleteTask(id);
    }


}
