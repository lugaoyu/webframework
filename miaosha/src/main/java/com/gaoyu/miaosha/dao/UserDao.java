package com.gaoyu.miaosha.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gaoyu.miaosha.domain.User;

/**
 * 
 * ClassName: UserDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月21日 下午8:52:21 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@Mapper
public interface UserDao
{
        
        @Select("select * from user where id = #{id}")
        public User getById(int id);
        
        @Insert("insert into user(id,name)values(#{id},#{name})")
        public int insert(User user);
}
