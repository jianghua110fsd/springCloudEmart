package com.haly.service;
import com.haly.entity.SellerEntity;

/**
 * @author JiangHua
 *
 */
public interface LoginSellerService {
	public abstract SellerEntity getSellerInfo(String sellerId, String password);
}
