/**
 * 
 */
package com.haly.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.haly.dao.SellerDao;
import com.haly.entity.SellerEntity;
import com.haly.dao.BuyerDao;
import com.haly.entity.BuyerEntity;
import com.haly.service.LoginService;

/**
 * @author Jianghua
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private BuyerDao buyerDao;

	/**
	 * getBuyerInfo
	 * @param buyerId,password
	 * @return BuyerEntity
	 */
	@Override
	public BuyerEntity getBuyerInfo(String buyerId, String password) {
		return buyerDao.queryBuyerByName(buyerId, password);
	}

	@Autowired
	private SellerDao sellerDao;
	
	/**
	 * getSellerInfo
	 *
	 * @param buyerId,password
	 * @return SellerEntity
	 */
	@Override
	public SellerEntity getSellerInfo(String sellerId, String password) {
        return sellerDao.querySellerByName(sellerId, password);
	}
}
