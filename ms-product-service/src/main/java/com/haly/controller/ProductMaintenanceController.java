package com.haly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.haly.entity.ProductEntity;
import com.haly.service.ProductService;

/**
 * Hello world!
 *
 */

@RestController
@RequestMapping("/product")
public class ProductMaintenanceController 
{

	@Autowired
	private ProductService productService;

    
	@PostMapping("/save")
    public ProductEntity saveProduct(@RequestBody ProductEntity prd) {
    	ProductEntity prd1 = this.productService.saveProduct(prd);

	  	return prd1;
	}

	@Autowired
	private ProductService prdDeleteService;
	
    @RequestMapping("/delete")
    public String deleteProduct(@RequestParam(value = "prdId") String prdId) {
    	System.out.println(prdId);
    	try {
    		this.prdDeleteService.deleteProduct(prdId);
    	} catch (Exception e) {
    		return "0";
    	}
    	return "1";
    }
    
}
