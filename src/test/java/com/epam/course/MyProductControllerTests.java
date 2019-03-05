package com.epam.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.epam.course.controller.MyProductsController;
import com.epam.course.model.MyProduct;
import com.epam.course.service.MyProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(MyProductsController.class)
public class MyProductControllerTests {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private transient MyProductService myProdService;
	
	static MyProduct mockProd1 = new MyProduct(1, "prod name", "prod desc");
	static MyProduct mockProd2 = new MyProduct(2, "prod name2", "prod desc2");
	static MyProduct mockProd3 = new MyProduct(3, "", "prod desc3");
	static List<MyProduct> originalProdList = new ArrayList<>();
	static JSONObject mockProdJson;
	
	@BeforeClass
	public static void initialize() throws JSONException {	
			
		originalProdList.add(mockProd1);		
		mockProdJson = new JSONObject();
		mockProdJson.accumulate("prodId", 1);
		mockProdJson.accumulate("name", "prod name");
		mockProdJson.accumulate("desc", "prod desc");	
		
	}
	
	@Test
	public void getMyProductsTest() throws Exception {
		
		Mockito.when(myProdService.getMyProducts()).thenReturn((originalProdList));

		JSONArray mockResponse = new JSONArray();
		mockResponse.put(mockProdJson);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/myProducts")
		        .accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();	

		JSONAssert.assertEquals(mockResponse.toString(), result.getResponse().getContentAsString(), true);
	}
	
	@Test
	public void getMyProductTest() throws Exception {		
		
		Mockito.when(myProdService.getMyProduct(1L)).thenReturn(Optional.of(mockProd1));

		JSONArray mockResponse = new JSONArray();
		mockResponse.put(mockProdJson);		

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/myProducts/1")
		        .accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();	

		JSONAssert.assertEquals(mockResponse.get(0).toString(), result.getResponse().getContentAsString(), true);
	}
	
	@Test
	public void saveMyProductsTest() throws Exception {		
		
		Mockito.when(myProdService.saveMyProduct(Mockito.any())).thenReturn(mockProd2);

		JSONObject mockSuceessResponse = new JSONObject();
		mockSuceessResponse.accumulate("prodId", 2);
		mockSuceessResponse.accumulate("name", "prod name2");
		mockSuceessResponse.accumulate("desc", "prod desc2");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/myProducts").content(mockSuceessResponse.toString())
		        .contentType(MediaType.APPLICATION_JSON)
		        .accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();			

		JSONAssert.assertEquals(mockSuceessResponse.toString(), result.getResponse().getContentAsString(), true);
	}
	
	@Test
	public void removeMyProductTest() throws Exception {			
		
		Mockito.when(myProdService.removeMyProduct(3L)).thenReturn(Optional.of(mockProd3));

		JSONObject mockSuceessResponse = new JSONObject();
		mockSuceessResponse.accumulate("prodId", 3);
		mockSuceessResponse.accumulate("name", null);
		mockSuceessResponse.accumulate("desc", "Product deleted successfully");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/myProducts/3").content(mockSuceessResponse.toString())			
		      	.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();		
		System.out.println("original Response --> "+ result.getResponse().getContentAsString());

		JSONAssert.assertEquals(mockSuceessResponse.toString(), result.getResponse().getContentAsString(), false);
	}

}
