package com.haly.service.spec;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.haly.entity.OrderHistoryEntity;

public class OrderSearchForSellerSpec implements Specification<OrderHistoryEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Predicate toPredicate(Root<OrderHistoryEntity> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		
		//1.混合条件查询  
		Path<String> exp1 = root.get("buyerName");  
		Path<Date>  exp2 = root.get("purchaseDate");  
		Predicate predicate = cb.and(cb.like(exp1, "%taskName%"), cb.lessThan(exp2, new Date()));
		return predicate;  
	}

}
