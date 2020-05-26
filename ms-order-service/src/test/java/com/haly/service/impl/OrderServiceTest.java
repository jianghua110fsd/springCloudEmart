/**
 * 
 */
package com.haly.service.impl;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.haly.MsOrderApplication;
import com.haly.entity.response.OrderRespEntity;

/**
 * @author Jiang hua
 *
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MsOrderApplication.class})
public class OrderServiceTest  {

	@Autowired
	private OrderSearchServiceImpl orderService;
	
	/**
	 * Search  Order History
	 *
	 */
	@Test
	@Transactional
    public void testGetOrderHistory() {
		
		List<OrderRespEntity> orders = orderService.getOrdersByBuyerId("b11");
		// See if search results meet expected
		assertEquals(3, orders.size());
    }
}
