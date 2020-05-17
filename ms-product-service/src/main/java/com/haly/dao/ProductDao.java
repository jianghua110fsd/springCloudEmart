package com.haly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.haly.entity.ProductEntity;

@Repository
public interface ProductDao extends PagingAndSortingRepository<ProductEntity, String>, 
									JpaSpecificationExecutor<ProductEntity> {

    @Query("select p from ProductEntity p where p.productId = ?1")
    List<ProductEntity> queryProductById(@Param("productId") String productId);
    
    @Query("select p from ProductEntity p where p.productName like %?1%")
    List<ProductEntity> queryProductByName(@Param("productName") String productName, Sort sort);
    
    @Query("select p from ProductEntity p where p.productName like %?1%")
    Page<ProductEntity> queryProductByName(@Param("productName") String productName, Pageable pageable);
    
//    List<ProductEntity> findByFilters(Specification<ProductEntity> specification, Sort sort);
//    Page<ProductEntity> findByFiltersPaging(Specification<ProductEntity> specification, Pageable pageable);
}
