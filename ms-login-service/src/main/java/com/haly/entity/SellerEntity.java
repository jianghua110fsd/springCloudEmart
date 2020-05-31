package com.haly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.haly.entity.common.DateItemEntity;

@Entity
@Table(name = "seller_profile_tbl")
public class SellerEntity extends DateItemEntity implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2305639287530146074L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seller_id")
	private String sellerId;
	
	@Column(name = "seller_name")
	private String sellerName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "GSTIN")
	private String gstin;
	
	@Column(name = "company_brief")
	private String companyBrief;
	
	@Column(name = "postal_address")
	private String postalAddress;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "contact_number")
	private String contactNumber;

	public SellerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SellerEntity(String sellerId, String sellerName, String companyName, String gstin, String companyBrief,
			String postalAddress, String website, String email, String contactNumber) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.companyName = companyName;
		this.gstin = gstin;
		this.companyBrief = companyBrief;
		this.postalAddress = postalAddress;
		this.website = website;
		this.email = email;
		this.contactNumber = contactNumber;
	}
	
	@Override
	public String toString() {
		return "SellerEntity [sellerId=" + sellerId + ", sellerName=" + sellerName + ", companyName=" + companyName 
	            + ", gstin=" + gstin + ", companyBrief=" + companyBrief + ", postalAddress=" + postalAddress
				+ ", website=" + website + ", email=" + email + ", contactNumber=" + contactNumber + "]";
	}
	
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
	 * @return the gstin
	 */
	public String getGstin() {
		return gstin;
	}

	/**
	 * @param gstin the gstin to set
	 */
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	/**
	 * @return the companyBrief
	 */
	public String getCompanyBrief() {
		return companyBrief;
	}

	/**
	 * @param companyBrief the companyBrief to set
	 */
	public void setCompanyBrief(String companyBrief) {
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
