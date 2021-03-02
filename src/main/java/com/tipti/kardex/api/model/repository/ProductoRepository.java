package com.tipti.kardex.api.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tipti.kardex.api.model.entity.Producto;


/**
 * Interfaz par habilitar las operaciones CRUD de Producto 
 * 
 * adicionalmente la anotacion @RepositoryRestResource nos permite 
 * crear el controller para la API REST 
 * 
 * @author Gabriel Eguiguren
 *
 */
@RepositoryRestResource(path = "productos")
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	List<Producto> findByNombre(String term);

}
