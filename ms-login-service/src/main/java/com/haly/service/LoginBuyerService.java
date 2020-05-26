package com.haly.service;
import com.haly.entity.BuyerEntity;

/**
 * @author JiangHua
 *
 */
public interface LoginBuyerService {
	public abstract BuyerEntity getBuyerInfo(String buyerId, String password);
}
