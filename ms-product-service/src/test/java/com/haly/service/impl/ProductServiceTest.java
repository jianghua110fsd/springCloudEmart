/**
 * 
 */
package com.haly.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import com.haly.MsProductApplication;
import com.haly.dao.ProductDao;
import com.haly.entity.ProductEntity;
import com.haly.entity.condition.SearchConditionForBuyerEntity;

/**
 * @author Jiang hua
 *
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MsProductApplication.class})
public class ProductServiceTest  {

	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private ProductDao productDao;

	
	/**
	 * Search product all
	 *
	 */
	@Test
	@Transactional
    public void testGetProductAll() {
		
		// Delete all product data existed
		this.productDao.deleteAll();
		
		// Create and Insert data for this test
		// Create
		List<ProductEntity> prdList = new ArrayList<ProductEntity>();
		prdList.add(new ProductEntity("p555", "商品5", "描述5", 19.5f, 600));
		prdList.add(new ProductEntity("p666", "商品6", "c11", "c11_name", "sc11", "sc11_name",
								"s11", "Zhi", "描述6", 12.5f, 400));
		prdList.add(new ProductEntity("p777", "商品7", "c11", "c11_name", "sc11", "sc11_name",
								"s11", "Zhi", "描述7", 12.5f, 400));
		
		// Insert
		for (ProductEntity prd : prdList) {
			this.productDao.save(prd);
		}
		
		// Search product data all
		List<ProductEntity> rtnList = productService.getProductAll();
    	
		// See if search results meet expected
		assertEquals(3, rtnList.size());
    }
	
	/**
	 * Search product by id
	 *
	 */
	@Test
	@Transactional
	public void testGetProductById1() {
		
		// Delete all product data existed
		this.productDao.deleteAll();
		
		// Create and Insert data for this test
		// Create
		List<ProductEntity> prdList = new ArrayList<ProductEntity>();
		prdList.add(new ProductEntity("p555", "商品5", "描述5", 19.5f, 600));
		prdList.add(new ProductEntity("p666", "商品6", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Zhi", "描述6", 12.5f, 400));
		prdList.add(new ProductEntity("p777", "商品7", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Zhi", "描述7", 12.5f, 400));
		
		// Insert
		for (ProductEntity prd : prdList) {
			this.productDao.save(prd);
		}
		
		// Search product data by id
		ProductEntity product = productService.getProductById("p666");
		
		// See if search results meet expected
		assertEquals("商品6", product.getProductName());
	}
	
	/**
	 * Search product by id
	 *
	 */
	@Test
	@Transactional
	public void testGetProductById2() {
		
		// Delete all product data existed
		this.productDao.deleteAll();
		
		// Create and Insert data for this test
		// Create
		List<ProductEntity> prdList = new ArrayList<ProductEntity>();
		prdList.add(new ProductEntity("p555", "商品5", "描述5", 19.5f, 600));
		prdList.add(new ProductEntity("p666", "商品6", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Zhi", "描述6", 12.5f, 400));
		prdList.add(new ProductEntity("p777", "商品7", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Zhi", "描述7", 12.5f, 400));
		
		// Insert
		for (ProductEntity prd : prdList) {
			this.productDao.save(prd);
		}
		
		// Search product data by id
		ProductEntity product = productService.getProductById("p888");
		
		// See if search results meet expected
		assertNull(product);
	}
	
	/**
	 * Search product by name
	 *
	 */
	@Test
	@Transactional
	public void testGetProductByName() {
		
		// Delete all product data existed
		this.productDao.deleteAll();
		
		// Create and Insert data for this test
		// Create
		List<ProductEntity> prdList = new ArrayList<ProductEntity>();
		prdList.add(new ProductEntity("p555", "商品5-1", "描述5", 19.5f, 600));
		prdList.add(new ProductEntity("p666", "商品6", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Zhi", "描述6", 12.5f, 400));
		prdList.add(new ProductEntity("p777", "商品5-2", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Zhi", "描述7", 12.5f, 400));
		
		// Insert
		for (ProductEntity prd : prdList) {
			this.productDao.save(prd);
		}
		
		// Search product data by product name
		List<ProductEntity> rtnList = productService.getProductByName("5-");
		
		// See if search results meet expected
		assertEquals(2, rtnList.size());
		assertEquals("商品5-2", rtnList.get(1).getProductName());
	}
	
	/**
	 * Search product by name and paging
	 *
	 */
	@Test
	@Transactional
	public void testGetProductByNamePaging() {
		
		// Delete all product data existed
		this.productDao.deleteAll();
		
		// Create and Insert data for this test
		// Create
		List<ProductEntity> prdList = new ArrayList<ProductEntity>();
		prdList.add(new ProductEntity("p555", "商品5-1", "描述5", 19.5f, 600));
		prdList.add(new ProductEntity("p666", "商品5-3", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Zhi", "描述6", 12.5f, 400));
		prdList.add(new ProductEntity("p777", "商品5-2", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Zhi", "描述7", 12.5f, 400));
		
		// Insert
		for (ProductEntity prd : prdList) {
			this.productDao.save(prd);
		}
		
		// Search product data by product name
		Page<ProductEntity> rtnList = productService.getProductByNamePaging("5-", 1, 2);
		
		// See if search results meet expected
		assertEquals(1, rtnList.getContent().size());
		assertEquals("商品5-3", rtnList.getContent().get(0).getProductName());
	}
	
	/**
	 * Search product by category
	 *
	 */
	@Test
	@Transactional
	public void testGetProductByFilters1() {
		
		// Delete all product data existed
		this.productDao.deleteAll();
		
		// Create and Insert data for this test
		// Create
		List<ProductEntity> prdList = new ArrayList<ProductEntity>();
		prdList.add(new ProductEntity("p555", "商品5", "描述5", 19.5f, 600));
		prdList.add(new ProductEntity("p666", "商品6", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Zhi", "描述6", 12.5f, 400));
		prdList.add(new ProductEntity("p777", "商品7", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Zhi", "描述7", 12.5f, 400));
		
		// Insert
		for (ProductEntity prd : prdList) {
			this.productDao.save(prd);
		}
		
		// Search product data by category
		SearchConditionForBuyerEntity bcond = new SearchConditionForBuyerEntity();
		bcond.setCategoryId("c11");
		List<ProductEntity> rtnList = productService.getProductByFilters(bcond);
		
		// See if search results meet expected
		assertEquals(2, rtnList.size());
		assertEquals("商品7", rtnList.get(1).getProductName());
	}
	
	/**
	 * Search product by price range
	 *
	 */
	@Test
	@Transactional
	public void testGetProductByFilters2() {
		
		// Delete all product data existed
		this.productDao.deleteAll();
		
		// Create and Insert data for this test
		// Create
		List<ProductEntity> prdList = new ArrayList<ProductEntity>();
		prdList.add(new ProductEntity("11111", "商品1", "描述1", 19.5f, 600));
		prdList.add(new ProductEntity("p222", "商品2", "描述2", 25.5f, 200));
		prdList.add(new ProductEntity("p333", "商品3-3", "描述3", 50f, 100));
		prdList.add(new ProductEntity("p444", "商品3-4", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Ge", "描述4", 125f, 50));
		prdList.add(new ProductEntity("p555", "商品5", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Ge", "描述5", 129.9f, 40));
		
		// Insert
		for (ProductEntity prd : prdList) {
			this.productDao.save(prd);
		}
		
		// Search product data by price range
		SearchConditionForBuyerEntity bcond = new SearchConditionForBuyerEntity();
    	bcond.setPriceFrom("25.5");
    	bcond.setPriceTo("125");
		List<ProductEntity> rtnList = productService.getProductByFilters(bcond);
		
		// See if search results meet expected
		assertEquals(3, rtnList.size());
		assertEquals("商品3-4", rtnList.get(2).getProductName());
	}
	
	/**
	 * Search product by product name
	 *
	 */
	@Test
	@Transactional
	public void testGetProductByFilters3() {
		
		// Delete all product data existed
		this.productDao.deleteAll();
		
		// Create and Insert data for this test
		// Create
		List<ProductEntity> prdList = new ArrayList<ProductEntity>();
		prdList.add(new ProductEntity("11111", "商品1", "描述1", 19.5f, 600));
		prdList.add(new ProductEntity("p222", "商品2", "描述2", 25.5f, 200));
		prdList.add(new ProductEntity("p333", "商品3-3", "描述3", 50f, 100));
		prdList.add(new ProductEntity("p444", "商品3-4", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Ge", "描述4", 125f, 50));
		prdList.add(new ProductEntity("p555", "商品5", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Ge", "描述5", 129.9f, 40));
		
		// Insert
		for (ProductEntity prd : prdList) {
			this.productDao.save(prd);
		}
		
		// Search product data by product name
		SearchConditionForBuyerEntity bcond = new SearchConditionForBuyerEntity();
		bcond.setPrdName("3-");
		List<ProductEntity> rtnList = productService.getProductByFilters(bcond);
		
		// See if search results meet expected
		assertEquals(2, rtnList.size());
		assertEquals("商品3-3", rtnList.get(0).getProductName());
	}
	
	/**
	 * Search products all by paging
	 *
	 */
	@Test
	@Transactional
	public void testGetProductAllPaging() {
		
		// Delete all product data existed
		this.productDao.deleteAll();
		
		// Create and Insert data for this test
		// Create
		List<ProductEntity> prdList = new ArrayList<ProductEntity>();
		prdList.add(new ProductEntity("p111", "商品1", "描述1", 19.5f, 600));
		prdList.add(new ProductEntity("p222", "商品2", "描述2", 25.5f, 200));
		prdList.add(new ProductEntity("p333", "商品3-3", "描述3", 50f, 100));
		prdList.add(new ProductEntity("p666", "商品3-1", "描述3-1", 45f, 100));
		prdList.add(new ProductEntity("p444", "商品3-4", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Ge", "描述4", 125f, 50));
		prdList.add(new ProductEntity("p555", "商品5", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Ge", "描述5", 129.9f, 40));
		
		// Insert
		for (ProductEntity prd : prdList) {
			this.productDao.save(prd);
		}
		
		// Search product data
		Page<ProductEntity> rtnPage = productService.getProductAllPaging(1,3);
		
		// See if search results meet expected
		assertEquals(3, rtnPage.getContent().size());
		assertEquals("商品3-3", rtnPage.getContent().get(0).getProductName());
	}
	
	/**
	 * Search product by paging and by filters
	 *
	 */
	@Test
	@Transactional
	public void testgetProductByFiltersPaging() {
		
		// Delete all product data existed
		this.productDao.deleteAll();
		
		// Create and Insert data for this test
		// Create
		List<ProductEntity> prdList = new ArrayList<ProductEntity>();
		prdList.add(new ProductEntity("11111", "商品1", "描述1", 19.5f, 600));
		prdList.add(new ProductEntity("p222", "商品2", "描述2", 25.5f, 200));
		prdList.add(new ProductEntity("p333", "商品3-3", "描述3", 50f, 100));
		prdList.add(new ProductEntity("p666", "商a品3-1", "描述3-1", 45f, 100));
		prdList.add(new ProductEntity("p444", "商品3-4", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Ge", "描述4", 125f, 50));
		prdList.add(new ProductEntity("p555", "商品5", "c11", "c11_name", "sc11", "sc11_name",
				"s11", "Ge", "描述5", 129.9f, 40));
		
		// Insert
		for (ProductEntity prd : prdList) {
			this.productDao.save(prd);
		}
		
		// Search product data
		SearchConditionForBuyerEntity bcond = new SearchConditionForBuyerEntity();
		bcond.setPrdName("商品");
		bcond.setPage(1);
		bcond.setSize(3);
		Page<ProductEntity> rtnPage = productService.getProductByFiltersPaging(bcond);
		
		// See if search results meet expected
		assertEquals(2, rtnPage.getContent().size());
		assertEquals("商品3-4", rtnPage.getContent().get(0).getProductName());
	}

}
