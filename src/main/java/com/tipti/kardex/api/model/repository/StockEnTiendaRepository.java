package com.tipti.kardex.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tipti.kardex.api.model.entity.StockEnTienda;
import com.tipti.kardex.api.model.entity.StockEnTiendaPK;


/**
 * Repository para StockEnTienda 
 * 
 * @author Gabriel Eguiguren
 *
 */
public interface StockEnTiendaRepository extends JpaRepository<StockEnTienda,StockEnTiendaPK> {
	
	

}
