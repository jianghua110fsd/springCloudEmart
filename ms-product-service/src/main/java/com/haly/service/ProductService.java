/**
 * 
 */
package com.haly.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.haly.entity.ProductEntity;
import com.haly.entity.condition.SearchConditionForBuyerEntity;

/**
 * @author Jiang hua
 *
 */
public interface ProductService {

	public abstract List<ProductEntity> getProductAll();
	public abstract ProductEntity getProductById(String prdId);
	public abstract List<ProductEntity> getProductByName(String prdName);
	public abstract Page<ProductEntity> getProductByNamePaging(String prdName, int pageNum, int pageSize);
	public abstract Page<ProductEntity> getProductAllPaging(int pageNum, int pageSize);

	public abstract List<ProductEntity> getProductByFilters(SearchConditionForBuyerEntity bcond);
	public abstract Page<ProductEntity> getProductByFiltersPaging(SearchConditionForBuyerEntity bcond);
	
	public abstract ProductEntity saveProduct(ProductEntity product);
	public void deleteProduct(String prdId) throws SQLException;
	
	
}
