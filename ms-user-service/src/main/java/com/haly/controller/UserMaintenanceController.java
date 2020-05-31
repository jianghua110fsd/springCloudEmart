package com.haly.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.haly.entity.BuyerEntity;
import com.haly.entity.SellerEntity;
import com.haly.pojo.BuyerSignServicePojo;
import com.haly.pojo.SellerSignServicePojo;
import com.haly.service.UserMaintenanceService;

/**
 * Hello world!
 *
 */

@RestController
@RequestMapping("/user")
public class UserMaintenanceController 
{	
	@Autowired
	private UserMaintenanceService userMaintenanceService;
    
    @RequestMapping("/bsearch")
    public BuyerEntity searchBuyer(@RequestParam(value = "buyerId") String buyerId) {
    	
    	BuyerEntity buyerInfo = userMaintenanceService.getBuyerInfo(buyerId);
    	
    	if (buyerInfo == null) {
    		return new BuyerEntity();
    	} else {
    		return buyerInfo;
    	}
    }

	@Autowired
	private UserMaintenanceService userBInsertService;
	
    @PostMapping("/binsert")
    @CrossOrigin
    public BuyerSignServicePojo insertBuyer(@RequestBody BuyerSignServicePojo buyerPojo) {
        return userBInsertService.saveBuyer(buyerPojo);
    }

    @RequestMapping("/ssearch")
    public SellerEntity searchSeller(@RequestParam(value = "sellerId") String sellerId) {
    	
    	SellerEntity sellerInfo = userMaintenanceService.getSellerInfo(sellerId);
    	
    	if (sellerInfo == null) {
    		return null;
    	} else {
    		return sellerInfo;
    	}
    }
	@Autowired
	private UserMaintenanceService userSInsertService;
	
	@PostMapping(value = "/sinsert")
	@CrossOrigin
    public SellerSignServicePojo insertSeller(@RequestBody SellerSignServicePojo sellerPojo) {
		System.out.println("GSTIN=:" + sellerPojo.getGstin() + "--------------------" );
		System.out.println("CompanyBrief=:" + sellerPojo.getCompanyBrief() + "--------------------" );
        return userSInsertService.saveSeller(sellerPojo);
    }
}
