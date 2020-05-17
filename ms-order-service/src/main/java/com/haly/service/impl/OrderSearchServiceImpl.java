/**
 * 
 */
package com.haly.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

import com.haly.dao.OrderDao;
import com.haly.entity.OrderHistoryEntity;
import com.haly.entity.request.SearchConditionForSellerEntity;
import com.haly.service.OrderSearchService;

/**
 * @author Jiang hua
 *
 */
@Service
public class OrderSearchServiceImpl implements OrderSearchService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<OrderHistoryEntity> getOrdersByBuyerId(String buyerId) {
		
		List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.DESC, "createDatetime"));
        
		List<OrderHistoryEntity> ordList = 
				this.orderDao.queryOrderByBuyerId(buyerId, Sort.by(orders));
		return ordList;
	}

	@Override
	public List<OrderHistoryEntity> getOrdersBySellerId(String sellerId) {
		
		List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.DESC, "createDatetime"));
        
		List<OrderHistoryEntity> ordList = 
				this.orderDao.queryOrderBySellerId(sellerId, Sort.by(orders));
		return ordList;
	}

	@Override
	public List<OrderHistoryEntity> getOrdersByCondForSeller(SearchConditionForSellerEntity scond) {
        
		List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.DESC, "createDatetime"));
        
        return this.orderDao.findAll(this.getSpecForSellerSearchCond(scond), Sort.by(orders));
    }

	@Override
	public Page<OrderHistoryEntity> getPageOrdersByCondForSeller(SearchConditionForSellerEntity scond) {
		
		List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.DESC, "createDatetime"));
        
		Pageable pageable = PageRequest.of(scond.getPage(), scond.getSize(), Sort.by(orders));
		return this.orderDao.findAll(this.getSpecForSellerSearchCond(scond), pageable);
	}
	
	
	private Specification<OrderHistoryEntity> getSpecForSellerSearchCond(
												SearchConditionForSellerEntity scond) {
		// 构�1�7�自定义查询条件
		Specification<OrderHistoryEntity> queryCondition = new Specification<OrderHistoryEntity>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Predicate toPredicate(Root<OrderHistoryEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();

                // Seller
                if (StringHelper.isNotEmpty(scond.getSellerId())) {
                	predicateList.add(criteriaBuilder.equal(root.get("sellerId"), scond.getSellerId()));
                }
                
                // Purchase date(from)
                if (StringHelper.isNotEmpty(scond.getPurchaseDateFrom()) ) {
//                	Date fromDate = CommonUtils.dateConverter(scond.getPurchaseDateFrom(), "F");
//                	if (fromDate != null) {
                		predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get("purchaseDate").as(String.class), scond.getPurchaseDateFrom()));
//                	}
                }
                
                // Purchase date(to)
                if (StringHelper.isNotEmpty(scond.getPurchaseDateTo()) ) {
//                	Date toDate = CommonUtils.dateConverter(scond.getPurchaseDateTo(), "T");
                	String toDate = scond.getPurchaseDateTo();
//                	if (toDate != null) {
                	if (!toDate.contains(":")) {
                		toDate = toDate + " 23:59:59";
                	}
                	predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get("purchaseDate").as(String.class), toDate));
                }
                
//                predicateList.add(criteriaBuilder.between(root.<Date>get("purchaseDate"), fromDate, toDate));
                
                // Buyer name
                if (StringHelper.isNotEmpty(scond.getBuyerName())) {
                	predicateList.add(criteriaBuilder.like(root.get("buyerName"), "%" + scond.getBuyerName() + "%"));
                }

                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };

        return queryCondition;
	}

	
 }
