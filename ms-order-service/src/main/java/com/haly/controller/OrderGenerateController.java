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

	  	return this.orderGenerateService.generateOrders(ors);
	}

}
