/**
 * 
 */
package com.haly.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.haly.entity.OrderHistoryEntity;
import com.haly.entity.request.SearchConditionForSellerEntity;
import com.haly.entity.response.OrderRespEntity;

/**
 * @author Jiang hua
 *
 */
public interface OrderSearchService {

	public abstract List<OrderRespEntity> getOrdersByBuyerId(String buyerId);
	public abstract List<OrderHistoryEntity> getOrdersByCondForSeller(SearchConditionForSellerEntity scond);
	public abstract Page<OrderHistoryEntity> getPageOrdersByCondForSeller(SearchConditionForSellerEntity scond);
}
