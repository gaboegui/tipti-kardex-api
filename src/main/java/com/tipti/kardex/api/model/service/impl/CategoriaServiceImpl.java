package com.tipti.kardex.api.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tipti.kardex.api.model.entity.Categoria;
import com.tipti.kardex.api.model.repository.CategoriaRepository;
import com.tipti.kardex.api.model.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaDao;

	@Override
	@Transactional
	public void save(Categoria categoria) {
		categoriaDao.save(categoria);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Categoria findOne(Long id) {
		return categoriaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAll() {

		return categoriaDao.findAll();
	}

}
