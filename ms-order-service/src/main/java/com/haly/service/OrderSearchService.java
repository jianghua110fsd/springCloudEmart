/**
 * 
 */
package com.haly.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.haly.entity.OrderHistoryEntity;
import com.haly.entity.request.SearchConditionForSellerEntity;

/**
 * @author Jiang hua
 *
 */
public interface OrderSearchService {

	public abstract List<OrderHistoryEntity> getOrdersByBuyerId(String buyerId);
	public abstract List<OrderHistoryEntity> getOrdersBySellerId(String sellerId);
	public abstract List<OrderHistoryEntity> getOrdersByCondForSeller(SearchConditionForSellerEntity scond);
	public abstract Page<OrderHistoryEntity> getPageOrdersByCondForSeller(SearchConditionForSellerEntity scond);
}
