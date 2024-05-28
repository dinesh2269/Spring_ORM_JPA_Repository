package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.models.Courses;
import com.models.Students;
import com.repositories.CourseRepository;
import com.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;

	/*
	 * @Transactional public void enrollStudentInCourse(Long studentId, Long courseId) {
	 * 
	 * 
	 */

	@Transactional
	public void enrollStudentInCourse() {
		// Create and save some students and courses
		Students student1 = new Students();
		student1.setName("Bhaskar Batla");
		Students student2 = new Students();
		student2.setName("Kiranmai");
		Courses course1 = new Courses();
		course1.setTitle("CSE 101");
		Courses course2 = new Courses();
		course2.setTitle("ECE 101");

		// Student student = studentRepository.findById(studentId).orElseThrow();

		// Course course = courseRepository.findById(courseId).orElseThrow();

		studentRepository.save(student1);
		studentRepository.save(student2);
		courseRepository.save(course1);
		courseRepository.save(course2);
		student1.getCourses().add(course1);
		student1.getCourses().add(course2);
		student2.getCourses().add(course2);

		studentRepository.save(student1);
		studentRepository.save(student2);

	}

	public List<Students> findAll() {
		return studentRepository.findAll();
	}

}
