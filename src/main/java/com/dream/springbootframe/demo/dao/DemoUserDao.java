package com.dream.springbootframe.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dream.springbootframe.demo.entity.DemoUser;
@Mapper
public interface DemoUserDao {

	/**
	 * 增
	 */
	@Insert("insert into user(id, name) values(uuid(), #{name})")
	int addUser(DemoUser user);
	
	/**
	 * 删
	 */
	@Delete("delete from user where id = #{id}")
	int deleteUser(String id);
	
	/**
	 * 改
	 */
	@Update("update user set name = #{name} where id = #{id}")
	int updateUser(DemoUser user);
	
	/**
	 * 查list
	 */
	@Select("select id, name from user")
	List<Map<String, Object>> selectAllUser();
	
	/**
	 * 查find
	 */
	@Select("select id, name from user where id = #{id}")
	DemoUser selectFindOneUserByIdOrName(DemoUser user);
	
}
