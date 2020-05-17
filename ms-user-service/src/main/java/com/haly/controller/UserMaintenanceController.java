package com.haly.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.haly.entity.BuyerEntity;
import com.haly.entity.SellerEntity;
import com.haly.service.UserMaintenanceService;

/**
 * Hello world!
 *
 */

@RestController
@RequestMapping("/user")
public class UserMaintenanceController 
{
	
	@Value("${server.port}")
	String port;
	
	@Autowired
	private UserMaintenanceService userMaintenanceService;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "可苦可乐") String name) {
    	return name + ",welcome to springcloud! server port:" + port;
    }
    
    @RequestMapping("/bsearch")
    @CrossOrigin(origins = "*")
    public BuyerEntity searchBuyer(@RequestParam(value = "buyerId") String buyerId) {
    	
    	BuyerEntity buyerInfo = userMaintenanceService.getBuyerInfo(buyerId);
    	
    	if (buyerInfo == null) {
    		return new BuyerEntity();
    	} else {
    		return buyerInfo;
    	}
    }

    @GetMapping(value = "binsert")
    public BuyerEntity insertBuser(BuyerEntity buyerInfo) {
        return userMaintenanceService.saveBuyer(buyerInfo);
    }

    @RequestMapping("/ssearch")
    @CrossOrigin(origins = "*")
    public SellerEntity searchSeller(@RequestParam(value = "sellerId") String sellerId) {
    	
    	SellerEntity sellerInfo = userMaintenanceService.getSellerInfo(sellerId);
    	
    	if (sellerInfo == null) {
    		return new SellerEntity();
    	} else {
    		return sellerInfo;
    	}
    }
    @GetMapping(value = "sinsert")
    public SellerEntity insertSuser(SellerEntity sellerInfo) {
        return userMaintenanceService.saveSeller(sellerInfo);
    }
}
