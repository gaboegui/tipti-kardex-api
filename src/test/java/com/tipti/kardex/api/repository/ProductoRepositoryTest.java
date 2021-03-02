package com.tipti.kardex.api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tipti.kardex.api.model.entity.Producto;
import com.tipti.kardex.api.model.repository.ProductoRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductoRepositoryTest {
	
	//private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private ProductoRepository productRepository;
	
	    
    @Test
    public void saveProducto(){
    	Producto product = new Producto("Mouse Genius", new BigDecimal(10.99));
    	productRepository.save(product);
        Producto productoDb = productRepository.findById(product.getId()).orElse(null);
        //existen 2 productos previos en la base de datos, por lo tanto este que añadimos es el tercero
        assertEquals(3, productoDb.getId().intValue());
        //borro el registro creado en este test
        productRepository.deleteById(productoDb.getId());
    }
    
    @Test
    public void listOfAllProducts(){
    	List<Producto> productList = productRepository.findAll();
    	
        assertEquals(2, productList.size());
    }
    
    @Test
    public void deleteProducto() {

    	Producto producto = new Producto("Monitor Panasonic", new BigDecimal(100.99));
    	productRepository.save(producto);
    	
    	productRepository.deleteById(producto.getId());
        Optional<Producto> optional = productRepository.findById(producto.getId());
        //log.info("Valor optional: " + optional);
        assertEquals(Optional.empty(), optional);
    }

}
