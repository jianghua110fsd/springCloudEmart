/**
 * 
 */
package com.haly.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.haly.dao.TransactionDao;
import com.haly.entity.response.TransRespEntity;
import com.haly.service.TransSearchService;

/**
 * @author Jiang hua
 *
 */
@Service
public class TransSearchServiceImpl implements TransSearchService {

	@Autowired
	private TransactionDao transDao;
	
	@Override
	public List<TransRespEntity> getOrdersBySellerId(String sellerId) {
		
		List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.DESC, "transactionDate"));
//        orders.add(new Order(Direction.ASC, "o.productName"));
        
		List<TransRespEntity> ordList = 
				this.transDao.queryOrderBySellerId(sellerId, Sort.by(orders));
		return ordList;
	}

	
 }
