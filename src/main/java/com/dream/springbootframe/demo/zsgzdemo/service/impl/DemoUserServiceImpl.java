package com.dream.springbootframe.demo.zsgzdemo.service.impl;

import com.dream.springbootframe.demo.zsgzdemo.dao.DemoUserDao;
import com.dream.springbootframe.demo.zsgzdemo.entity.DemoUser;
import com.dream.springbootframe.demo.zsgzdemo.service.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;



/**
 * 
 * @author Dream
 *
 *
 */
@Service
@Transactional
public class DemoUserServiceImpl implements DemoUserService {

	@Autowired
	private DemoUserDao demoUserDao;
	
	/**
	 * 增
	 */
	@Override
	public int addUser(DemoUser user) {
		return demoUserDao.addUser(user);
	}

	/**
	 * 删
	 */
	@Override
	public int deleteUser(String id) {
		return demoUserDao.deleteUser(id);
	}

	/**
	 * 改
	 */
	@Override
	public int updateUser(DemoUser user) {
		return demoUserDao.updateUser(user);
	}

	/**
	 * 查list
	 */
	@Override
	public List<Map<String, Object>> selectAllUser() {
		return demoUserDao.selectAllUser();
	}

	/**
	 * 查find
	 */
	@Override
	public DemoUser selectFindOneUserByIdOrName(DemoUser user) {
		return demoUserDao.selectFindOneUserByIdOrName(user);
	}

	
}
