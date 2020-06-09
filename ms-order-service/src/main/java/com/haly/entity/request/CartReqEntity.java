package com.haly.entity.request;

public class CartReqEntity implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1464742559111710266L;

	
    private String buyerId;
    
	private String productId;
	
	private String productName;
	
    private String sellerId;
    
    private float purchasePrice;
    
    private int purchaseNum;
    
    private String remarks;
    
    private boolean fromDetail;
    

    CartReqEntity() {}
    
    public CartReqEntity(String buyerId, String productId, String productName, String sellerId, 
    		float purchasePrice, int purchaseNum, String remarks) {
    	this.buyerId = buyerId;
    	this.productId = productId;
    	this.productName = productName;
    	this.sellerId = sellerId;
    	this.purchasePrice = purchasePrice;
    	this.purchaseNum = purchaseNum;
    	this.remarks = remarks;
    }

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public boolean isFromDetail() {
		return fromDetail;
	}

	public void setFromDetail(boolean fromDetail) {
		this.fromDetail = fromDetail;
	}

}
