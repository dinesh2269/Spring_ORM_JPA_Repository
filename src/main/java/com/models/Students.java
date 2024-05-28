package com.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "students_table")
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long student_id;

	private String name;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })

	@JoinTable(

			name = "students_courses_table",

			joinColumns = @JoinColumn(name = "student_id"),

			inverseJoinColumns = @JoinColumn(name = "course_id")

	)
	private Set<Courses> courses = new HashSet<>();

	// Constructors, getters, and setters
	// Default constructor
	public Students() {

	}

	// Constructor with name

	public Students(String name) {

		this.name = name;

	}

	// Getters and setters

	public Long getId() {

		return student_id;

	}

	public void setId(Long id) {

		this.student_id = id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public Set<Courses> getCourses() {

		return courses;

	}

	public void setCourses(Set<Courses> courses) {

		this.courses = courses;

	}

	@Override
	public String toString() {
		return "Students [student_id=" + student_id + ", name=" + name + "]";
	}

}