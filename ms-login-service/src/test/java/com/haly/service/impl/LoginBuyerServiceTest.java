package com.haly.service.impl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.haly.MsLoginApplication;
import com.haly.dao.BuyerDao;
import com.haly.entity.BuyerEntity;

/**
 * @author Jiang hua
 *
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MsLoginApplication.class})
public class LoginBuyerServiceTest  {

	@Autowired
	private LoginBuyerServiceImpl loginService;
	
	@Autowired
	private BuyerDao buyerDao;

	
	/**
	 * Search buyer all
	 *
	 */
	@Test
	@Transactional
    public void testGetBuyer() {
		
		
		// Create and Insert data for this test
		// Create
		BuyerEntity buyerInfo = new BuyerEntity();

    	buyerInfo.setBuyerId("000123");
    	buyerInfo.setBuyerName("testBuyer");
    	buyerInfo.setEmail("test@ssss");
    	buyerInfo.setMobileNumber("01010101");
    	buyerInfo.setPassword("testbu");
    	buyerInfo.setPostalAddress("dalian");
		this.buyerDao.save(buyerInfo);
		
		// Search product data all
		BuyerEntity buyerResult = loginService.getBuyerInfo("000123", "testbu");
    	
		// See if search results meet expected
		assertEquals("testBuyer", buyerResult.getBuyerName());
    }
}
