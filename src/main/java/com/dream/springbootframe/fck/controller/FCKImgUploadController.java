package com.dream.springbootframe.fck.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * 
 * @author Dream
 * 2018年2月5日
 *
 *FCKeditor富文本上传文件
 *
 *	要把上传图片的路径在/com.dream.springbootframe/src/main/resources/static/ckeditor/config.js文件内配置
 *		config.filebrowserUploadUrl="/imgUpdate/upfile"
 */
@Controller
@RequestMapping("/imgUpdate")
public class FCKImgUploadController {

	/**
	 * 
	 * @return 跳转页面
	 */
	@RequestMapping("/toindex")
	public String addUser() {
		return "index";
	}
	
	/**
	 * 上传图片
	 * @return
	 */
	@RequestMapping(value="/upfile")
	public void uploadFile(@RequestParam("upload") MultipartFile multipartFile,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
		String filename = multipartFile.getOriginalFilename();
		//得到文件上传的服务器路径	后面拼接static加跳转页面的@RequestMapping("/imgUpdate")内的路径
		//这个上传到项目内
//		String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static\\imgUpdate\\";
		//上传到tomcat的临时文件路径
		String path = request.getSession().getServletContext().getRealPath("") + "\\imgUpdate\\";
		
		//解决文件同名问题
		filename = UUID.randomUUID().toString().replace("-", "")+filename.substring(filename.lastIndexOf("."));
		
		//定义服务器的新文件
		File newFile = new File(path+filename);
		File f = null;
		try {
		    f=File.createTempFile("tmp", null);
		    multipartFile.transferTo(f);
		  //真正上传
		    FileUtils.copyFile(f, newFile);
		    f.deleteOnExit();        
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		PrintWriter out;
		String s = "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction("+CKEditorFuncNum+", '"+filename+"');</script>";
		try {
			out = response.getWriter();
			out.print(s);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
