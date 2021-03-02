package com.tipti.kardex.api.model.service;

import java.util.List;

import com.tipti.kardex.api.model.entity.Ciudad;

public interface CiudadService {

	
	public void save(Ciudad ciudad);
	
	public List<Ciudad> findAll();
}
