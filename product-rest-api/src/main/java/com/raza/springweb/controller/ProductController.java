package com.raza.springweb.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raza.springweb.entity.Product;
import com.raza.springweb.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping
	public List<Product> getProducts() {
		return this.productRepository.findAll();
	}

	@GetMapping("{id}")
	public Product getById(@PathVariable("id") Integer id) {
		logger.info("Finding product by id " + id);
		return this.productRepository.findById(id).orElse(null);
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return this.productRepository.save(product);
	}

	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		return this.productRepository.save(product);
	}

	@DeleteMapping("{id}")
	public Map<String, String> delete(@PathVariable("id") Integer id) {
		Map<String, String> map = new HashMap<>();
		this.productRepository.deleteById(id);
		map.put("STATUS", HttpStatus.OK.toString());
		map.put("message", "generic_succes");
		return map;
	}
}
