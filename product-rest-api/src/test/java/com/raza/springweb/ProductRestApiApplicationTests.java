package com.raza.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.raza.springweb.entity.Product;
import static org.junit.Assert.*;

@SpringBootTest
class ProductRestApiApplicationTests {
	@Value("${url}")
	private String URL;

	@Test
	void getProducts() {
		System.out.println("URL -> " + URL);
		RestTemplate rest = new RestTemplate();
		Product p = rest.getForObject(URL + "7", Product.class);
		assertNotNull(p);
		assertEquals("IPhone 14 - 1", p.getName());
	}

	@Test
	void testCreateProduct() {
		System.out.println("URL -> " + URL);
		Product p = new Product("Samsung", "Samsung India", 2000);
		RestTemplate rest = new RestTemplate();
		Product px = rest.postForObject(URL, p, Product.class);
		assertNotNull(px.getId());
		;
	}

}
