/**
 * 
 */
package com.haly.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	public CartEntity addToCart(String buyerId, CartReqEntity cartItem) {
		
		CartEntityPk cp = new CartEntityPk(buyerId, cartItem.getProductId());
		CartEntity ce = new CartEntity();
		ce.setCartPk(cp);
		
		BeanUtils.copyProperties(cartItem, ce);
		ce.getCartPk().setBuyerId(buyerId);
		ce.getCartPk().setProductId(cartItem.getProductId());
		ce.setPurchaseAmount(cartItem.getPurchasePrice() * cartItem.getPurchaseNum());
		
		return this.cartDao.saveAndFlush(ce);
	}

	@Override
	public int delItemsFromCart(String buyerId, String[] prdIds) {

		int cnt = 0;
		
		for (String prdId : prdIds) {
			CartEntityPk cp = new CartEntityPk(buyerId, prdId);
			CartEntity cei = new CartEntity();
			cei.setCartPk(cp);
			Optional<CartEntity> ceo = this.cartDao.findOne((Example<CartEntity>) cei);
			CartEntity ced = ceo.get();
			this.cartDao.delete(ced);
			
			cnt ++;
		}
		
		return cnt;
		
		// Referer
//		Product product = new Product();
//        product.setCategoryId(1);
//        Example<Product> example = Example.of(product);
//        Optional<Product> productOptional = respository.findOne(example);
//
//        if (productOptional.isPresent()) {
//            Product productResult =   productOptional.get();
//            System.out.println(productResult.toString());
//        } else {
//            // handle not found, return null or throw
//            System.out.println("no exit!");
//        }

	}

	@Override
	public int clearCart(String buyerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	
 }
