package com.haly.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.haly.entity.BuyerEntity;
import com.haly.pojo.BuyerPojo;
import com.haly.service.LoginBuyerService;

/**
 * login
 *
 */

@RestController
@RequestMapping("/login")
public class LoginBuyerController 
{	
	@Value("${server.port}")
	String port;
	
	@Autowired
	private LoginBuyerService loginBService;
	
    @GetMapping("/buyer")
    @CrossOrigin
    public BuyerPojo LoginBuyer(@RequestHeader("Authorization") String user) {
		String token[] = user.split(":");
		BuyerPojo bPojo = new BuyerPojo();
    	BuyerEntity buyerInfo = loginBService.getBuyerInfo(token[0],token[1]);
    	if (buyerInfo != null) {
        bPojo = new BuyerPojo(buyerInfo.getBuyerId(),buyerInfo.getBuyerName(),
        	buyerInfo.getEmail(),buyerInfo.getMobileNumber(),buyerInfo.getPostalAddress());
    	}
    	return bPojo;
    }
}
