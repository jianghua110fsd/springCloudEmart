package com.haly.entity.request;

public class SearchConditionForSellerEntity extends PageEntiy{
    
    private String sellerId;
    
    private String buyerName;

    private String purchaseDateFrom;
    
    private String purchaseDateTo;


	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getPurchaseDateFrom() {
		return purchaseDateFrom;
	}

	public void setPurchaseDateFrom(String purchaseDateFrom) {
		this.purchaseDateFrom = purchaseDateFrom;
	}

	public String getPurchaseDateTo() {
		return purchaseDateTo;
	}

	public void setPurchaseDateTo(String purchaseDateTo) {
		this.purchaseDateTo = purchaseDateTo;
	}
    
}
