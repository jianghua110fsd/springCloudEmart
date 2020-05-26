package com.haly.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.haly.dao.BuyerDao;
import com.haly.entity.BuyerEntity;
import com.haly.service.LoginBuyerService;

/**
 * @author Jianghua
 *
 */
@Service
public class LoginBuyerServiceImpl implements LoginBuyerService {

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
}
