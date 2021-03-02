package com.tipti.kardex.api.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tipti.kardex.api.model.entity.Tienda;
import com.tipti.kardex.api.model.repository.TiendaRepository;
import com.tipti.kardex.api.model.service.TiendaService;

@Service
public class TiendaServiceImpl implements TiendaService {

	@Autowired
	private TiendaRepository tiendaDao;

	@Override
	@Transactional
	public void save(Tienda tienda) {
		tiendaDao.save(tienda);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Tienda findOne(Long id) {
		return tiendaDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Tienda> findAll(){
		return tiendaDao.findAll();
	}

}
