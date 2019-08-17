package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bean.Cart;

public interface CartDAO extends JpaRepository<Cart, Integer>{

}
