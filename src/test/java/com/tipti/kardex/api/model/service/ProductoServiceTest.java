package com.tipti.kardex.api.model.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.tipti.kardex.api.model.entity.Producto;
import com.tipti.kardex.api.model.repository.ProductoRepository;
import com.tipti.kardex.api.model.service.impl.ProductoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {

	@Mock
	private ProductoRepository productRepository;

	@Autowired
	@InjectMocks
	private ProductoServiceImpl productService;

	private Producto product1;
	private Producto product2;
	List<Producto> productList;

	@BeforeEach
	public void setUp() {
		productList = new ArrayList<>();
		product1 = new Producto( "Monitor LG 15", new BigDecimal(100.99));
		product1.setId(new Long(1));
		product2 = new Producto( "Monitor LG 17", new BigDecimal(120.99));
		productList.add(product1);
		productList.add(product2);
	}

	@AfterEach
	public void tearDown() {
		product1 = product2 = null;
		productList = null;
	}

	@Test
	void saveProduct() {
		Producto product = new Producto( "Monitor LG", new BigDecimal(99.99));
		when(productRepository.save(product)).thenReturn(product);
		assertEquals(product.getNombre(), productService.save(product).getNombre());
	}
	
	
	@Test
	public void findAllProducts(){
	     productRepository.save(product1);
	    //stubbing mock to return specific data
	    when(productRepository.findAll()).thenReturn(productList);
	    List<Producto> productList1 =productService.findAll();
	    assertEquals(productList1,productList);
	    verify(productRepository,times(1)).save(product1);
	    verify(productRepository,times(1)).findAll();
	}
	
	@Test
	public void findById() {
	   when(productRepository.findById(new Long(1))).thenReturn(Optional.ofNullable(product1));
	   assertThat(productService.findOne(product1.getId())).isEqualTo(product1);
	}

}
