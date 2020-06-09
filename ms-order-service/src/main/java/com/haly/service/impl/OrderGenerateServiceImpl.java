/**
 * 
 */
package com.haly.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haly.dao.CartDao;
import com.haly.dao.OrderDao;
import com.haly.dao.TransactionDao;
import com.haly.entity.OrderHistoryEntity;
import com.haly.entity.TransactionEntity;
import com.haly.entity.request.OrderReqEntity;
import com.haly.service.OrderGenerateService;

/**
 * @author Jiang hua
 *
 */
@Service
@Transactional
public class OrderGenerateServiceImpl implements OrderGenerateService {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private TransactionDao transactionDao;
	@Autowired
	private CartDao cartDao;


	@Override
	public String generateOrders(List<OrderReqEntity> ords) {
		
		// Generate a tranaction record
		TransactionEntity trn = new TransactionEntity();
		
		// Deleted due to Transaction ID becoming to Auto Increacement
//		// Transaction ID generate
//		String maxTrnId = this.transactionDao.queryMaxTransactionId();
//		if (maxTrnId == null) {
//			maxTrnId = "00000000";
//		}
//		int tempVal = Integer.valueOf(maxTrnId) + 1;
//		String newTrnId = StringUtils.leftPad(String.valueOf(tempVal), 8, "0");
//		trn.setTransactionId(newTrnId);
		
		trn.setTransactionType(ords.get(0).getTransactionType());
		trn.setBuyerId(ords.get(0).getBuyerId());
		trn.setTransactionAmount(ords.get(0).getTransactionAmount());
		// Transaction date auto generated
		
		TransactionEntity rtnTrn = this.transactionDao.save(trn);
		
		// Generate order records
		for (OrderReqEntity ord: ords) {
			OrderHistoryEntity oh = new OrderHistoryEntity();
			BeanUtils.copyProperties(ord, oh);
			// Purchase date auto generated
			oh.setTransactionId(rtnTrn.getTransactionId());
			
			this.orderDao.save(oh);
			// Delete cart item accordingly
			this.cartDao.deleteByKey(ord.getBuyerId(), ord.getProductId());
		}
		
		return String.valueOf(rtnTrn.getTransactionId());
	}
	
	
 }
