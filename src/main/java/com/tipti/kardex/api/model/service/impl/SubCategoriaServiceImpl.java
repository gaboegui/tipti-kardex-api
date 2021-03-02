package com.tipti.kardex.api.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tipti.kardex.api.model.entity.SubCategoria;
import com.tipti.kardex.api.model.repository.SubCategoriaRepository;
import com.tipti.kardex.api.model.service.SubCategoriaService;

@Service
public class SubCategoriaServiceImpl implements SubCategoriaService {

	@Autowired
	private SubCategoriaRepository subcategoriaDao;

	@Override
	@Transactional
	public void save(SubCategoria subcategoria) {
		subcategoriaDao.save(subcategoria);

	}

}
