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
	public abstract List<CartRespEntity> getCartByBuyerIdAndPrdIds(String buyerId, List<String> prdIds);
	public abstract String addToCart(String buyerId, CartReqEntity cartItem, int stock);
	public abstract int delItemsFromCart(String buyerId, String[] prdIds);
	public abstract int clearCart(String buyerId);
	public abstract CartEntity getCartItem(String buyerId, String prdId);
}
