package com.dream.springbootframe.jpa.controller;


import com.dream.springbootframe.jpa.entity.Student;
import com.dream.springbootframe.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 
 * @author Dream
 * 2018年1月31日
 *
 *
 */
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/findAll")
	public List<Student> findAll(int sort) {
		return sort == 1 ? studentService.findAll(new Sort(Sort.Direction.DESC, "name")) : studentService.findAll();
	}

	@RequestMapping("/findAllByIds")
	public List<Student> findAllById(Iterable<String> id) {
		return studentService.findAllById(id);
	}

	@RequestMapping("/saveAll")
	public List<Student> saveAll(Iterable<Student> students) {
		return studentService.saveAll(students);
	}

	@RequestMapping("/flush")
	public String flush() {
		studentService.flush();
		return "flush";
	}

	@RequestMapping("/saveAndFlush")
	public Student saveAndFlush(Student student) {
		return studentService.saveAndFlush(student);
	}

	@RequestMapping("/deleteInBatch")
	public String deleteInBatch(Iterable<Student> students) {
		studentService.deleteInBatch(students);
		return "deleteAllInBatch";
	}

	@RequestMapping("/deleteAllInBatch")
	public String deleteAllInBatch() {
		studentService.deleteAllInBatch();
		return "deleteAllInBatch";
	}

	@RequestMapping("/getOne")
	public Student getOne(String id) {
		return studentService.getOne(id);
	}

	@RequestMapping("/findAllStudents")
	public List<Student> findAll(int sort, Example<Student> students) {
		return sort == 1 ? studentService.findAll(students, new Sort(Sort.Direction.DESC, "name")) : studentService.findAll(students);
	}



}
