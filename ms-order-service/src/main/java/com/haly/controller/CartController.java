package com.haly.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.haly.entity.ProductEntity;
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
	// code for addding cart successfully
	private static final String SUCCESS_CODE = "1";
	// code for stock not enough when addding cart
	private static final String STOCK_ALERT_CODE = "2";
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	// Product service
	private String productServiceName = "MS-PRODUCT-SERVICE";
	
	@RequestMapping("/viewcart")
	public List<CartRespEntity> viewCart(@RequestParam(value = "buyer") String buyerId) {

		return this.cartService.getCartByBuyerId(buyerId);
	}
	
	@RequestMapping("/addcart")
	public String addToCart(@RequestBody CartReqEntity cre) {
		// Get product stock info
		ProductEntity prd = 
				this.restTemplate.getForObject(
						"http://" + productServiceName + "/product/searchid?prdId=" + cre.getProductId(), ProductEntity.class);
		
		String rtnCd = this.cartService.addToCart(cre.getBuyerId(), cre, prd.getCurrentStock());
		// When item stock is enough and successfully added or updated to cart, update stock info
		if (!STOCK_ALERT_CODE.equals(rtnCd)) {
			if (SUCCESS_CODE.equals(rtnCd)) {
				// Newly added, minus purchase number
				prd.setCurrentStock(prd.getCurrentStock() - cre.getPurchaseNum());
				// update stock info of product
				this.restTemplate.postForEntity(
						"http://" + productServiceName + "/product/save", prd, ProductEntity.class);
			} 
		}
		
		return rtnCd;
	}
	
	@RequestMapping("/delcartitem")
	public int deleteCartItems(@RequestBody CartDelReqEntity cdre) {

		// delete cart item
		return this.cartService.delItemsFromCart(cdre.getBuyerId(), cdre.getProductIds());
	}
	
	@RequestMapping("/clearcart")
	public int clearCart(@RequestParam(value = "buyer") String buyerId) {
		return cartService.clearCart(buyerId);
	}
	
	@RequestMapping("/checkoutinit")
	public List<CartRespEntity> checkoutInit(@RequestBody CartDelReqEntity cdre) {
		
		return this.cartService.getCartByBuyerIdAndPrdIds(cdre.getBuyerId(), Arrays.asList(cdre.getProductIds()));
	}

}
