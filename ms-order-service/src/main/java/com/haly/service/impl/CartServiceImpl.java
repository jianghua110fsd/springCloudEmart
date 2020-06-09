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
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.haly.dao.CartDao;
import com.haly.entity.CartEntity;
import com.haly.entity.CartEntityPk;
import com.haly.entity.ProductEntity;
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
	private static final String STOCK_ALERT_CODE = "2";
	
	// Product service
	private String productServiceName = "MS-PRODUCT-SERVICE";

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<CartRespEntity> getCartByBuyerId(String buyerId) {
		
		List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.DESC, "createDatetime"));
        
		List<CartRespEntity> ordList = 
				this.cartDao.queryCartByBuyerId(buyerId, Sort.by(orders));
		return ordList;
	}
	
	@Override
	public List<CartRespEntity> getCartByBuyerIdAndPrdIds(String buyerId, List<String> prdIds) {
		
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(Direction.DESC, "createDatetime"));
		
		List<CartRespEntity> ordList = 
				this.cartDao.queryCartByBuyerIdAndPrdIds(buyerId, prdIds, Sort.by(orders));
		return ordList;
	}

	@Override
	public String addToCart(String buyerId, CartReqEntity cartItem, int stock) {
		
		// construct cart entity for cart 
		CartEntity cei = new CartEntity(new CartEntityPk(buyerId, cartItem.getProductId()));
		
//		Example<CartEntity> example =Example.of(cei);
//		List<CartEntity> ceOpt = this.cartDao.findAll(example);
		int dataCnt = this.cartDao.getCartItemCntByKey(buyerId, cartItem.getProductId());
//		if (ceOpt.isPresent()) {
		if (dataCnt > 0) {
			// Update purchase amount when from the Item Detail Page
			if (cartItem.isFromDetail()) {
				ProductEntity prd = 
						this.restTemplate.getForObject(
								"http://" + productServiceName + "/product/searchid?prdId=" + cartItem.getProductId(), ProductEntity.class);
				CartEntity ce  = this.getCartItem(buyerId, cartItem.getProductId());
				// Updated, recover stock from last adding first and then minus purchase number for this time
				int stockPredict  = prd.getCurrentStock() + ce.getPurchaseNum() - cartItem.getPurchaseNum();
				// when predicting stock is not enough
				if (stockPredict < 0) {
					return STOCK_ALERT_CODE;
				}
				prd.setCurrentStock(stockPredict);
				// update stock info of product
				this.restTemplate.postForEntity(
						"http://" + productServiceName + "/product/save", prd, ProductEntity.class);
				
				this.cartDao.updatePurchaseNumber(cartItem.getPurchaseNum(), buyerId, cartItem.getProductId());
			}

			return FAILURE_CODE;
		} else {
			// Stock check
			if (cartItem.getPurchaseNum() > stock) {
				return STOCK_ALERT_CODE;
			}
		}
		
		BeanUtils.copyProperties(cartItem, cei);
		cei.setPurchaseAmount(cartItem.getPurchasePrice() * cartItem.getPurchaseNum());
		this.cartDao.saveAndFlush(cei);
		return SUCCESS_CODE;
	}

	@Override
	public int delItemsFromCart(String buyerId, String[] prdIds) {

		// delete count
		int cnt = 0;
		
		for (String prdId : prdIds) {
			// get cart item info
			CartEntity ce  = this.getCartItem(buyerId, prdId);
			if (ce.getCartPk() != null) {
				// recover product's stock info
				ProductEntity prd = 
						this.restTemplate.getForObject(
								"http://" + productServiceName + "/product/searchid?prdId=" + prdId, ProductEntity.class);
				prd.setCurrentStock(prd.getCurrentStock() + ce.getPurchaseNum());
				this.restTemplate.postForEntity(
						"http://" + productServiceName + "/product/save", prd, ProductEntity.class);
				
				// delete cart item
				this.cartDao.deleteByKey(buyerId, prdId);
				cnt ++;
			}
		}
		
		return cnt;
	}

	@Override
	public int clearCart(String buyerId) {

		List<CartEntity> cartItems = this.cartDao.getCartItems(buyerId);
		if (CollectionUtils.isEmpty(cartItems)) {
			return 0;
		}
		
		// If cart items exists
		int cnt = 0;
		for (CartEntity ce : cartItems) {
			// recover product's stock info
			ProductEntity prd = 
					this.restTemplate.getForObject(
							"http://" + productServiceName + "/product/searchid?prdId=" + ce.getCartPk().getProductId(), ProductEntity.class);
			prd.setCurrentStock(prd.getCurrentStock() + ce.getPurchaseNum());
			this.restTemplate.postForEntity(
					"http://" + productServiceName + "/product/save", prd, ProductEntity.class);
			
			cnt ++;
		}
			
		this.cartDao.deleteByBuyerId(buyerId);
		
		return cnt;
	}
	
	@Override
	public CartEntity getCartItem(String buyerId, String productId) {
		
		return this.cartDao.getCartItemByKey(buyerId, productId);
	}


 }
