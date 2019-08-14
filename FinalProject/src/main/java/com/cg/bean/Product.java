package com.cg.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer productID;
	
	@Column
	private String productName;
	
	@Column
	private Integer mechantId;
	
	@ElementCollection
	private List<String> tag;
	
	@Column 
	private String company;
	
	@Column
	private String photo;
	
	@Column 
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="Review.reviewId")
	private List<Review> review;
	
	@Column
	private String category;
	
	@Column
	private String subcategory;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, Integer mechantId, List<String> tag, String company, String photo,
			String description, List<Review> review, String category, String subcategory) {
		super();
		this.productName = productName;
		this.mechantId = mechantId;
		this.tag = tag;
		this.company = company;
		this.photo = photo;
		this.description = description;
		this.review = review;
		this.category = category;
		this.subcategory = subcategory;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getMechantId() {
		return mechantId;
	}

	public void setMechantId(Integer mechantId) {
		this.mechantId = mechantId;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	
}
