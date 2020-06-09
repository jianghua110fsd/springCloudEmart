package com.haly.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.haly.entity.CartEntity;
import com.haly.entity.response.CartRespEntity;

@Repository
public interface CartDao extends JpaRepository<CartEntity, Long> {

	@Query("select count(c.cartPk.productId) from CartEntity c where c.cartPk.buyerId = ?1")
	int getCartItemCntByBuyerId(@Param("buyerId") String buyerId);
	
	@Query("select count(c.cartPk.productId) from CartEntity c where c.cartPk.buyerId = ?1 and c.cartPk.productId = ?2")
	int getCartItemCntByKey(@Param("buyerId") String buyerId, @Param("productId") String productId);
	
	@Query("select c from CartEntity c where c.cartPk.buyerId = ?1 and c.cartPk.productId = ?2")
	CartEntity getCartItemByKey(@Param("buyerId") String buyerId, @Param("productId") String productId);
	
	@Query("select c from CartEntity c where c.cartPk.buyerId = ?1")
	List<CartEntity> getCartItems(@Param("buyerId") String buyerId);
	
	@Query("select new com.haly.entity.response.CartRespEntity("
			+ "c.cartPk.buyerId, c.cartPk.productId, c.productName, c.sellerId, "
			+ "p.categoryName, p.subcategoryName, p.unit, "
			+ "c.purchasePrice, c.purchaseNum, c.purchaseAmount, c.remarks ) "
			+ "from CartEntity c, ProductEntity p "
			+ "where c.cartPk.productId = p.productId and c.cartPk.buyerId = ?1")
	List<CartRespEntity> queryCartByBuyerId(@Param("buyerId") String buyerId, Sort sort);

	// For checkout page search
	@Query("select new com.haly.entity.response.CartRespEntity("
			+ "c.cartPk.buyerId, c.cartPk.productId, c.productName, c.sellerId, "
			+ "p.categoryName, p.subcategoryName, p.unit, "
			+ "c.purchasePrice, c.purchaseNum, c.purchaseAmount, c.remarks ) "
			+ "from CartEntity c, ProductEntity p "
			+ "where c.cartPk.productId = p.productId and c.cartPk.buyerId = ?1 and c.cartPk.productId in ?2")
	List<CartRespEntity> queryCartByBuyerIdAndPrdIds(@Param("buyerId") String buyerId, @Param("prdIds") List<String> prdIds, Sort sort);
	
	@Transactional
	@Modifying
    @Query(nativeQuery = true, value = "delete from cart_tbl where buyer_id = ?1")
	int deleteByBuyerId(@Param("buyerId") String buyerId);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "delete from cart_tbl where buyer_id = ?1 and product_id = ?2")
	int deleteByKey(@Param("buyerId") String buyerId, @Param("productId") String productId);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update cart_tbl set purchase_num = ?1, update_datetime = now() where buyer_id = ?2 and product_id = ?3")
	void updatePurchaseNumber(@Param("pchNum") int pchNum, @Param("buyerId") String buyerId, @Param("productId") String productId);

}
