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
import com.haly.entity.SellerEntity;

/**
 * @author Jiang hua
 *
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MsLoginApplication.class})
public class LoginSellerServiceTest  {

	@Autowired
	private LoginServiceImpl loginService;
	
	/**
	 * Seller Login test
	 *
	 */
	@Test
	@Transactional
    public void testGetBuyer() {
		
		// Search seller data
		SellerEntity sellerResult = loginService.getSellerInfo("11111", "001");
		// See if search results meet expected
		assertEquals("11111",sellerResult.getSellerId());
    }
}
