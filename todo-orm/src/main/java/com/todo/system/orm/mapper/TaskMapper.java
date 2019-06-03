package com.todo.system.orm.mapper;

import com.todo.system.entity.po.TaskInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TaskInfo taskInfo);

    int insertSelective(TaskInfo taskInfo);

    TaskInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKey(TaskInfo taskInfo);

    int updateByPrimaryKeySelective(TaskInfo taskInfo);

    List<TaskInfo> queryTaskList(@Param("menberId") Long menberId, @Param("startNum") int startNum, @Param("endNum") int endNum);

    Integer queryTaskListCount(@Param("menberId") Long menberId);

}
