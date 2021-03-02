package com.tipti.kardex.api.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tipti.kardex.api.model.entity.StockEnTienda;
import com.tipti.kardex.api.model.entity.StockEnTiendaPK;
import com.tipti.kardex.api.model.repository.StockEnTiendaRepository;
import com.tipti.kardex.api.model.service.StockEnTiendaService;

@Service
public class StockEnTiendaServiceImpl implements StockEnTiendaService {
	
	@Autowired
	StockEnTiendaRepository stockDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<StockEnTienda> findAll(){
		return stockDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<StockEnTienda> findAll(Pageable pageable) {
		return stockDao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public StockEnTienda findOne(StockEnTiendaPK id) {
		return stockDao.findById(id).orElse(null);
		
	}
	
	@Override
	@Transactional
	public void save(StockEnTienda stock) {
		stockDao.save(stock);
		
	}
	
	@Override
	@Transactional
	public void delete(StockEnTienda stock) {
		stockDao.delete(stock);
	}
}
