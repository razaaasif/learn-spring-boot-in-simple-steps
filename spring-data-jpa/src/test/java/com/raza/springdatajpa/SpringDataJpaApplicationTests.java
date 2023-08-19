package com.raza.springdatajpa;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.raza.springdatajpa.entity.Student;
import com.raza.springdatajpa.repo.StudentRepository;

@SpringBootTest
class SpringDataJpaApplicationTests {

	@Autowired
	private StudentRepository repository;

	@Test
	void testSaveStudent() {
		Student student = new Student();
		student.setId(1L);
		student.setName("Aasif Raza");
		student.setTestScore(100);
		repository.save(student);
		Student savedStudent = repository.findById(1L).get();
		assertNotNull(savedStudent);
	}

}
