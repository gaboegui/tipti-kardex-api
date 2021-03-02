package com.tipti.kardex.api.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Entidad de persistencia para las Ciudades
 * 
 * @author Gabriel E. 
 *
 */
@Entity
@Table(name = "ciudad")
public class Ciudad implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nombre;
	
	private static final long serialVersionUID = -3358762415463722906L;

	public Ciudad(@NotBlank String nombre) {
		this.nombre = nombre;
	}

	public Ciudad() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
