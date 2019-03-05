package com.epam.course;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.course.model.MyProduct;
import com.epam.course.repository.MyProductRepository;
import com.epam.course.service.MyProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyProductServiceTests {

	@Mock
	private MyProductRepository prodRepo;

	@InjectMocks
	private MyProductServiceImpl productService;

	MyProduct mockProd1 = new MyProduct(1, "prod name1", "prod desc1");
	MyProduct mockProd2 = new MyProduct(2, "prod name2", "prod desc2");

	@Test
	public void getMyProducts() {
		List<MyProduct> mockProdList = new ArrayList<>();
		mockProdList.add(mockProd2);
		mockProdList.add(mockProd1);

		when(prodRepo.findAll()).thenReturn(mockProdList);
		assertEquals(mockProdList, productService.getMyProducts());
	}

	@Test
	public void getMyProduct() {

		when(prodRepo.findById(anyLong())).thenReturn(Optional.of(mockProd1));
		assertEquals(mockProd1, productService.getMyProduct(1L).get());

	}

	@Test
	public void saveMyProduct() {

		when(prodRepo.save(mockProd1)).thenReturn(mockProd1);
		assertEquals(mockProd1, productService.saveMyProduct(mockProd1));

	}	

	@Test(expected = NoSuchElementException.class)
	public void testNoSuchElementException() {

		when(prodRepo.findById(anyLong())).thenReturn(Optional.empty());
		Optional<MyProduct> prod = productService.getMyProduct(1L);
		prod.get();
	}

}
