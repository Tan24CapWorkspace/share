package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.bean.Review;

public interface ReviewDAO extends JpaRepository<Review, Integer>{

}
