/**
 * 
 */
package com.haly.service.impl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.haly.MsUserApplication;
import com.haly.dao.BuyerDao;
import com.haly.dao.SellerDao;
import com.haly.entity.BuyerEntity;
import com.haly.pojo.BuyerSignServicePojo;
import com.haly.pojo.SellerSignServicePojo;
import com.haly.service.UserMaintenanceService;

/**
 * @author Jiang hua
 *
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MsUserApplication.class})
public class SaveBuyerServiceTest  {

	@Autowired
	private UserMaintenanceService saveService;
	
	@Autowired
	private BuyerDao buyerDao;

	
	/**
	 * Search buyer all
	 *
	 */
	@Test
	@Transactional
    public void testSaveSeller() {
		
		
		// Create and Insert data for this test
		BuyerSignServicePojo buyerPojo = new BuyerSignServicePojo();

		buyerPojo.setBuyerId("0123SaveB");
		buyerPojo.setBuyerName("testBuyer");
		buyerPojo.setEmail("buyer@ssss");
		buyerPojo.setMobileNumber("23234234");
		buyerPojo.setPassword("221qwe");
		buyerPojo.setPostalAddress("dalian");
		
		// save Buyer
		BuyerSignServicePojo buyerResult = saveService.saveBuyer(buyerPojo);
    	
		// See if search results meet expected
		assertEquals("0123SaveB", buyerResult.getBuyerId());
    }
}
