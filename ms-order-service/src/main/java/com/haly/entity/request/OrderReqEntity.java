package com.haly.entity.request;

public class OrderReqEntity implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1464742559111710266L;

	
    private String buyerId;
    
    private String buyerName;

	private String productId;
	
	private String productName;
	
    private String sellerId;
    
    private float purchasePrice;
    
    private int purchaseNum;
    
    private float purchaseAmount;
    
    private String transactionType;
    
    private float transactionAmount;

    private String remarks;

    public OrderReqEntity(String buyerId, String buyerName, String productId, String productName, 
    		String sellerId, float purchasePrice, int purchaseNum, float purchaseAmount, 
    		String transactionType, float transactionAmount, String remarks) {
    	this.buyerId = buyerId;
    	this.buyerName = buyerName;
    	this.productId = productId;
    	this.productName = productName;
    	this.sellerId = sellerId;
    	this.purchasePrice = purchasePrice;
    	this.purchaseNum = purchaseNum;
    	this.purchaseAmount = purchaseAmount;
    	this.transactionType = transactionType;
    	this.transactionAmount = transactionAmount;
    	this.remarks = remarks;
    }

	public String getBuyerId() {
		return buyerId;
	}
	
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
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

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
