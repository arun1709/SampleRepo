/**
 * 
 */
package com.epam.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.epam.course.model.MyProduct;

/**
 * @author Rama_Karri
 *
 */
@Service
public interface MyProductService {
	
	public List<MyProduct> getMyProducts();
	public MyProduct saveMyProduct(MyProduct product);
	public Optional<MyProduct> getMyProduct(long prodId);
	public Optional<MyProduct> removeMyProduct(long prodId);
	//public boolean removeMyProduct(long prodId);
	

}
