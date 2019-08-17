package com.cg.bean;

public class SortingFormat {

	private String category;
	private String sortingType;
	public SortingFormat() {
		// TODO Auto-generated constructor stub
	}
	public SortingFormat(String category, String sortingType) {
		super();
		this.category = category;
		this.sortingType = sortingType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSortingType() {
		return sortingType;
	}
	public void setSortingType(String sortingType) {
		this.sortingType = sortingType;
	}
	
	
}
