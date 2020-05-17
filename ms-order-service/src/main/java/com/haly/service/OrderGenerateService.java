/**
 * 
 */
package com.haly.service;

import java.util.List;

import com.haly.entity.request.OrderReqEntity;

/**
 * @author Jiang hua
 *
 */
public interface OrderGenerateService {

	public abstract String generateOrders(List<OrderReqEntity> ords);
}
