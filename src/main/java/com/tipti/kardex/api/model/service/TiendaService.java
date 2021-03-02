package com.tipti.kardex.api.model.service;

import java.util.List;

import com.tipti.kardex.api.model.entity.Tienda;

public interface TiendaService {

	public void save(Tienda tienda);

	public Tienda findOne(Long id);
	
	public List<Tienda> findAll();
}
