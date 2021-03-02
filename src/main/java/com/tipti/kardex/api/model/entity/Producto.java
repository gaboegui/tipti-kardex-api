package com.tipti.kardex.api.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Entidad de persistencia para los Productos
 * 
 * @author Gabriel E. 
 *
 */
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nombre;
	
	private String presentacion;
	
	private String marca;
	
	private String fabricante;
	
	private String foto;
	
	@NotNull
	private BigDecimal ventaAlGranel;
	
	private String descripcion;
	
	private Float  nivelAzucar;
	
	private Float  nivelSal;
	
	private Float  nivelGrasa;
	
	private Boolean estado;
	
	private static final long serialVersionUID = -8032316874975730012L;

	
	
	public Producto( @NotBlank String nombre, String presentacion, String marca, String fabricante, String foto,
			@NotNull BigDecimal ventaAlGranel, String descripcion, Float nivelAzucar, Float nivelSal, Float nivelGrasa,
			Boolean estado) {

		this.nombre = nombre;
		this.presentacion = presentacion;
		this.marca = marca;
		this.fabricante = fabricante;
		this.foto = foto;
		this.ventaAlGranel = ventaAlGranel;
		this.descripcion = descripcion;
		this.nivelAzucar = nivelAzucar;
		this.nivelSal = nivelSal;
		this.nivelGrasa = nivelGrasa;
		this.estado = estado;
	}
	
	public Producto(@NotBlank String nombre, @NotNull BigDecimal ventaAlGranel) {
		super();
		this.nombre = nombre;
		this.ventaAlGranel = ventaAlGranel;
	}



	public Producto() {
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

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public BigDecimal getVentaAlGranel() {
		return ventaAlGranel;
	}

	public void setVentaAlGranel(BigDecimal ventaAlGranel) {
		this.ventaAlGranel = ventaAlGranel;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getNivelAzucar() {
		return nivelAzucar;
	}

	public void setNivelAzucar(Float nivelAzucar) {
		this.nivelAzucar = nivelAzucar;
	}

	public Float getNivelSal() {
		return nivelSal;
	}

	public void setNivelSal(Float nivelSal) {
		this.nivelSal = nivelSal;
	}

	public Float getNivelGrasa() {
		return nivelGrasa;
	}

	public void setNivelGrasa(Float nivelGrasa) {
		this.nivelGrasa = nivelGrasa;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	


}
