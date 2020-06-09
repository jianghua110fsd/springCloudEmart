package com.haly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    
    @RequestMapping("/save")
    public ProductEntity saveProduct(@RequestBody ProductEntity prd) {
    // test code start
//	public ProductEntity saveProduct() {
  	
//    	ProductEntity prd = new ProductEntity("55555", "Name555", "for update test", 35f, 200);
	  	// test code end

    	ProductEntity prd1 = this.productService.saveProduct(prd);

	  	return prd1;
	}
    
    @RequestMapping("/delete")
//    public String deleteProduct(@RequestParam(value = "prdId") String prdId) {
    // test code start
    public String deleteProduct(String prdId) {
    	
    	prdId = "55555";
    	// test code end
    	try {
    		this.productService.deleteProduct(prdId);
    	} catch (Exception e) {
    		return "0";
    	}
    	
    	return "1";
    }
    
}
