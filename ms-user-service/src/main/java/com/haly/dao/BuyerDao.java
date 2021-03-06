package com.haly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.haly.entity.BuyerEntity;

@Repository
public interface BuyerDao extends JpaRepository<BuyerEntity, String>  {

    @Query("select b from BuyerEntity b where b.buyerId = ?1")
    BuyerEntity getBuyerInfo(@Param("buyerId") String buyerId);
}
