package com.haly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haly.entity.OrderHistoryEntity;
import com.haly.entity.request.SearchConditionForSellerEntity;
import com.haly.entity.response.OrderRespEntity;
import com.haly.entity.response.TransRespEntity;
import com.haly.service.OrderSearchService;
import com.haly.service.TransSearchService;

/**
 * Controller for searching orders both for buyer and seller
 *
 */

@RestController
@RequestMapping("/order")
public class OrderSearchController 
{
	
	@Autowired
	private OrderSearchService orderSearchService;
	
	@Autowired
	private TransSearchService transSearchService;
	
	
	@RequestMapping("/bsearchall")
	public List<OrderRespEntity> buyerOrderSearchAll(@RequestParam(value = "buyer") String buyerId) {
		return this.orderSearchService.getOrdersByBuyerId(buyerId);
	}
	
	@RequestMapping("/ssearchall")
	public List<TransRespEntity> sellerOrderSearchAll(@RequestParam(value = "seller") String sellerId) {
		return this.transSearchService.getOrdersBySellerId(sellerId);
	}
    
    @RequestMapping("/ssearch")
//    public List<OrderHistoryEntity> sellerOrderSearch(@RequestBody SearchConditionForSellerEntity scond) {
    // test code start
	public List<OrderHistoryEntity> sellerOrderSearch() {
    	
    	SearchConditionForSellerEntity scond = new SearchConditionForSellerEntity();
    	scond.setSellerId("s13");
    	scond.setPurchaseDateFrom("2020-03-10");
    	// test code end
    	
    	return this.orderSearchService.getOrdersByCondForSeller(scond);
    }
    
    @RequestMapping("/pssearch")
//    public Page<OrderHistoryEntity> sellerOrderPagingSearch(@RequestBody SearchConditionForSellerEntity scond) {
    // test code start
    public Page<OrderHistoryEntity> sellerOrderPagingSearch() {
    	
    	SearchConditionForSellerEntity scond = new SearchConditionForSellerEntity();
    	scond.setSellerId("s11");
//    	scond.setBuyerName("b11");
    	scond.setPurchaseDateFrom("2020-03-02");
    	scond.setPurchaseDateTo("2020-03-10");
    	scond.setPage(0);
    	scond.setSize(2);
    	// test code end
    	
    	return this.orderSearchService.getPageOrdersByCondForSeller(scond);
    }
}
