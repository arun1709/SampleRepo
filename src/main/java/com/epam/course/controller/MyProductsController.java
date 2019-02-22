package com.epam.course.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.epam.course.exception.ProductNotFoundException;
import com.epam.course.model.MyProduct;
import com.epam.course.service.MyProductService;

@RestController
@RequestMapping("/api")
public class MyProductsController {
	
	@Autowired
	private MyProductService myProdService;
	
	
	@GetMapping("/myProducts")
	public ResponseEntity<List<MyProduct>> getMyProducts()
	{
		return ResponseEntity.ok(myProdService.getMyProducts());
	}
	
	@PostMapping("/myProducts")
	public ResponseEntity<MyProduct> saveMyProducts(@RequestBody MyProduct product)
	{
		
		myProdService.saveMyProduct(product);
		URI location =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{prodId}").buildAndExpand(product.getProdId()).toUri();
		return ResponseEntity.created(location).body(product);
	}
	
	@GetMapping("/myProducts/{prodId}")
	public ResponseEntity<Optional<MyProduct>> getMyProduct(@PathVariable long prodId)
	{
		Optional<MyProduct> product = myProdService.getMyProduct(prodId);
		if(!product.isPresent()) {
			return ResponseEntity.ok(Optional.of(new ProductNotFoundException().buildErr(prodId,"Product not available")));						
		} else {
			return ResponseEntity.ok(myProdService.getMyProduct(prodId));
		}		
	}
	
	@DeleteMapping("/myProducts/{prodId}")
	public ResponseEntity<?> removeMyProduct(@PathVariable long prodId)
	{
		Optional<MyProduct> product = myProdService.removeMyProduct(prodId);
		
		if(!product.isPresent())
			return ResponseEntity.ok(Optional.of(new ProductNotFoundException().buildErr(prodId,"Product is not deleted as it's not available")));	
		else
			return ResponseEntity.ok(Optional.of(new ProductNotFoundException().buildErr(prodId,"Product deleted successfully")));
		//return ResponseEntity.noContent().build();

	}

}
