package com.dream.springbootframe.demo.zsgzdemo.controller;


import com.dream.springbootframe.demo.zsgzdemo.entity.DemoUser;
import com.dream.springbootframe.demo.zsgzdemo.service.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Dream
 * 2018年1月31日
 *
 *
 */
@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private DemoUserService demoUserService;
	
	/**
	 * 增
	 */
	@RequestMapping("/add/page")
	public String addPage(DemoUser user, HttpServletRequest request, Model model) {
		if (user.getId() != null) {
			user = demoUserService.selectFindOneUserByIdOrName(user);
		}
		model.addAttribute("user", user);
		return "addpage";
	}
	//清除缓存
	@CacheEvict(value = "userlist", allEntries = true, beforeInvocation = true)
	@RequestMapping("/add")
	public String addUser(DemoUser user) {
		demoUserService.addUser(user);
		return "redirect:/";
	}

	/**
	 * 删
	 */
	//清除缓存
	@CacheEvict(value = "userlist", allEntries = true, beforeInvocation = true)
	@RequestMapping("/delete")
	public String delete(String id) {
		demoUserService.deleteUser(id);
		return "redirect:/";
	}

	/**
	 * 改
	 */
	//清除缓存
	@CacheEvict(value = "userlist", allEntries = true, beforeInvocation = true)
	@RequestMapping("/update")
	public String updateUser(DemoUser user) {
		demoUserService.updateUser(user);
		return "redirect:/";
	}

	/**
	 * 查list
	 * 已写入WebMvcPage
	 @see com.dream.springbootframe.config.WebMvcPage
	@RequestMapping("")
	public String listUser() {
		return "listpage";
	}
	 */
	//开启缓存
	@Cacheable(value = "userlist")
	@RequestMapping("/list")
	@ResponseBody
	public List<Map<String, Object>> selectAllUser() {
		return demoUserService.selectAllUser();
	}

}
