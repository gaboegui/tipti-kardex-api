package com.tipti.kardex.api.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.tipti.kardex.api.model.entity.StockEnTienda;
import com.tipti.kardex.api.model.entity.StockEnTiendaPK;

public interface StockEnTiendaService {
	
	public List<StockEnTienda> findAll();
	
	public Page<StockEnTienda> findAll(Pageable pageable);
	
	public StockEnTienda findOne(StockEnTiendaPK id);
	
	public void save(StockEnTienda stock);
	
	public void delete(StockEnTienda stock);
}
