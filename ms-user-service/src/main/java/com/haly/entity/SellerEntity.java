package com.haly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.haly.entity.common.DateItemEntity;

@Entity
@Table(name = "seller_profile_tbl")
@EntityListeners(AuditingEntityListener.class)
public class SellerEntity extends DateItemEntity implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2305639287530146074L;
	
	
	@Id
	@Column(name = "seller_id")
	private String sellerId;
	
	@Column(name = "seller_name")
	private String sellerName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "GSTIN")
	private String GSTN;
	
	@Column(name = "company_brief")
	private int companyBrief;
	
	@Column(name = "postal_address")
	private String postalAddress;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "contact_number")
	private String contactNumber;

	/**
	 * @return the sellerId
	 */
	public String getSellerId() {
		return sellerId;
	}

	/**
	 * @param sellerId the sellerId to set
	 */
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	/**
	 * @return the sellerName
	 */
	public String getSellerName() {
		return sellerName;
	}

	/**
	 * @param sellerName the sellerName to set
	 */
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the gSTN
	 */
	public String getGSTN() {
		return GSTN;
	}

	/**
	 * @param gSTN the gSTN to set
	 */
	public void setGSTN(String gSTN) {
		GSTN = gSTN;
	}

	/**
	 * @return the companyBrief
	 */
	public int getCompanyBrief() {
		return companyBrief;
	}

	/**
	 * @param companyBrief the companyBrief to set
	 */
	public void setCompanyBrief(int companyBrief) {
		this.companyBrief = companyBrief;
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

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
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
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
    
}
