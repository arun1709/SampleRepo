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
import com.epam.course.model.Product;
import com.epam.course.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductsController {
	
	@Autowired
	private transient ProductService myProdService;
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts()	{
		
		if(!myProdService.getProducts().isEmpty()) {
			return ResponseEntity.ok(myProdService.getProducts());
		} else {			
			return ResponseEntity.ok(ProductHelper.buildErrMsg());
		}
		
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> saveProducts(@RequestBody Product product)
	{	
		return ResponseEntity.ok(myProdService.saveProduct(product));
		
	}
	
	@GetMapping("/products/{prodId}")
	public ResponseEntity<Optional<Product>> getProduct(final @PathVariable long prodId)
	{
		Optional<Product> product = myProdService.getProduct(prodId);
		if(!product.isPresent()) {	
			return ResponseEntity.ok(ProductHelper.buildErrMsg(prodId, ProductCodes.PROD_NOT_AVAIL));
		} else {
			return ResponseEntity.ok(myProdService.getProduct(prodId));
		}
		
	}
	
	@DeleteMapping("/products/{prodId}")
	public ResponseEntity<?> removeProduct(final @PathVariable long prodId)
	{
		Optional<Product> product = myProdService.removeProduct(prodId);
		
		if(!product.isPresent())			
			return ResponseEntity.ok(ProductHelper.buildErrMsg(prodId, ProductCodes.PROD_NOT_DEL));
		else
			return ResponseEntity.ok(ProductHelper.buildErrMsg(prodId, ProductCodes.PROD_DEL_SUCCESS));	
	}

}
