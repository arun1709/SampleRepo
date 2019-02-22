package com.epam.course.exception;

import com.epam.course.model.MyProduct;

public class ProductNotFoundException extends Exception {
	
	public ProductNotFoundException() {
		
	}

	public ProductNotFoundException(String errMsg) {
		super(errMsg);
	}
	
	public MyProduct buildErr(long prodId,String errMsg) {		
		MyProduct prdErrMsg = new MyProduct();
		prdErrMsg.setDesc(errMsg);
		prdErrMsg.setProdId(prodId);
		return prdErrMsg;			
	}

}
