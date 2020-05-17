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
    public BuyerEntity saveBuyer(BuyerEntity buyerInfo) {
        return buyerDao.saveAndFlush(buyerInfo);
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
    public SellerEntity saveSeller(SellerEntity sellerInfo) {
        return sellerDao.saveAndFlush(sellerInfo);
    }


}
