package com.haly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haly.entity.request.OrderReqEntity;
import com.haly.service.OrderGenerateService;

/**
 * Hello world!
 *
 */

@RestController
@RequestMapping("/order")
public class OrderGenerateController 
{
	@Autowired
	private OrderGenerateService orderGenerateService;
	
//	@Value("${server.port}")
//	String port;
//	
//    @RequestMapping("/hello")
//    public String hello(@RequestParam(value = "name", defaultValue = "你好") String name) {
//    	return name + ",welcome to springcloud! server port:" + port;
//    }
	
	@RequestMapping("/save")
	public String saveOrders(@RequestBody List<OrderReqEntity> ors) {
//	public String saveOrders() {

//		List<OrderReqEntity> ors = new ArrayList<>();
//		ors.add(new OrderReqEntity("b12", "b12", "p002", "商品33", "s11", 12.5f, 2, 25f, "Credit card", 81f, "test1"));
//		ors.add(new OrderReqEntity("b12", "b12", "p003", "商品11", "s12", 13.5f, 2, 27f, "Credit card", 81f, "test1"));
//		ors.add(new OrderReqEntity("b12", "b12", "p004", "商品22", "s11", 14.5f, 2, 29f, "Credit card", 81f, "test1"));
	  	
		return this.orderGenerateService.generateOrders(ors);
	}

}
