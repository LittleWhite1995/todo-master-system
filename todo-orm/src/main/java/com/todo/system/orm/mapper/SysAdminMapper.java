package com.todo.system.orm.mapper;

import com.todo.system.entity.po.SysAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysAdminMapper {

    @Select("select * from sys_admin where user_name=#{userName} limit 0,1")
    SysAdmin selectSingleByName(@Param("userName") String userName);

    @Select("select * from sys_admin where user_name=#{userName} and password=#{password} limit 0,1")
    SysAdmin selectSingleByNameAndPwd(@Param("userName") String userName, @Param("password") String password);

}
