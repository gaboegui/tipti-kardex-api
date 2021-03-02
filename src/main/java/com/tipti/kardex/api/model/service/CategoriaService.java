package com.tipti.kardex.api.model.service;

import java.util.List;

import com.tipti.kardex.api.model.entity.Categoria;

public interface CategoriaService {

	
	public void save(Categoria categoria);

	public Categoria findOne(Long id);
	
	public List<Categoria> findAll();
}
