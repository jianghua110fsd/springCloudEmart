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
import com.haly.dao.SellerDao;
import com.haly.pojo.SellerSignServicePojo;
import com.haly.service.UserMaintenanceService;

/**
 * @author Jiang hua
 *
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MsUserApplication.class})
public class SaveSellerServiceTest  {

	@Autowired
	private UserMaintenanceService saveService;
	
	@Autowired
	private SellerDao sellerDao;

	
	/**
	 * Search buyer all
	 *
	 */
	@Test
	@Transactional
    public void testSaveSeller() {
		
		
		// Create and Insert data for this test
		SellerSignServicePojo sellerPojo = new SellerSignServicePojo();

		sellerPojo.setSellerId("000s234");
		sellerPojo.setSellerName("stestsave");
		sellerPojo.setEmail("save332@ssss");
		sellerPojo.setCompanyBrief("12344");
		sellerPojo.setPassword("221qwe");
		sellerPojo.setPostalAddress("dalian");
		sellerPojo.setCompanyName("xianhua");
		sellerPojo.setGstin("12312");
		sellerPojo.setWebsite("w5@wer");
    	sellerPojo.setContactNumber("1234567890123");

		// save Seller
		SellerSignServicePojo sellerResult = saveService.saveSeller(sellerPojo);
    	
		// See if search results meet expected
		assertEquals("000s234", sellerResult.getSellerId());
    }
}
