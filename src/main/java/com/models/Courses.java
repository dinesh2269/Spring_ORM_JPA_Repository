package com.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * @author DineshK
 *
 */
@Entity
@Table(name = "courses_table")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long course_id;

	private String title;

	@ManyToMany(mappedBy = "courses", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Students> students = new HashSet<>();

	// Constructors, getters, and setters

	// Default constructor

	public Courses() {

	}

	// Constructor with title

	public Courses(String title) {

		this.title = title;

	}

	// Getters and setters

	public Long getId() {

		return course_id;

	}

	public void setId(Long id) {

		this.course_id = id;

	}

	public String getTitle() {

		return title;

	}

	public void setTitle(String title) {

		this.title = title;

	}

	public Set<Students> getStudents() {

		return students;

	}

	public void setStudents(Set<Students> students) {

		this.students = students;

	}

	@Override
	public String toString() {
		return "Courses [course_id=" + course_id + ", title=" + title + "]";
	}

}
