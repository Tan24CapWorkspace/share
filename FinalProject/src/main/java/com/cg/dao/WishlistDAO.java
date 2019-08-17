package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bean.Wishlist;

public interface WishlistDAO extends JpaRepository<Wishlist, Integer>{

}
