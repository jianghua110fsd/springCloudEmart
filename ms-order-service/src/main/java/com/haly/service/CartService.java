/**
 * 
 */
package com.haly.service;

import java.util.List;

import com.haly.entity.CartEntity;
import com.haly.entity.request.CartReqEntity;
import com.haly.entity.response.CartRespEntity;

/**
 * @author Jiang hua
 *
 */
public interface CartService {

	public abstract List<CartRespEntity> getCartByBuyerId(String buyerId);
	public abstract CartEntity addToCart(String buyerId, CartReqEntity cartItem);
	public abstract int delItemsFromCart(String buyerId, String[] prdIds);
	public abstract int clearCart(String buyerId);
}
