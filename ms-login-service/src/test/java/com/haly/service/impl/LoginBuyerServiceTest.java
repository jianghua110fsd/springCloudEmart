/**
 * 
 */
package com.haly.service.impl;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.haly.MsLoginApplication;
import com.haly.entity.BuyerEntity;

/**
 * @author Jiang hua
 *
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MsLoginApplication.class})
public class LoginBuyerServiceTest  {

	@Autowired
	private LoginServiceImpl loginService;
	
	/**
	 * Search buyer 
	 *
	 */
	@Test
	@Transactional
    public void testGetBuyer() {
		
		// Search buyer data
		BuyerEntity buyerResult = loginService.getBuyerInfo("11111", "001");
		// See if search results meet expected
		assertEquals("11111",buyerResult.getBuyerId());
    }
}
