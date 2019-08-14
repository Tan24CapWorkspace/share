package com.cg.dao;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.bean.Product;

/**
 * @author Tanmay Pathak
 * */
public interface ProductDAO extends JpaRepository<Product, Integer>{
	
	@Query("select p from Product p where category = ?1 and subcategory = ?2")
	public List<Product> getProductsFiltered(String category, String subcategory);
	
}
