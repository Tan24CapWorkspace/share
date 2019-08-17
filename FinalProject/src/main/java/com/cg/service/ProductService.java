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
	
	// Sorting by products price in ascending order
		@Transactional(propagation = Propagation.REQUIRED)
		public List<Product> getProductsAsc(String productCategory) {
			List<Product> products = dao.findByProductCategoryOrderByProductPrice(productCategory);

			return products;
		}

		// Sorting by products price in descending order
		@Transactional(propagation = Propagation.REQUIRED)
		public List<Product> getProductsDesc(String productCategory) {
			List<Product> products1 = dao.findByProductCategoryOrderByProductPriceDesc(productCategory);
			return products1;
		}

/*		// For getting the most viewed product
		@Transactional(propagation = Propagation.REQUIRED)
		public List<Product> getMostViewed(String productCategory) {

			List<Product> product2 = dao.findByproductCategoryOrderByProductViewDesc(productCategory);
			return product2;

		}*/

		// For getting the best-seller product
		@Transactional(propagation = Propagation.REQUIRED)
		public List<Product> getBestSeller(String productCategory) {
			List<Product> product3 = dao.findByproductCategoryOrderByProductsSoldDesc(productCategory);
			return product3;
		}

		// For getting products in a given range of price
		@Transactional(propagation = Propagation.REQUIRED)
		public List<Product> getProductsInRange(String productCategory, int min, int max) {
			List<Product> product4 = dao.getProductsInRange(productCategory, min, max);
			return product4;
		}

	
}