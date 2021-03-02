package com.tipti.kardex.api.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tipti.kardex.api.model.entity.StockEnTienda;
import com.tipti.kardex.api.model.entity.StockEnTiendaPK;


/**
 * Repository para StockEnTienda 
 * 
 * debido al numero de registros (150.000) es necesario utilizar paginación para el despliegue de resultados
 * 
 * @author Gabriel Eguiguren
 *
 */
public interface StockEnTiendaRepository extends PagingAndSortingRepository<StockEnTienda,StockEnTiendaPK> {
	
	

}
