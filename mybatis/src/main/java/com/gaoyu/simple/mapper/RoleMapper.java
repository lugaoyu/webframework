package com.gaoyu.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.gaoyu.simple.model.SysRole;

/**
 * 
 * ClassName: RoleMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年4月2日 上午10:21:34 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public interface RoleMapper
{
    @Select(
    {"select id,role_name roleName, enabled, create_by createBy, create_time createTime from sys_role where id=#{id}"})
    SysRole selectById(Long id);
    
    @Results({@Result(property="id",column="id",id=true),
              @Result(property="roleName",column="role_name"),
              @Result(property="enabled",column="enabled"),
              @Result(property="createBy",column="create_by"),
              @Result(property="createTime",column="create_time")})
    @Select({"select id,role_name,enabled,create_by,create_time from sys_role where id=#{id}"})
    SysRole selectById2(Long id);
    
    
    /*@Results(id="roleResultMap",value={@Result(property="id",column="id",id=true),
                                       @Result(property="roleName",column="role_name"),
                                       @Result(property="enabled",column="enabled"),
                                       @Result(property="createBy",column="create_by"),
                                       @Result(property="createTime",column="create_time")})
    @ResultMap("roleResultMap")
    @Select("select * from sys_role")
    List<SysRole> selectAll();*/
    
    @Insert(
    {"insert into sys_role(id,role_name,enabled,create_by,create_time) values(#{id},#{roleName},#{enabled},#{createBy},#{createTime})" })
    int insert(SysRole sysRole);
    
    @Insert(
        {"insert into sys_role(id,role_name,enabled,create_by,create_time) values(#{id},#{roleName},#{enabled},#{createBy},#{createTime})" })
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insert2(SysRole sysRole);
    /**
     * 非自增主键
     * @param sysRole
     * @return 非自增主键key
     */
    @Insert(
        {"insert into sys_role(id,role_name,enabled,create_by,create_time) values(#{id},#{roleName},#{enabled},#{createBy},#{createTime})" })
    @SelectKey(statement="select last_insert_id()",keyProperty="id",resultType=Long.class,before=false)
    int insert3(SysRole sysRole);
    
    @Update({"update sys_role set role_name=#{roleName},enabled=#{enabled},create_by=#{createBy},create_time=#{createTime} where id=#{id}" })
    int updateById(SysRole sysRole);
    
    @Delete({"delete from sys_role where id=#{id}"})
    int deleteById(Long id);
}
