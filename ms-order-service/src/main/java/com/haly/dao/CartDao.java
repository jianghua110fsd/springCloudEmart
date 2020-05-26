package com.haly.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.haly.entity.CartEntity;
import com.haly.entity.response.CartRespEntity;

@Repository
public interface CartDao extends JpaRepository<CartEntity, Long> {

	@Query("select new com.haly.entity.response.CartRespEntity("
			+ "c.cartPk.buyerId, c.cartPk.productId, c.productName, c.sellerId, "
			+ "p.categoryName, p.subcategoryName, p.unit, "
			+ "c.purchasePrice, c.purchaseNum, c.purchaseAmount, c.remarks ) "
			+ "from CartEntity c, ProductEntity p "
			+ "where c.cartPk.productId = p.productId and c.cartPk.buyerId = ?1")
	List<CartRespEntity> queryCartByBuyerId(@Param("buyerId") String buyerId, Sort sort);

}
