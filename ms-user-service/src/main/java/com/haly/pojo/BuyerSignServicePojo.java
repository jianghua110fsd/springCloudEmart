package com.haly.pojo;

public class BuyerSignServicePojo {
	
		private String buyerId;
		private String buyerName;
		private String password;
		private String email;
		private String mobileNumber;
		private String postalAddress;
	    
		public BuyerSignServicePojo() {
			super();
		}
		
		public BuyerSignServicePojo(String buyerId, String buyerName, String password,
				String email, String mobileNumber, String postalAddress) {
			super();
			this.buyerId = buyerId;
			this.buyerName = buyerName;
			this.password = password;
			this.email = email;
			this.mobileNumber = mobileNumber;
			this.postalAddress = postalAddress;
		}
		
		@Override
		public String toString() {
			return "SellerSignupServicePojo [buyerId=" + buyerId + ", buyerName=" + buyerName + ", password=" + password
				    + ", email=" + email  + ", mobileNumber=" + mobileNumber + ", postalAddress=" + postalAddress + "]";
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

