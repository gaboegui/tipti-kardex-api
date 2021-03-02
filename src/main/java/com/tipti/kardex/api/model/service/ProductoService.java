package com.tipti.kardex.api.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tipti.kardex.api.model.entity.Producto;


public interface ProductoService {
	
	public List<Producto> findAll();
	
	public Page<Producto> findAll(Pageable pageable);
	
	public Producto findOne(Long id);
	
	public Producto save(Producto producto);
	
	public void delete(Long id);

	public List<Producto> findByNombre(String term); 
}
