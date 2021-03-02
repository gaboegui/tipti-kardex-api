package com.tipti.kardex.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tipti.kardex.api.model.entity.Ciudad;


/**
 * Repositorio para manejar entidad Ciudad y lo habilito como servicio REST automatico
 * 
 * @author Gabriel Eguiguren
 *
 */
@RepositoryRestResource(path = "ciudades")
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

}
