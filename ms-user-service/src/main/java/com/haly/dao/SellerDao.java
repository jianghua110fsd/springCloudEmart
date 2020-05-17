package com.haly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.haly.entity.SellerEntity;

@Repository
public interface SellerDao extends JpaRepository<SellerEntity, String> {

    @Query("select s from SellerEntity s where s.sellerId = ?1")
    SellerEntity getSellerInfo(@Param("sellerId") String sellerId);
     
}
