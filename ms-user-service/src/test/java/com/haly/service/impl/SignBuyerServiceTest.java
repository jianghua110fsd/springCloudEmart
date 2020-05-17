/**
 * 
 */
package com.haly.service.impl;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.haly.MsUserApplication;
import com.haly.entity.BuyerEntity;

/**
 * @author Jiang hua
 *
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MsUserApplication.class})
public class SignBuyerServiceTest  {

	@Autowired
	private UserMaintenanceServiceImpl buyerService;
	
	/**
	 * Search buyer 
	 *
	 */
	
	@Test
	@Transactional
    public void testInsertBuyer() {
		
		// insert buyer data
		BuyerEntity buyerInfo = new BuyerEntity();
		buyerInfo.setBuyerId("Jtest001b");
		buyerInfo.setBuyerName("testjiang");
		buyerInfo.setEmail("233332@ssss");
		buyerInfo.setMobileNumber("23234234");
		buyerInfo.setPassword("221qwe");
		buyerInfo.setPostalAddress("dalian");
		
		BuyerEntity buyerResult = buyerService.saveBuyer(buyerInfo);
		// See if search results meet expected
		assertEquals("Jtest001b",buyerResult.getBuyerId());
    }
}
