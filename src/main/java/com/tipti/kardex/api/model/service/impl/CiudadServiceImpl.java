package com.tipti.kardex.api.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tipti.kardex.api.model.entity.Ciudad;
import com.tipti.kardex.api.model.repository.CiudadRepository;
import com.tipti.kardex.api.model.service.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService {

	@Autowired
	private CiudadRepository ciudadDao;

	@Override
	@Transactional
	public void save(Ciudad ciudad) {
		ciudadDao.save(ciudad);
	}
	
	@Override
	@Transactional
	public List<Ciudad> findAll(){
		return ciudadDao.findAll();
		
	}

}
