package com.epam.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.course.model.MyProduct;
import com.epam.course.repository.MyProductRepository;

@Service
public class MyProductServiceImpl implements MyProductService {
	@Autowired
	private MyProductRepository myProdRepo;

	@Override
	public List<MyProduct> getMyProducts() {

		return myProdRepo.findAll();
	}

	@Override
	public MyProduct saveMyProduct(MyProduct product) {
		myProdRepo.save(product);
		return product;
	}
	
	@Override
	public Optional<MyProduct> getMyProduct(long prodId)
	{
		Optional<MyProduct> product = myProdRepo.findById(prodId);
		return product;
	}
	
	@Override
	public Optional<MyProduct> removeMyProduct(long prodId)
	{
		Optional<MyProduct> product = myProdRepo.findById(prodId);				
		return product;
	}
	/*
	@Override
	public boolean removeMyProduct(long prodId)
	{
		Optional<MyProduct> product = myProdRepo.findById(prodId);
		boolean isExist = product.isPresent();
		if(isExist){
			myProdRepo.deleteById(prodId);
		}		
		return isExist;
	}*/

}
