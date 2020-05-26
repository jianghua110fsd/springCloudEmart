package com.haly.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.haly.entity.TransactionEntity;
import com.haly.entity.response.TransRespEntity;

@Repository
public interface TransactionDao extends JpaRepository<TransactionEntity, Long> {

	@Query("select max(t.transactionId) from TransactionEntity t")
	String queryMaxTransactionId();
    
	@Query("select new com.haly.entity.response.TransRespEntity("
			+ "o.orderNo, o.purchaseDate, o.productId, o.productName, "
			+ "o.purchasePrice, o.purchaseNum, o.purchaseAmount, "
			+ "t.transactionId, o.buyerId, o.buyerName, "
			+ "t.transactionAmount, t.transactionDate, t.remarks ) "
			+ "from TransactionEntity t, OrderHistoryEntity o, ProductEntity p "
			+ "where o.transactionId = t.transactionId and o.productId = p.productId "
			+ "and p.sellerId = ?1")
    List<TransRespEntity> queryOrderBySellerId(@Param("sellerId") String sellerId, Sort sort);
}
