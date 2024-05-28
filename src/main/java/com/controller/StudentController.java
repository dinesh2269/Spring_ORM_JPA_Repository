package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.models.Students;
import com.service.StudentService;

@Controller
public class StudentController {

	StudentService stdService;

	@Autowired

	public StudentController(StudentService ss) {

		stdService = ss;

	}

	@RequestMapping(value = "/stdlist", method = RequestMethod.GET)

	public String getAllEmployees(Model model) {

		System.out.println("Students List JSP Requested");

		// get all employees from DAO

		List<Students> stdList = stdService.findAll();
		for (Students std : stdList) {
			System.out.println(std.toString());
		}

		// set it to the model

		model.addAttribute("slist", stdList);

		// call the view

		return "stdlist";

	}

	@RequestMapping(value = "/enroll", method = RequestMethod.GET)

	public String saveNewStudent(Model model) {

		System.out.println("Enroll Students in Courses");

		// ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//
		// StudentService studentService = context.getBean(StudentService.class);

		stdService.enrollStudentInCourse();

		return "enrollsuccess";

	}

	/*
	 * 
	 * Above method is supposed to be a post call like this
	 * 
	 * 
	 * 
	 * @RequestMapping(value = "/enroll", method = RequestMethod.POST)
	 * 
	 * public String saveNewStudent(Student std, Model model) {
	 * 
	 * 
	 * 
	 * System.out.println("Enroll Students in Courses");
	 * 
	 * 
	 * 
	 * ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	 * 
	 * 
	 * 
	 * StudentService studentService = context.getBean(StudentService.class);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * studentService.enrollStudentInCourse(<std>);
	 * 
	 * return "enrollsuccess";
	 * 
	 * }
	 * 
	 */

}