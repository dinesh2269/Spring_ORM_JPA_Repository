package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.models.Students;

public interface StudentRepository extends JpaRepository<Students, Long> {

}
