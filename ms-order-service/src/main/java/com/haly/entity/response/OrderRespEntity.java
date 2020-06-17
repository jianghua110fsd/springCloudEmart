package com.haly.entity.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderRespEntity implements java.io.Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4685660855187453857L;

	private int orderNo;
    
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date orderDate;

	private String productId;
	
	private String productName;
	
    private String categoryName;
    
    private String subcategoryName;
    
    private String unit;
    
    private float purchasePrice;
    
    private int purchaseNum;
    
    private float purchaseAmount;
    
    OrderRespEntity() {}
    
    public OrderRespEntity(int orderNo, Date orderDate, String productId, String productName,
    						String categoryName, String subcategoryName, String unit,
    						float purchasePrice, int purchaseNum, float purchaseAmount) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.productId = productId;
        this.productName = productName;
        this.categoryName = categoryName;
        this.subcategoryName = subcategoryName;
        this.unit = unit;
        this.purchasePrice = purchasePrice;
        this.purchaseNum = purchaseNum;
        this.purchaseAmount = purchaseAmount;
      }

    public OrderRespEntity(int orderNo, Date orderDate, String productId, String productName,
    		float purchasePrice, int purchaseNum, float purchaseAmount) {
    	this.orderNo = orderNo;
    	this.orderDate = orderDate;
    	this.productId = productId;
    	this.productName = productName;
    	this.purchasePrice = purchasePrice;
    	this.purchaseNum = purchaseNum;
    	this.purchaseAmount = purchaseAmount;
    }


    
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(int purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public float getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(float purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

}
