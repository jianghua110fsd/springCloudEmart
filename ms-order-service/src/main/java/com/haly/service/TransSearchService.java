/**
 * 
 */
package com.haly.service;

import java.util.List;

import com.haly.entity.response.TransRespEntity;

/**
 * @author Jiang hua
 *
 */
public interface TransSearchService {

	public abstract List<TransRespEntity> getOrdersBySellerId(String sellerId);
}
