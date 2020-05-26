package com.haly.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.haly.entity.common.DateItemEntity;

@Embeddable
public class CartEntityPk extends DateItemEntity implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4493084902309559201L;

    @Column(name = "buyer_id")
    private String buyerId;

	@Column(name = "product_id")
	private String productId;

	public CartEntityPk (String buyerId, String productId) {
		this.buyerId = buyerId;
		this.productId = productId;
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

}
