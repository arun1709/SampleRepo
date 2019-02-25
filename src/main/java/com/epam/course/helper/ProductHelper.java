package com.epam.course.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.epam.course.attributes.ProductCodes;
import com.epam.course.exception.ProductNotFoundException;
import com.epam.course.model.MyProduct;

public class ProductHelper {

	public static Optional<MyProduct> buildErrMsg(String errMsg) {
		return Optional.of(new ProductNotFoundException().buildErr(errMsg));
	}

	public static Optional<MyProduct> buildErrMsg(long prodId, String errMsg) {

		return Optional.of(new ProductNotFoundException().buildErr(prodId, errMsg));
	}

	public static List<MyProduct> buildErrMsg() {	
		List<MyProduct> noData = new ArrayList<MyProduct>(1);
		noData.add(new ProductNotFoundException().buildErr(ProductCodes.PRODS_NOT_AVAIL));
		return noData;
	}

}
