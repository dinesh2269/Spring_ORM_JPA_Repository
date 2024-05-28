package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.models.Courses;

public interface CourseRepository extends JpaRepository<Courses, Long> {

}
