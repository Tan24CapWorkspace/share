package com.cg.service;

import java.util.ArrayList;
import java.util.List;
/**
 * Author: Tanmay Pathak
 * */
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Product;
import com.cg.dao.ProductDAO;
import com.cg.exception.ApplicationException;

@Service
@Transactional
public class ProductService{

	// To link the service and dao layer
	@Autowired
	private ProductDAO dao;
	
	public List<Product> getProducts(String category, String subcategory){
		return dao.getProductsFiltered(category, subcategory);
	}
	
	
	public List<Product> getSimilarProducts(String category, String subcategory, Integer productId){
		List<Product> list = getProducts(category, subcategory);
		
		List<Product> response = new ArrayList<>();
		
		Optional<Product> box = dao.findById(productId);
		if(box.isPresent()) {
			List<String> tagList = box.get().getTag();
			
			
			for(Product p : list) {
				Set<String> result = tagList.stream()
						  .distinct()
						  .filter(p.getTag()::contains)
						  .collect(Collectors.toSet());
				
				if(result.size() > 0) {
					System.out.println("Here");
					response.add(p);
				}
			}
		}
		return response;
	}
	
	
	
	public List<Product> getProducts(){
		return dao.findAll();
	}
	
	
}