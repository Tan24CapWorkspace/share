package com.cg.service;

import java.util.List;

import com.cg.entities.Product;

public interface ProductService {
	public boolean addProduct(Product product);
	public boolean deleteProduct(String id);
	public List<Product> getAllProducts();
	public Product findProduct(String id);
	public boolean updateProduct(Product product, String id);
}
