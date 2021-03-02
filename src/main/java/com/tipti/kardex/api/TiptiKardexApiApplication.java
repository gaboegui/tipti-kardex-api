package com.tipti.kardex.api;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.tipti.kardex.api.model.entity.Categoria;
import com.tipti.kardex.api.model.entity.Ciudad;
import com.tipti.kardex.api.model.entity.Producto;
import com.tipti.kardex.api.model.entity.StockEnTienda;
import com.tipti.kardex.api.model.entity.StockEnTiendaPK;
import com.tipti.kardex.api.model.entity.Tienda;
import com.tipti.kardex.api.model.service.CategoriaService;
import com.tipti.kardex.api.model.service.CiudadService;
import com.tipti.kardex.api.model.service.ProductoService;
import com.tipti.kardex.api.model.service.StockEnTiendaService;
import com.tipti.kardex.api.model.service.SubCategoriaService;
import com.tipti.kardex.api.model.service.TiendaService;

@SpringBootApplication
public class TiptiKardexApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiptiKardexApiApplication.class, args);
	}

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	CiudadService ciudadService;

	@Autowired
	ProductoService productoService;

	@Autowired
	StockEnTiendaService stockEnTiendaService;

	@Autowired
	SubCategoriaService subCategoriaService;

	@Autowired
	TiendaService tiendaService;

	@PostConstruct
	@Transactional
	void llenarDatos() {
		
		List<Ciudad> ciudades = Arrays.asList(new Ciudad("Quito"), new Ciudad("Guayaquil"), new Ciudad("Loja"), new Ciudad("Ambato"));
		
		ciudadService.save(ciudades.get(0));
		ciudadService.save(ciudades.get(1));
		ciudadService.save(ciudades.get(2));
		ciudadService.save(ciudades.get(3));
		
		ciudades = ciudadService.findAll();
		
		tiendaService.save(new Tienda(ciudades.get(0),"Sucursal 1"));
		tiendaService.save(new Tienda(ciudades.get(1),"Sucursal 2"));
		tiendaService.save(new Tienda(ciudades.get(2),"Sucursal 3"));
		tiendaService.save(new Tienda(ciudades.get(3),"Sucursal 4"));
		Tienda tienda = tiendaService.findAll().get(0);
		
		productoService.save(new Producto("Mouse", new BigDecimal(10.99)));
		productoService.save(new Producto("Monitor 17", new BigDecimal(250.99)));
		Producto producto = productoService.findOne((long) 1);
		
		categoriaService.save(new Categoria("Equipos de computación","",""));
		Categoria categoria = categoriaService.findAll().get(0);
		
		StockEnTienda stock = new StockEnTienda("001-052365", producto, tienda, categoria);
		stockEnTiendaService.save(stock);
		
		StockEnTiendaPK idStock = new StockEnTiendaPK();
		idStock.setProducto(producto.getId());
		idStock.setTienda(tienda.getId());
		idStock.setSKU("001-052365");
		
		stock = stockEnTiendaService.findOne(idStock);
		
		stock.setPvp(producto.getVentaAlGranel());
		stock.setPrecioCompra(new BigDecimal(7.99));
		
		stockEnTiendaService.save(stock);

	}

}
