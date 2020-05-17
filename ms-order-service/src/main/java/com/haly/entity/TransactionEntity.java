package com.haly.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.haly.entity.common.DateItemEntity;

@Entity
@Table(name = "transaction_tbl")
public class TransactionEntity extends DateItemEntity implements java.io.Serializable  {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3415794716999010868L;

	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "transaction_type")
    private String transactionType;
    
    @Column(name = "buyer_id")
    private String buyerId;

    @Column(name = "transaction_amount")
    private float transactionAmount;
    
    @Column(name = "transaction_date")
    private Date transactionDate;
    
    @Column(name = "remarks")
    private String remarks;

    
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
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
