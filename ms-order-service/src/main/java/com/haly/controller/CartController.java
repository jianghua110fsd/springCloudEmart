package com.haly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haly.entity.request.CartDelReqEntity;
import com.haly.entity.request.CartReqEntity;
import com.haly.entity.response.CartRespEntity;
import com.haly.service.CartService;

/**
 * Hello world!
 *
 */

@RestController
@RequestMapping("/order")
public class CartController 
{
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/viewcart")
//	public String addToCart(@RequestBody CartReqEntity cre) {
	public List<CartRespEntity> viewCart(@RequestParam(value = "buyer") String buyerId) {

		return this.cartService.getCartByBuyerId(buyerId);
	}
	
	@RequestMapping("/addcart")
//	public String addToCart(@RequestBody CartReqEntity cre) {
	public String addToCart(@RequestParam(value = "buyer") String buyerId, @RequestParam(value = "product") String product) {
		
		CartReqEntity cre = new CartReqEntity(buyerId, product, "Product***", "s11", 13.5f, 3,  "test");
		
		return this.cartService.addToCart(cre.getBuyerId(), cre);
	}
	
	@RequestMapping("/delcartitem")
//	public String deleteCartItems(@RequestBody CartDelReqEntity cdre) {
	public int deleteCartItems(@RequestParam(value = "buyer") String buyerId) {
		
		CartDelReqEntity cdre = new CartDelReqEntity();
		cdre.setBuyerId(buyerId);
		cdre.setProductIds(new String[] {"p001", "p002"});
		
		return cartService.delItemsFromCart(cdre.getBuyerId(), cdre.getProductIds());
	}
	
	@RequestMapping("/clearcart")
	public int clearCart(@RequestParam(value = "buyer") String buyerId) {
		return cartService.clearCart(buyerId);
	}

}
