package com.haly.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.haly.entity.SellerEntity;
import com.haly.pojo.SellerPojo;
import com.haly.service.LoginSellerService;

/**
 * login
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginSellerController 
{	
	@Value("${server.port}")
	String port;
	
	@Autowired
	private LoginSellerService loginSService;
    @GetMapping("/seller")
	public SellerPojo LoginSeller(@RequestHeader("Authorization") String user) {
		String token[] = user.split(":");
		SellerPojo sPojo = new SellerPojo();
		SellerEntity sellerInfo =  loginSService.getSellerInfo(token[0],token[1]);
    	if (sellerInfo != null) {
    		sPojo = new SellerPojo(sellerInfo.getSellerId(),sellerInfo.getSellerName(),sellerInfo.getCompanyName(),
    			sellerInfo.getGstin(),sellerInfo.getCompanyBrief(),sellerInfo.getPostalAddress(),sellerInfo.getWebsite(),
    			sellerInfo.getEmail(),sellerInfo.getContactNumber());
    	}
    	return sPojo;
    }
    
}
