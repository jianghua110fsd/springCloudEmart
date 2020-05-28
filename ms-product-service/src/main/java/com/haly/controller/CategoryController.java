package com.haly.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haly.entity.CategoryEntity;
import com.haly.entity.SubcategoryEntity;
import com.haly.service.ProductService;

/**
 * Category search controller
 *
 */

@RestController
@RequestMapping("/product")
public class CategoryController {
	
	@Autowired
	private ProductService productService;

    @RequestMapping("/csearch")
    public List<CategoryEntity> searchCategory() {
    	
    	List<CategoryEntity> catList = productService.getCategoryAll();
    	
    	if (catList == null) {
    		return new ArrayList<CategoryEntity>();
    	} else {
    		return catList;
    	}
    }
    
    @RequestMapping("/scsearch")
  public List<SubcategoryEntity> searchByFilters(@RequestParam(value = "catgoryid") String categoryId) {
  	
    	List<SubcategoryEntity> catList = this.productService.getSubCategories(categoryId);

    	if (catList == null) {
    		return new ArrayList<SubcategoryEntity>();
    	} else {
    		return catList;
    	}
	}
    
}
