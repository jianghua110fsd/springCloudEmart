package com.haly.entity.response;

public class CartRespEntity implements java.io.Serializable  {

    
	/**
	 * 
	 */
	private static final long serialVersionUID = 3514649917298111057L;


	private String buyerId;
	
	private String productId;
	
	private String productName;
	
	private String sellerId;
	
    private String categoryName;
    
    private String subcategoryName;
    
    private String unit;
    
    private float purchasePrice;
    
    private int purchaseNum;
    
    private float purchaseAmount;
    
    private String remarks;
    
    CartRespEntity() {}
    
    public CartRespEntity(String buyerId, String productId, String productName, String sellerId, 
    						String categoryName, String subcategoryName, String unit,
    						float purchasePrice, int purchaseNum, float purchaseAmount, String remarks) {
        this.buyerId = buyerId;
        this.productId = productId;
        this.productName = productName;
        this.sellerId = sellerId;
        this.categoryName = categoryName;
        this.subcategoryName = subcategoryName;
        this.unit = unit;
        this.purchasePrice = purchasePrice;
        this.purchaseNum = purchaseNum;
        this.purchaseAmount = purchaseAmount;
        this.remarks = remarks;
      }

    
	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
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

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
