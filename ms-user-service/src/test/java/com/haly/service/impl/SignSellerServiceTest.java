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
import com.haly.entity.SellerEntity;

/**
 * @author Jiang hua
 *
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MsUserApplication.class})
public class SignSellerServiceTest  {
	
	@Autowired
	private UserMaintenanceServiceImpl buyerService;
	
	/**
	 * Search seller 
	 *
	 */
	@Test
	@Transactional
    public void testInsertSeller() {
		
		// insert seller data
		SellerEntity sellerInfo = new SellerEntity();
    	sellerInfo.setSellerId("Jtest001s");
    	sellerInfo.setSellerName("stestjiang");
    	sellerInfo.setEmail("ssew332@ssss");
    	sellerInfo.setCompanyBrief(111);
    	sellerInfo.setPassword("221qwe");
    	sellerInfo.setPostalAddress("dalian");
    	sellerInfo.setCompanyName("xianhua");
    	sellerInfo.setGSTN("sssssss");
    	sellerInfo.setWebsite("w5@wer");
    	sellerInfo.setContactNumber("1234567890123");
		SellerEntity sellerResult = buyerService.saveSeller(sellerInfo);
		// See if search results meet expected
		assertEquals("Jtest001s",sellerResult.getSellerId());
    }
}
