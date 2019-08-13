package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Product;

@Repository
/*
 * Using JpaRepository to get build-in CURD operations
 * */
public interface ProductRepo extends JpaRepository<Product, String>{
	
}

