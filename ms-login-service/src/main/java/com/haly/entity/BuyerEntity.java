package com.haly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.haly.entity.common.DateItemEntity;

@Entity
@Table(name = "buyer_profile_tbl")
public class BuyerEntity extends DateItemEntity implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2305639287530146074L;

	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "buyer_id")
    private String buyerId;

    @Column(name = "buyer_name")
    private String buyerName;

    @Column(name = "password")
    private String password;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "mobile_number")
    private String mobileNumber;
    
    @Column(name = "postal_address")
    private String postalAddress;

	public BuyerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuyerEntity(String buyerId, String buyerName, String email, String mobileNumber, String postalAddress) {
		super();
		this.buyerId = buyerId;
		this.buyerName = buyerName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.postalAddress = postalAddress;
	}
	
	@Override
	public String toString() {
		return "BuyerEntity [buyerId=" + buyerId + ", buyerName=" + buyerName + ", email=" + email 
				+ ", mobileNumber=" + mobileNumber + ", postalAddress=" + postalAddress  + "]";
	}
	/**
	 * @return the buyerId
	 */
	public String getBuyerId() {
		return buyerId;
	}

	/**
	 * @param buyerId the buyerId to set
	 */
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	/**
	 * @return the buyerName
	 */
	public String getBuyerName() {
		return buyerName;
	}

	/**
	 * @param buyerName the buyerName to set
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the postalAddress
	 */
	public String getPostalAddress() {
		return postalAddress;
	}

	/**
	 * @param postalAddress the postalAddress to set
	 */
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

}
