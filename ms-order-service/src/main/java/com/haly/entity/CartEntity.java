package com.haly.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.haly.entity.common.DateItemEntity;

@Entity
@Table(name = "cart_tbl")
@EntityListeners(AuditingEntityListener.class)
public class CartEntity extends DateItemEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8974551808519453006L;

	@EmbeddedId
	private CartEntityPk cartPk;
	
	@Column(name = "product_name")
	private String productName;
	
    @Column(name = "seller_id")
    private String sellerId;
    
    @Column(name = "purchase_price")
    private float purchasePrice;
    
    @Column(name = "purchase_num")
    private int purchaseNum;
    
    @Column(name = "purchase_amount")
    private float purchaseAmount;
    
    @Column(name = "remarks")
    private String remarks;


    CartEntity () {}
    
    public CartEntity(CartEntityPk pk) {
    	this.cartPk = pk;
    }
    
	public CartEntityPk getCartPk() {
		return cartPk;
	}

	public void setCartPk(CartEntityPk cartPk) {
		this.cartPk = cartPk;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
