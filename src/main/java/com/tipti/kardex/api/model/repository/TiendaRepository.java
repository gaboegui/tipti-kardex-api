package com.tipti.kardex.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tipti.kardex.api.model.entity.Tienda;

/**
 * Repositorio para manejar entidad Tienda y lo habilito como servicio REST automatico
 * 
 * @author Gabriel Eguiguren
 *
 */
@RepositoryRestResource(path = "tiendas")
public interface TiendaRepository extends JpaRepository<Tienda, Long> {

}
