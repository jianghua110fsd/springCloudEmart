package com.haly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.haly.entity.common.DateItemEntity;

@Entity
@Table(name = "product_tbl")
@EntityListeners(AuditingEntityListener.class)
public class ProductEntity extends DateItemEntity implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2305639287530146074L;

	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "category_id")
    private String categoryId;
    
    @Column(name = "category_name")
    private String categoryName;
    
    @Column(name = "subcategory_id")
    private String subcategoryId;
    
    @Column(name = "subcategory_name")
    private String subcategoryName;
    
    @Column(name = "seller_id")
    private String sellerId;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "unit")
    private String unit;
    
    @Column(name = "current_price")
    private float currentPrice;
    
    @Column(name = "current_stock")
    private int currentStock;
    
    @Column(name = "remarks")
    private String remarks;

    
    ProductEntity () {
    	
    }
    		
    public ProductEntity (String productId, String productName, String description,
    		float price, int stock) {
    	this.productId = productId;
    	this.productName = productName;
    	this.description = description;
    	this.currentPrice = price;
    	this.currentStock = stock;
    }
    
    public ProductEntity (String productId, String productName, String categoryId, String categoryName,  
    		String subcategoryId, String subcategoryName, String sellerId, String unit, 
    		String description, float price, int stock) {
    	this.productId = productId;
    	this.productName = productName;
    	this.categoryId = categoryId;
    	this.categoryName = categoryName;
    	this.subcategoryId = subcategoryId;
    	this.subcategoryName = subcategoryName;
    	this.sellerId = sellerId;
    	this.unit = unit;
    	this.description = description;
    	this.currentPrice = price;
    	this.currentStock = stock;
    }
    
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(String subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


}
