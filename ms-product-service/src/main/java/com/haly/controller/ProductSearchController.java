package com.haly.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haly.entity.ProductEntity;
import com.haly.entity.condition.SearchConditionForBuyerEntity;
import com.haly.service.ProductService;

/**
 * Product search controller
 *
 */

@RestController
@RequestMapping("/product")
public class ProductSearchController {
	
	@Autowired
	private ProductService productService;

    
    @RequestMapping("/searchid")
    public ProductEntity searchById(@RequestParam(value = "prdId") String prdId) {
    	
    	return productService.getProductById(prdId);
    	
    }
    
    @RequestMapping("/search")
//    @CrossOrigin(origins = "*")
    public List<ProductEntity> searchByName(@RequestParam(value = "prdName") String prdName) {
    	
    	List<ProductEntity> prdList = productService.getProductByName(prdName);
    	
    	if (prdList == null) {
    		return new ArrayList<ProductEntity>();
    	} else {
    		return prdList;
    	}
    }
    
    @RequestMapping("/psearchbyname")
    public Page<ProductEntity> pagingSearchByName(@RequestParam(value = "prdName") String prdName,
    		@RequestParam(value = "page") int pageNum, @RequestParam(value = "size") int pageSize) {
    	
    	Page<ProductEntity> prdList = productService.getProductByNamePaging(prdName, pageNum, pageSize);

		return prdList;
    }
    
    @RequestMapping("/psearch")
    public Page<ProductEntity> pagingSearchAll(@RequestParam(value = "page") int pageNum, 
    		@RequestParam(value = "size") int pageSize) {
    	
    	Page<ProductEntity> prdList = productService.getProductAllPaging(pageNum, pageSize);
    	
		return prdList;
    }
    
    @RequestMapping("/asearch")
    public List<ProductEntity> searchAll() {
    	
    	List<ProductEntity> prdList = productService.getProductAll();
    	
    	if (prdList == null) {
    		return new ArrayList<ProductEntity>();
    	} else {
    		return prdList;
    	}
    }
    
    @RequestMapping("/fsearch")
  public List<ProductEntity> searchByFilters(@RequestBody SearchConditionForBuyerEntity bcond) {
    // test code start
//	public List<ProductEntity> searchByFilters() {
  	
//    	SearchConditionForBuyerEntity bcond = new SearchConditionForBuyerEntity();
//    	bcond.setCategoryId("分类1");
//    	bcond.setSubcategoryId("子分类3");
//    	bcond.setPriceFrom("35.06");
//    	bcond.setPriceTo("69");
	  	// test code end
  	
	  	return this.productService.getProductByFilters(bcond);
	}
    
}
