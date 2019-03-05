package com.epam.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.course.attributes.ProductCodes;
import com.epam.course.helper.ProductHelper;
import com.epam.course.model.MyProduct;
import com.epam.course.service.MyProductService;

@RestController
@RequestMapping("/api")
public class MyProductsController {
	
	@Autowired
	private transient MyProductService myProdService;
	
	
	@GetMapping("/myProducts")
	public ResponseEntity<List<MyProduct>> getMyProducts()	{
		
		if(!myProdService.getMyProducts().isEmpty()) {
			return ResponseEntity.ok(myProdService.getMyProducts());
		} else {			
			return ResponseEntity.ok(ProductHelper.buildErrMsg());
		}
		
	}
	
	@PostMapping("/myProducts")
	public ResponseEntity<MyProduct> saveMyProducts(@RequestBody MyProduct product)
	{	
		return ResponseEntity.ok(myProdService.saveMyProduct(product));
		
	}
	
	@GetMapping("/myProducts/{prodId}")
	public ResponseEntity<Optional<MyProduct>> getMyProduct(final @PathVariable long prodId)
	{
		Optional<MyProduct> product = myProdService.getMyProduct(prodId);
		if(!product.isPresent()) {	
			return ResponseEntity.ok(ProductHelper.buildErrMsg(prodId, ProductCodes.PROD_NOT_AVAIL));
		} else {
			return ResponseEntity.ok(myProdService.getMyProduct(prodId));
		}
		
	}
	
	@DeleteMapping("/myProducts/{prodId}")
	public ResponseEntity<?> removeMyProduct(final @PathVariable long prodId)
	{
		Optional<MyProduct> product = myProdService.removeMyProduct(prodId);
		
		if(!product.isPresent())			
			return ResponseEntity.ok(ProductHelper.buildErrMsg(prodId, ProductCodes.PROD_NOT_DEL));
		else
			return ResponseEntity.ok(ProductHelper.buildErrMsg(prodId, ProductCodes.PROD_DEL_SUCCESS));	
	}

}
