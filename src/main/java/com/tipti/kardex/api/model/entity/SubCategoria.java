package com.tipti.kardex.api.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Entidad de persistencia para las SubCategorias
 * 
 * @author Gabriel E. 
 *
 */
@Entity
@Table(name = "subcategoria")
public class SubCategoria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name="id_categoria")
	@ManyToOne(fetch=FetchType.LAZY)
	private Categoria categoria;
	
	@NotBlank
	private String nombre;
	
	private String icono;
	
	private String descripcion;
	
	private static final long serialVersionUID = -8441418715348394628L;	

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
