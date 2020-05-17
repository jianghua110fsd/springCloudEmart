package com.haly.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haly.entity.BuyerEntity;
import com.haly.entity.SellerEntity;
import com.haly.service.LoginService;

/**
 * login
 *
 */

@RestController
@RequestMapping("/login")
public class LoginController 
{	
	@Value("${server.port}")
	String port;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "可苦可乐") String name) {
	    return name + ",welcome to springcloud! server port:" + port;
	}
	
    @RequestMapping("/buyer")
//    @CrossOrigin(origins = "*")
    public BuyerEntity LoginBuyer(@RequestParam(value = "buyer") String buyer) {
		String token[] = buyer.split(":");
    	BuyerEntity buyerInfo = loginService.getBuyerInfo(token[0],token[1]);
    	if (buyerInfo == null) {
    		return new BuyerEntity();
    	} else {
    		return buyerInfo;
    	}
    }
    
    @RequestMapping("/seller")
//    @CrossOrigin(origins = "*")
//	public SellerEntity LoginSeller(@RequestHeader("Authorization") String data) {
    public SellerEntity LoginSeller(@RequestParam(value = "seller") String seller) {
		String token[] = seller.split(":");
		SellerEntity sellerInfo =  loginService.getSellerInfo(token[0],token[1]);
    	if (sellerInfo == null) {
    		return new SellerEntity();
    	} else {
    		return sellerInfo;
    	}
    }
    
}
