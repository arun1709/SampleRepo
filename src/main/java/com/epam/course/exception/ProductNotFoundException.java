package com.epam.course.exception;

import com.epam.course.model.MyProduct;

public class ProductNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		
	}

	public ProductNotFoundException(String errMsg) {
		super(errMsg);
	}
	
	public MyProduct buildErr(String errMsg) {		
		MyProduct prdErrMsg = new MyProduct();
		prdErrMsg.setDesc(errMsg);		
		return prdErrMsg;			
	}
	
	public MyProduct buildErr(long prodId,String errMsg) {		
		MyProduct prdErrMsg = new MyProduct();
		prdErrMsg.setDesc(errMsg);
		prdErrMsg.setProdId(prodId);
		return prdErrMsg;			
	}

}
