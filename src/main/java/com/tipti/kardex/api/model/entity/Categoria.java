package com.tipti.kardex.api.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Entidad de persistencia para las Categorias
 * 
 * @author Gabriel E. 
 *
 */
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nombre;
	
	private String icono;
	
	private String descripcion;
	
	private static final long serialVersionUID = -6944805984741589338L;

	
	public Categoria(@NotBlank String nombre, String icono, String descripcion) {
		this.nombre = nombre;
		this.icono = icono;
		this.descripcion = descripcion;
	}

	public Categoria() {
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

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
