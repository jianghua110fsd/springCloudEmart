package com.haly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.haly.entity.OrderHistoryEntity;

@Repository
public interface OrderDao extends JpaRepository<OrderHistoryEntity, Long> {

	@Query("select o from OrderHistoryEntity o where o.buyerId = ?1")
	List<OrderHistoryEntity> queryOrderByBuyerId(@Param("buyerId") String buyerId, Sort sort);
	
	@Query("select o from OrderHistoryEntity o where o.sellerId = ?1")
    List<OrderHistoryEntity> queryOrderBySellerId(@Param("sellerId") String sellerId, Sort sort);
	
	Long count(Specification<OrderHistoryEntity> specification);
	
	List<OrderHistoryEntity> findAll(Specification<OrderHistoryEntity> specification, Sort sort);

    Page<OrderHistoryEntity> findAll(Specification<OrderHistoryEntity> specification, Pageable pageable);

}
