package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bean.Invoice;

public interface InvoiceDAO extends JpaRepository<Invoice, Integer>{

}
