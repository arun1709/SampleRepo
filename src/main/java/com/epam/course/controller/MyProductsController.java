package com.epam.course.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyProductsController {
	
	
	@GetMapping("/status")
	public ResponseEntity<String> getDeployStatus()	{					
			return ResponseEntity.ok("<!DOCTYPE html>\n" + 
					"<html>\n" + 
					"<head>\n" + 
					"<title>My Page</title>\n" + 
					"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
					"<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" + 
					"</head>\n" + 
					"<body>\n" + 
					"\n" + 
					"<h2>My page</h2>\n" + 
					"<div class=\"w3-container w3-green\">\n" + 
					"<p font> My Blue application</p>\n" + 
					"</div>\n" + 
					"</body>\n" + 
					"</html>");	
	}
	
}
