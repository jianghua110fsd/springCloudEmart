/**
 * 
 */
package com.haly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.haly.dao.BuyerDao;
import com.haly.dao.SellerDao;
import com.haly.entity.BuyerEntity;
import com.haly.entity.SellerEntity;
import com.haly.pojo.BuyerSignServicePojo;
import com.haly.pojo.SellerSignServicePojo;
import com.haly.service.UserMaintenanceService;

/**
 * @author JiangHua
 *
 */
@Service
public class UserMaintenanceServiceImpl implements UserMaintenanceService {

	@Autowired
	private BuyerDao buyerDao;

	/**
	 * search buyer info
	 * @return
	 */
	@Override
	public BuyerEntity getBuyerInfo(String buyerId) {
        return buyerDao.getBuyerInfo(buyerId);
	}
    /**
     * insert buyer
     */
    @Override
    public BuyerSignServicePojo saveBuyer(BuyerSignServicePojo buyerPojo) {

    	BuyerEntity buyerEntity = new BuyerEntity(buyerPojo.getBuyerId(),buyerPojo.getBuyerName(),
    			buyerPojo.getPassword(),buyerPojo.getEmail(),buyerPojo.getPostalAddress(),buyerPojo.getPostalAddress());
    	
        buyerDao.saveAndFlush(buyerEntity);
        return buyerPojo;
    	
    }
    
	@Autowired
	private SellerDao sellerDao;

	/**
	 * search buyer info
	 * @return
	 */
	@Override
	public SellerEntity getSellerInfo(String sellerId) {
        return sellerDao.getSellerInfo(sellerId);
	}
    /**
     * insert buyer
     */
    @Override
    public SellerSignServicePojo saveSeller(SellerSignServicePojo sellerPojo) {

    	SellerEntity sellerEntity = new SellerEntity(sellerPojo.getSellerId(),sellerPojo.getSellerName(),
    			sellerPojo.getPassword(),sellerPojo.getCompanyName(),sellerPojo.getCompanyBrief(),sellerPojo.getGSTIN(),
    			sellerPojo.getPostalAddress(),sellerPojo.getWebsite(),sellerPojo.getEmail(),sellerPojo.getContactNumber());
    	
        sellerDao.saveAndFlush(sellerEntity);
        return sellerPojo;
    }
}
