package com.dream.springbootframe.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.springbootframe.demo.entity.DemoUser;
import com.dream.springbootframe.demo.service.DemoUserService;

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
	@RequestMapping("/add")
	public String addUser(DemoUser user) {
		demoUserService.addUser(user);
		return "redirect:/";
	}

	/**
	 * 删
	 */
	@RequestMapping("/delete")
	public String delete(String id) {
		demoUserService.deleteUser(id);
		return "redirect:/";
	}

	/**
	 * 改
	 */
	@RequestMapping("/update")
	public String updateUser(DemoUser user) {
		demoUserService.updateUser(user);
		return "redirect:/";
	}

	/**
	 * 查list
	 */
	@RequestMapping("")
	public String listUser() {
		return "listpage";
	}
	@RequestMapping("/list")
	@ResponseBody
	public List<Map<String, Object>> selectAllUser() {
		return demoUserService.selectAllUser();
	}

	/**
	 * 测试富文本
	 */
	@RequestMapping("/test")
	public String test() {
		return "text";
	}
	
	
	
}
