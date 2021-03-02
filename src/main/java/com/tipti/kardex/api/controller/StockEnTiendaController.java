package com.tipti.kardex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tipti.kardex.api.model.entity.StockEnTienda;
import com.tipti.kardex.api.model.entity.StockEnTiendaPK;
import com.tipti.kardex.api.model.service.StockEnTiendaService;

/**
 * Controller pra exponer los END Points de la entidad; StockEnTienda
 * 
 * @author Gabriel Eguiguren
 *
 */
@RestController
@RequestMapping(value = "/api/stockentienda")
public class StockEnTiendaController {

	@Autowired
	StockEnTiendaService stockService;

	/**
	 * Listar todos los elementos
	 * 
	 * @return
	 */
	@GetMapping(value = { "/list", "/", "" })
	public List<StockEnTienda> list() {
		return stockService.findAll();
	}

	/**
	 * Consultar uno en base a la clave compuesta  
	 *  
	 * @param producto
	 * @param tienda
	 * @param sku
	 * @return
	 */
	@GetMapping("/prod/{producto}/tienda/{tienda}/sku/{sku}")
	public StockEnTienda getOne(@PathVariable Long producto, @PathVariable Long tienda, @PathVariable String sku) {

		StockEnTiendaPK idStock = new StockEnTiendaPK(sku, producto, tienda);
		return stockService.findOne(idStock);
	}

	/**
	 * Editar uno en base a la clave compuesta
	 * 
	 * @param producto
	 * @param tienda
	 * @param sku
	 * @param stock
	 * @return
	 */
	@PutMapping("/prod/{producto}/tienda/{tienda}/sku/{sku}")
	public StockEnTienda edit(@PathVariable Long producto, @PathVariable Long tienda, @PathVariable String sku,
			@RequestBody StockEnTienda stock) {

		StockEnTiendaPK idStock = new StockEnTiendaPK(sku, producto, tienda);
		StockEnTienda registroEnBase = stockService.findOne(idStock);

		if (registroEnBase != null) {
			registroEnBase = stock;
			stockService.save(registroEnBase);
			return registroEnBase;
		}

		return null;

	}

	/**
	 * Crear un nuevo registro
	 * 
	 * @param stock
	 * @return
	 */
	@PostMapping("/nuevo")
	@ResponseStatus(HttpStatus.CREATED)
	public StockEnTienda save(@RequestBody StockEnTienda stock) {

		StockEnTienda registroEnBase = new StockEnTienda();
		registroEnBase = stock;
		stockService.save(registroEnBase);
		return registroEnBase;

	}

	/**
	 * Eliminar un item del inventario
	 * 
	 * @param producto
	 * @param tienda
	 * @param sku
	 */
	@DeleteMapping("/prod/{producto}/tienda/{tienda}/sku/{sku}")
	public void delete(@PathVariable Long producto, @PathVariable Long tienda, @PathVariable String sku) {

		StockEnTiendaPK idStock = new StockEnTiendaPK(sku, producto, tienda);
		StockEnTienda registroExistente = stockService.findOne(idStock);

		if (registroExistente != null) {
			stockService.delete(registroExistente);
		}

	}
}