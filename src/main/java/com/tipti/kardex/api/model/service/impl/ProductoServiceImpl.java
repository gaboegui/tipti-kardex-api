package com.tipti.kardex.api.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tipti.kardex.api.model.entity.Producto;
import com.tipti.kardex.api.model.repository.ProductoRepository;
import com.tipti.kardex.api.model.service.ProductoService;

/**
 * implementación del Servicio con metodos de manipulación de Productos
 * 
 * @author Gabriel Eguiguren
 *
 */
@Service
public class ProductoServiceImpl implements ProductoService {

	
	@Autowired
	private ProductoRepository productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {
		return productoDao.findByNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findOne(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		productoDao.save(producto);
		return producto;

	}

	@Override
	@Transactional
	public void delete(Long id) {
		productoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {
		return productoDao.findAll(pageable);
	}

}
