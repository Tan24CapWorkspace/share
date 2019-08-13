package com.cg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@Column(name="ProductId")
	private String id;
	@Column(name="ProductName")
	private String name;
	@Column(name="ProductModel")
	private String model;
	@Column(name="ProductPrice")
	private Double price;
	
	public Product() {
	}

	public Product(String id, String name, String model, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
