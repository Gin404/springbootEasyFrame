package com.dream.springbootframe.demo.service;

import java.util.List;
import java.util.Map;

import com.dream.springbootframe.demo.entity.DemoUser;

/**
 * 
 * @author Dream
 * 2018年1月31日
 *
 *
 */
public interface DemoUserService {

	/**
	 * 增
	 */
	int addUser(DemoUser user);
	
	/**
	 * 删
	 */
	int deleteUser(String id);
	
	/**
	 * 改
	 */
	int updateUser(DemoUser user);
	
	/**
	 * 查list
	 */
	List<Map<String, Object>> selectAllUser();
	
	/**
	 * 查find
	 */
	DemoUser selectFindOneUserByIdOrName(DemoUser user);

}
