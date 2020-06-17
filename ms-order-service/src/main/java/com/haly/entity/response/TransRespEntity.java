package com.haly.entity.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransRespEntity extends OrderRespEntity implements java.io.Serializable  {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3703180453508203005L;
	

	private int transactionId;
	
	private String buyerId;
	
	private String buyerName;
	
	private float transactionAmount;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date transactionDate;
    
	private String remarks;
	
    
    public TransRespEntity(int orderNo, Date orderDate, String productId, String productName,
    						float purchasePrice, int purchaseNum, float purchaseAmount, 
    						int transactionId, String buyerId, String buyerName, 
    						float transactionAmount, Date transactionDate, String remarks) {
    	super(orderNo, orderDate, productId, productName, purchasePrice, purchaseNum, purchaseAmount);
        this.transactionId = transactionId;
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.remarks = remarks;
      }

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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

	public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
