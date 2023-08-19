package com.raza.springdatajpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raza.springdatajpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
