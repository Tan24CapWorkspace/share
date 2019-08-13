package com.cg.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.entities.Product;

import com.cg.exceptions.ApplicationException;
import com.cg.service.ProductService;
import com.cg.service.ProductServiceImpl;

import sun.print.resources.serviceui;

@RestController
@RequestMapping("/")
// http://localhost:3000/products
public class HomeController {
	
	@Autowired
	private ProductService service;
	
	/*
	 * @PostConstruct is used to enter dummy data in database.
	 * */
	@PostConstruct
	public String start() {
		Product p1 = new Product("i01", "Iphone", "6s", 45000D);
		Product p2 = new Product("s01", "Samsung", "Galaxy", 55000D);
		Product p3 = new Product("m01", "Motorola", "Motto M7", 29000D);
		service.addProduct(p1);
		service.addProduct(p2);
		service.addProduct(p3);
		return null;
	}
	
	
	/*
	 * getList() is used to get all products from database.
	 * Input : void
	 * Output : List<Product>
	 * */
	// http://localhost:3000/products
	@GetMapping(value="/products", produces= {"application/json"})
	public List<Product> getList() {
		return service.getAllProducts();
	}
	
	
	/*
	 * createProduct() used to create new product
	 * Input : Product object (Json format)
	 * Output : String Response (Json and text/html)
	 * */
	// http://localhost:3000/products
	@PostMapping(value="/products",consumes={"application/json"}, produces= {"application/json","text/html"})
	public String createProduct(@RequestBody Product product) {
		if(service.addProduct(product)) {
			return "Product with ID : "+product.getId()+" added successfully.";
		}else {
			return "Product with ID : "+product.getId()+" already present.";
		}
	}
	
	
	/*
	 * updateProduct() is used to update product
	 * Input : Product id, Product object
	 * Output : String Response
	 * */
	// http://localhost:3000/products
	@PutMapping(value="/products/{id}", consumes= {"application/json"})
	public String updateProduct(@PathVariable String id,@RequestBody Product product) {
		if(service.findProduct(id)!=null) {
			try {
				service.updateProduct(product,id);
				return "Product with ID : "+id+" updated successfully.";
			}catch(ApplicationException e) {
				return e.getMessage();
			}
		}else {
			return "The Product with ID : "+id+" not present.";
		}
	}
	
	
	/*
	 * deleteProduct() is used to delete Product from database
	 * Input : Product id
	 * Output : String Response
	 * */
	// http://localhost:3000/products
	@DeleteMapping(value="/products/{id}", consumes= {"application/json"})
	public String deleteProduct(@PathVariable String id) {
		if(service.deleteProduct(id)) {
			return "Product with Id : "+id+" Deleted successfully.";
		}else {
			return "Product with Id : "+id+" not present in database";
		}
	}
	
	
	/*
	 * getProduct() is used to get Product based on its ID
	 * Input : String ID
	 * Output : Product object (Json format)
	 * */
	// http://localhost:3000/products/{id}
	@GetMapping(value="/products/{id}", produces= {"application/json"})
	public Product getProduct(@PathVariable String id) {
		Product product = service.findProduct(id);
		if(product!=null) {
			return product;
		}else
			throw new ApplicationException("No such Product exist with ID : "+id);
	}
}
