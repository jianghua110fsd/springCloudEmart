/**
 * 
 */
package com.haly.service.impl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.haly.MsLoginApplication;
import com.haly.dao.SellerDao;
import com.haly.entity.SellerEntity;

/**
 * @author Jiang hua
 *
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MsLoginApplication.class})
public class LoginSellerServiceTest  {

	@Autowired
	private LoginSellerServiceImpl loginService;
	
	@Autowired
	private SellerDao sellerDao;

	
	/**
	 * Seller Login test
	 *
	 */
	@Test
	@Transactional
    public void testGetBuyer() {
		
		
		// Create and Insert data for this test
		// Create
		SellerEntity sellerInfo = new SellerEntity();

    	sellerInfo.setSellerId("000s123");
    	sellerInfo.setSellerName("stestjiang");
    	sellerInfo.setEmail("ssew332@ssss");
    	sellerInfo.setCompanyBrief("222222");
    	sellerInfo.setPassword("221qwe");
    	sellerInfo.setPostalAddress("dalian");
    	sellerInfo.setCompanyName("xianhua");
    	sellerInfo.setGstin("sssssss");
    	sellerInfo.setWebsite("w5@wer");
    	sellerInfo.setContactNumber("1234567890123");

		this.sellerDao.save(sellerInfo);
		
		// Search product data all
		SellerEntity sellerResult = new SellerEntity();
		sellerResult = loginService.getSellerInfo("000s123", "221qwe");
    	
		// See if search results meet expected
		assertEquals("000s123", sellerResult.getSellerId());
    }
}
