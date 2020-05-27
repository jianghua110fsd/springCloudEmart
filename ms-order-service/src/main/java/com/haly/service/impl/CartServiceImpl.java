/**
 * 
 */
package com.haly.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.haly.dao.CartDao;
import com.haly.entity.CartEntity;
import com.haly.entity.CartEntityPk;
import com.haly.entity.request.CartReqEntity;
import com.haly.entity.response.CartRespEntity;
import com.haly.service.CartService;

/**
 * @author Jiang hua
 *
 */
@Service
public class CartServiceImpl implements CartService {
	
	private static final String SUCCESS_CODE = "1";
	private static final String FAILURE_CODE = "0";

	@Autowired
	private CartDao cartDao;
	
	@Override
	public List<CartRespEntity> getCartByBuyerId(String buyerId) {
		
		List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.ASC, "productName"));
        
		List<CartRespEntity> ordList = 
				this.cartDao.queryCartByBuyerId(buyerId, Sort.by(orders));
		return ordList;
	}

	@Override
	public String addToCart(String buyerId, CartReqEntity cartItem) {
		
		CartEntity cei = new CartEntity(new CartEntityPk(buyerId, cartItem.getProductId()));
		
//		Example<CartEntity> example =Example.of(cei);
//		List<CartEntity> ceOpt = this.cartDao.findAll(example);
		int dataCnt = this.cartDao.getCartItemCntByKey(buyerId, cartItem.getProductId());
//		if (ceOpt.isPresent()) {
//		if (!CollectionUtils.isEmpty(ceOpt)) {
		if (dataCnt > 0) {
			return FAILURE_CODE;
		}
		
		BeanUtils.copyProperties(cartItem, cei);
		cei.setPurchaseAmount(cartItem.getPurchasePrice() * cartItem.getPurchaseNum());
		this.cartDao.saveAndFlush(cei);
		return SUCCESS_CODE;
	}

	@Override
	public int delItemsFromCart(String buyerId, String[] prdIds) {

		int cnt = 0;
		
		for (String prdId : prdIds) {
//			CartEntity cei = new CartEntity(new CartEntityPk(buyerId, prdId));
			
//			Example<CartEntity> example =Example.of(cei);
//			Optional<CartEntity> ceOpt = this.cartDao.findOne(example);
//			if (ceOpt.isPresent()) {
			int dataCnt = this.cartDao.getCartItemCntByKey(buyerId, prdId);
			if (dataCnt > 0) {
//				this.cartDao.delete(ceOpt.get());
				this.cartDao.deleteByKey(buyerId, prdId);
				cnt ++;
			}
		}
		
		return cnt;
	}

	@Override
	public int clearCart(String buyerId) {

		// If cart item exists
		int cnt = this.cartDao.getCartItemCntByBuyerId(buyerId);
		if (cnt > 0) {
			this.cartDao.deleteByBuyerId(buyerId);
		}
		
		return cnt;
	}


 }
