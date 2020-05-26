package com.haly.pojo;

public class SellerPojo {
	
		private String sellerId;
		private String sellerName;
		private String companyName;
		private String GSTN;
		private String companyBrief;
		private String postalAddress;
		private String  website;
		private String email;
		private String contactNumber;
	    
		public SellerPojo() {
			super();
		}
		public SellerPojo(String sellerId, String sellerName, String companyName, String GSTN, String companyBrief,
				String postalAddress, String website, String email, String contactNumber) {
			super();
			this.sellerId = sellerId;
			this.sellerName = sellerName;
			this.companyName = companyName;
			this.GSTN = GSTN;
			this.companyBrief = companyBrief;
			this.postalAddress = postalAddress;
			this.website = website;
			this.email = email;
			this.contactNumber = contactNumber;
		}
		@Override
		public String toString() {
			return "SellerPojo [sellerId=" + sellerId + ", sellerName=" + sellerName + ", companyName=" + companyName 
					+ ", GSTN=" + GSTN + ", companyBrief=" + companyBrief + ", postalAddress=" + postalAddress + ", website=" + website
				    + ", email=" + email  + ", contactNumber=" + contactNumber + "]";
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

