package com.tipti.kardex.api.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tipti.kardex.api.model.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public Optional<Categoria> findById(Long id);

}
