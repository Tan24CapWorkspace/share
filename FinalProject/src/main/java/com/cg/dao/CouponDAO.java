package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bean.Coupon;

public interface CouponDAO extends JpaRepository<Coupon,Integer>{

}
