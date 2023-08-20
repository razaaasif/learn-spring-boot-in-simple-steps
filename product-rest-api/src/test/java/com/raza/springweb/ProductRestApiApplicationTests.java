package com.raza.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.raza.springweb.entity.Product;
import static org.junit.Assert.*;

@SpringBootTest
class ProductRestApiApplicationTests {
	private final static String URL = "http://localhost:8080/api/v/products/";

	@Test
	void getProducts() {
		RestTemplate rest = new RestTemplate();
		Product p = rest.getForObject(URL + "7", Product.class);
		assertNotNull(p);
		assertEquals("IPhone 14 - 1", p.getName());
	}

	@Test
	void testCreateProduct() {
		Product p = new Product("Samsung", "Samsung India", 2000);
		RestTemplate rest = new RestTemplate();
		Product px = rest.postForObject(URL, p, Product.class);
		assertNotNull(px.getId()); ;
	}

}
