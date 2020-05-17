package com.haly.service;
import java.util.List;
import java.util.Optional;
import com.haly.entity.BuyerEntity;
import com.haly.entity.SellerEntity;

/**
 * @author JiangHua
 *
 */
public interface LoginService {
	public abstract BuyerEntity getBuyerInfo(String buyerId, String password);
	public abstract SellerEntity getSellerInfo(String sellerId, String password);
}
