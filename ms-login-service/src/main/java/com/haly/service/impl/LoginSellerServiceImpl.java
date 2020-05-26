/**
 * 
 */
package com.haly.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.haly.dao.SellerDao;
import com.haly.entity.SellerEntity;
import com.haly.service.LoginSellerService;
import com.haly.dao.BuyerDao;
import com.haly.entity.BuyerEntity;

/**
 * @author Jianghua
 *
 */
@Service
public class LoginSellerServiceImpl implements LoginSellerService {

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
