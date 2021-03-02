package com.tipti.kardex.api.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Entidad de persistencia para las Tiendas
 * 
 * @author Gabriel E. 
 *
 */
@Entity
@Table(name = "tienda")
public class Tienda implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name="id_ciudad")
	@ManyToOne
	private Ciudad ciudad;
	
	@NotBlank
	private String nombre;
	
	private String logo;
	
	private static final long serialVersionUID = -1233638151818030332L;

	public Tienda() {
	}

	public Tienda(Ciudad ciudad, @NotBlank String nombre) {
		super();
		this.ciudad = ciudad;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	

}
