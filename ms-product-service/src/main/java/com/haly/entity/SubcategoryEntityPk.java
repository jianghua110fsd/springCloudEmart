package com.haly.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SubcategoryEntityPk implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2786088494444553144L;
	

	@Column(name = "category_id")
    private String categoryId;
    
    @Column(name = "subcategory_id")
    private String subcategoryId;
    
    SubcategoryEntityPk () {}
    		
    public SubcategoryEntityPk (String categoryId, String subcategoryId) {
    	this.categoryId = categoryId;
    	this.subcategoryId = subcategoryId;
    }
    

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(String subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

}
