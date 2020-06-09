package com.haly.entity.request;

public class CartDelReqEntity implements java.io.Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5362268797663583730L;
	

	private String buyerId;
    
	private String[] productIds;

	CartDelReqEntity(){}
	
	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String[] getProductIds() {
		return productIds;
	}

	public void setProductIds(String[] productIds) {
		this.productIds = productIds;
	}
	
	

}
