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
import com.haly.entity.response.OrderRespEntity;

@Repository
public interface OrderDao extends JpaRepository<OrderHistoryEntity, Long> {

	@Query("select new com.haly.entity.response.OrderRespEntity("
			+ "o.orderNo, o.purchaseDate, o.productId, o.productName, "
			+ "p.categoryName, p.subcategoryName, p.unit, "
			+ "o.purchasePrice, o.purchaseNum, o.purchaseAmount ) "
			+ "from OrderHistoryEntity o, ProductEntity p "
			+ "where o.productId = p.productId and o.buyerId = ?1")
	List<OrderRespEntity> queryOrderByBuyerId(@Param("buyerId") String buyerId, Sort sort);
	
	Long count(Specification<OrderHistoryEntity> specification);
	
	List<OrderHistoryEntity> findAll(Specification<OrderHistoryEntity> specification, Sort sort);

    Page<OrderHistoryEntity> findAll(Specification<OrderHistoryEntity> specification, Pageable pageable);

}
