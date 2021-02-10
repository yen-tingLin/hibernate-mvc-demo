package com.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.mvc.dao.StudentDao;
import com.demo.mvc.entity.Student;


@Controller
@RequestMapping("/student")
public class StudentController {
	
	// inject student dao
	@Autowired
	private StudentDao<Student> studentDao;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	public String listStudent(Model model) {		
		// get students from dao
		List<Student> allStudents = studentDao.retrieveAll();
		// add the students to the model
		model.addAttribute("all_students", allStudents);
		
		return "list-students";
	}
	
	@RequestMapping("/id")
	public String displayStudentById(Model model) {
		// get student from dao
		Student student = studentDao.retrieveById(6);
		// add the student to the model
		model.addAttribute("student_by_id", student);

		return "list-students";
	}
	
}
