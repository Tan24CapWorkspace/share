package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bean.Transaction;

public interface TransactionDAO extends JpaRepository<Transaction, Integer>{

}
