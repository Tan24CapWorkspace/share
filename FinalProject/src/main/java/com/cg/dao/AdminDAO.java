package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bean.Admin;

public interface AdminDAO extends JpaRepository<Admin,Integer>{

}
