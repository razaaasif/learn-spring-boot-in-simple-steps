package com.raza.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raza.springweb.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
