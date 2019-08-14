package com.cg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Product;
import com.cg.bean.Review;
import com.cg.dao.AccountDAO;
import com.cg.exception.ApplicationException;
import com.cg.service.AccountService;
import com.sun.swing.internal.plaf.metal.resources.metal;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AppController {

	@Autowired
	private AccountService service;

	@Autowired
	private AccountDAO dao;
	
//	@PostConstruct
//	public void setup() {
//		//Product p = new Product(100, "Vivo Y 66", 100, null, "Vivo", null, "Nothing", new Review(), category, views, quantity, soldQuantities, price)
//		Product p = new Product(102, "Vivo", 100, null, "Vivo", null, "", "", "Electronics", "Mobile", 100, 100, 10, 100);
//		List<String> tags = new ArrayList<>();
//		tags.add("Vivo");
//		p.setTag(tags);
//		dao.saveAndFlush(p);
//	}
//	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addaccount")
	public List<Product> getProducts(@RequestParam String category, @RequestParam String subcategory) {
		try {
			return service.getProducts(category, subcategory);
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/similar")
	public List<Product> getSimilarProducts(@RequestParam String category, @RequestParam String subcategory, @RequestParam Integer productId) {
		try {
			return service.getSimilarProducts(category, subcategory, productId);
		} catch (ApplicationException ex) {
			return null;
		}
	}

}
