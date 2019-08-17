package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bean.SecurityAns;

public interface SecurityDAO extends JpaRepository<SecurityAns, String>{

}
