/**
 * 
 */
package com.haly.service;
import com.haly.entity.BuyerEntity;
import com.haly.entity.SellerEntity;

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
	BuyerEntity saveBuyer(BuyerEntity buyerInfo);

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
	SellerEntity saveSeller(SellerEntity sellerInfo);
}
