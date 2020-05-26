/**
 * 
 */
package com.haly.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.haly.dao.ProductDao;
import com.haly.entity.ProductEntity;
import com.haly.entity.condition.SearchConditionForBuyerEntity;
import com.haly.service.ProductService;

/**
 * @author Jiang hua
 *
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	/**
	 * 全件查询
	 *
	 * @return
	 */
	@Override
	public List<ProductEntity> getProductAll() {
		
		// 使用jpa提供的分页类
        
        return (List<ProductEntity>) productDao.findAll();
	}

	/**
	 * 根据id查询
	 *
	 * @param prdId
	 * @return
	 */
	@Override
	public ProductEntity getProductById(String prdId) {

		List<ProductEntity> prdList = productDao.queryProductById(prdId);
		if (CollectionUtils.isEmpty(prdList)) {
			return null;
		} else {
			return prdList.get(0);
		}
	}

	/**
	 * 根据name模糊（包含）查询
	 *
	 * @param prdName
	 * @return
	 */
	@Override
	public List<ProductEntity> getProductByName(String prdName) {

		List<ProductEntity> prdList = 
				this.productDao.queryProductByName(prdName, 
												Sort.by(new Order(Direction.ASC, "productName"))
												);
		return prdList;
	}
	
	/**
	 * 根据name模糊（包含）查询（指定页码，单页件数＄1�7
	 *
	 * @param idprdName
	 * @return
	 */
	@Override
	public Page<ProductEntity> getProductByNamePaging(String prdName, int pageNum, int pageSize) {
		
		// 使用jpa提供的分页类
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.ASC, "productName"));
        
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(orders));
        Page<ProductEntity> prdList = productDao.queryProductByName(prdName, pageable);
        
        return prdList;
	}
	
	/**
	 * 全件查询（指定页码，单页件数＄1�7
	 *
	 * @return
	 */
	@Override
	public Page<ProductEntity> getProductAllPaging(int pageNum, int pageSize) {
		
		// 使用jpa提供的分页类
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.DESC, "updateDatetime"));
        orders.add(new Order(Direction.ASC, "productName"));
        
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(orders));
        Page<ProductEntity> prdList = productDao.findAll(pageable);
        
        return prdList;
	}

	@Override
	public List<ProductEntity> getProductByFilters(SearchConditionForBuyerEntity bcond) {
		
		List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.DESC, "updateDatetime"));
        orders.add(new Order(Direction.ASC, "productName"));
        
        return this.productDao.findAll(this.getSpecForBuyerSearchCond(bcond), Sort.by(orders));
	}

	@Override
	public Page<ProductEntity> getProductByFiltersPaging(SearchConditionForBuyerEntity bcond) {
		
		List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.DESC, "updateDatetime"));
        orders.add(new Order(Direction.ASC, "productName"));
        
		Pageable pageable = PageRequest.of(bcond.getPage(), bcond.getSize(), Sort.by(orders));
		
		return this.productDao.findAll(this.getSpecForBuyerSearchCond(bcond), pageable);
	}
	
	@Override
	public ProductEntity saveProduct(ProductEntity product) {
		
		return this.productDao.save(product);
	}
	
	@Override
	public void deleteProduct(String prdId) throws SQLException {
		this.productDao.deleteById(prdId);;
	}
	
	
	private Specification<ProductEntity> getSpecForBuyerSearchCond(
											SearchConditionForBuyerEntity bcond) {
		// 构�1�7�自定义查询条件
		Specification<ProductEntity> queryCondition = new Specification<ProductEntity>() {
			private static final long serialVersionUID = 1L;
		
			@Override
			public Predicate toPredicate(
					Root<ProductEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicateList = new ArrayList<>();
				
				// Category
				if (StringHelper.isNotEmpty(bcond.getCategoryId())) {
					predicateList.add(criteriaBuilder.equal(root.get("categoryId"), bcond.getCategoryId()));
				}
				if (StringHelper.isNotEmpty(bcond.getSubcategoryId())) {
					predicateList.add(criteriaBuilder.equal(root.get("subcategoryId"), bcond.getSubcategoryId()));
				}
				
				// Price(from-to)
				if (StringHelper.isNotEmpty(bcond.getPriceFrom())) {
					predicateList.add(criteriaBuilder.greaterThanOrEqualTo(
									root.get("currentPrice").as(Float.class), Float.parseFloat(bcond.getPriceFrom())));
				}
				if (StringHelper.isNotEmpty(bcond.getPriceTo())) {
					predicateList.add(criteriaBuilder.lessThanOrEqualTo(
							root.get("currentPrice").as(Float.class), Float.parseFloat(bcond.getPriceTo())));
				}
				
				
				// Product name
				if (StringHelper.isNotEmpty(bcond.getPrdName())) {
				predicateList.add(criteriaBuilder.like(root.get("productName"), "%" + bcond.getPrdName() + "%"));
				}
				
				return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
			}
		};
		
		return queryCondition;
	}	

}
