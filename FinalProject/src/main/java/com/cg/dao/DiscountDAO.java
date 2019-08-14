package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bean.Discount;

public interface DiscountDAO extends JpaRepository<Discount, Integer>{

}
