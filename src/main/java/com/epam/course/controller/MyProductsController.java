package com.epam.course.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyProductsController {
	
	/*@Autowired
	private transient MyProductService myProdService;*/
	
	@GetMapping("/status")
	public ResponseEntity<String> getDeployStatus()	{					
			return ResponseEntity.ok("<!DOCTYPE html>\n" + 
					"<html>\n" + 
					"<head>\n" + 
					"<title>Cloud N DevOps Hackathon Event 2019</title>\n" + 
					"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
					"<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" + 
					"</head>\n" + 
					"<body>\n" + 
					"\n" + 
					"<h2>Cloud N DevOps Hackathon Event 2019</h2>\n" + 
					"<div class=\"w3-container w3-green\">\n" + 
					"<p font>Team A :  Green deployment application</p>\n" + 
					"</div>\n" + 
					"</body>\n" + 
					"</html>");	
	}
	
	/*@GetMapping("/myProducts")
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
	}*/

}
