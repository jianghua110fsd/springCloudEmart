/**
 * 
 */
package com.haly.service;
import com.haly.entity.BuyerEntity;
import com.haly.entity.SellerEntity;
import com.haly.pojo.BuyerSignServicePojo;
import com.haly.pojo.SellerSignServicePojo;

/**
 * @author JiangHua
 *
 */
public interface UserMaintenanceService {

    /**
     * get BuyerInfo
     * @param buyerId
     * @return
     */
	BuyerEntity getBuyerInfo(String buyerId);
    /**
     * insert buyer
     * @param buyerInfo
     * @return
     */
	BuyerSignServicePojo saveBuyer(BuyerSignServicePojo buyerPojo);

    /**
     * get SellerInfo
     * @param sellerId
     * @return
     */
	SellerEntity getSellerInfo(String sellerId);
	
    /**
     * insert seller
     * @param sellerInfo
     * @return
     */
	SellerSignServicePojo saveSeller(SellerSignServicePojo sellerPojo);
}
