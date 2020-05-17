package com.haly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.haly.entity.TransactionEntity;

@Repository
public interface TransactionDao extends JpaRepository<TransactionEntity, Long> {

	@Query("select max(t.transactionId) from TransactionEntity t")
	String queryMaxTransactionId();
    
}
