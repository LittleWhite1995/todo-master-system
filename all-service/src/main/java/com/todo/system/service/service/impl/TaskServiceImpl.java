package com.todo.system.service.service.impl;

import com.todo.system.entity.bo.TaskInfoBo;
import com.todo.system.entity.po.TaskInfo;
import com.todo.system.orm.mapper.TaskMapper;
import com.todo.system.service.service.TaskService;
import com.todo.system.util.common.CommonCodes;
import com.todo.system.util.utils.PageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: com-todo-sysytem-parent
 * @description: TaskServiceImpl
 * @author: littleWhite
 * @create: 2019/5/23 15:39
 **/
@Service("taskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Override
    public String addTask(TaskInfoBo taskInfoBo) {
        boolean isNext=false;
        Date now = new Date();
        if(taskInfoBo.getId()!=null){
            TaskInfo taskInfo = taskMapper.selectByPrimaryKey(taskInfoBo.getId());
            BeanUtils.copyProperties(taskInfoBo,taskInfo);
            taskInfo.setUpdateTime(now);
            isNext = taskMapper.updateByPrimaryKeySelective(taskInfo) == CommonCodes.InsertStatus.SUCCESS;
        }else{
            TaskInfo taskInfo = new TaskInfo();
            BeanUtils.copyProperties(taskInfoBo,taskInfo);
            taskInfo.setId(new Long("7928458622046208"));
            taskInfo.setStatus(CommonCodes.TaskStatus.INITIALIZATION);
            taskInfo.setUpdateTime(now);
            taskInfo.setCreateTime(now);
            isNext = taskMapper.insertSelective(taskInfo) == CommonCodes.InsertStatus.SUCCESS;
        }

        if(isNext){
            return CommonCodes.ReturnStatus.SUCCESS;
        }else{
            return CommonCodes.ReturnStatus.ERROR;
        }
    }

    @Override
    public TaskInfo getTask(String id) {
        return taskMapper.selectByPrimaryKey(new Long(id));
    }

    @Override
    public PageVo<TaskInfoBo> taskList(TaskInfoBo taskInfoBo) {
        List<TaskInfoBo> taskInfoBoList = new ArrayList<>();
        int startNum = (taskInfoBo.getPage() - 1) * taskInfoBo.getPageSize();
        int endNum = taskInfoBo.getPageSize();
        List<TaskInfo> taskInfoList = taskMapper.queryTaskList(taskInfoBo.getMemberId(),startNum,endNum);
        Integer taskInfoListCount = taskMapper.queryTaskListCount(taskInfoBo.getMemberId());
        return new PageVo<>(taskInfoListCount,importTask(taskInfoList,taskInfoBoList));
    }

    @Override
    public String deleteTask(String id) {
        boolean isNext=false;

        isNext = taskMapper.deleteByPrimaryKey(new Long(id)) == CommonCodes.InsertStatus.SUCCESS;

        if(isNext){
            return CommonCodes.ReturnStatus.SUCCESS;
        }else{
            return CommonCodes.ReturnStatus.ERROR;
        }
    }

    private List<TaskInfoBo> importTask(List<TaskInfo> taskInfoList,List<TaskInfoBo> taskInfoBoList)  {
        for (TaskInfo taskInfo:taskInfoList) {
            TaskInfoBo taskInfoBo = new TaskInfoBo();
            BeanUtils.copyProperties(taskInfo,taskInfoBo);
            taskInfoBoList.add(taskInfoBo);
        }
        return taskInfoBoList;
    }
}
