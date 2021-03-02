package com.tipti.kardex.api.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad de persistencia para el StockEnTienda
 * 
 * @author Gabriel E. 
 *
 */
@Entity
@Table(name = "stock_en_tienda")
@IdClass(StockEnTiendaPK.class)
public class StockEnTienda implements Serializable {
	
	@Id
	private String SKU;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_tienda")
	private Tienda tienda;
	
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	private BigDecimal pvp;
	
	private BigDecimal margenGanancia;
	
	private BigDecimal precioCompra;
	
	private Boolean tieneIva;
	
	private Boolean estado;
	
	private static final long serialVersionUID = -3058752255870159893L;
	
	
	public StockEnTienda(String sKU, Producto producto, Tienda tienda, Categoria categoria) {
		SKU = sKU;
		this.producto = producto;
		this.tienda = tienda;
		this.categoria = categoria;
	}

	public StockEnTienda(String sKU, Producto producto, Tienda tienda, Categoria categoria, BigDecimal pvp,
			BigDecimal margen_ganancia, BigDecimal precio_compra, Boolean tieneIva, Boolean estado) {

		SKU = sKU;
		this.producto = producto;
		this.tienda = tienda;
		this.categoria = categoria;
		this.pvp = pvp;
		this.margenGanancia = margen_ganancia;
		this.precioCompra = precio_compra;
		this.tieneIva = tieneIva;
		this.estado = estado;
	}

	public StockEnTienda() {
	}

	public String getSKU() {
		return SKU;
	}


	public void setSKU(String sKU) {
		SKU = sKU;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Tienda getTienda() {
		return tienda;
	}


	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPvp() {
		return pvp;
	}

	public void setPvp(BigDecimal pvp) {
		this.pvp = pvp;
	}

	public Boolean getTieneIva() {
		return tieneIva;
	}

	public void setTieneIva(Boolean tieneIva) {
		this.tieneIva = tieneIva;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public BigDecimal getMargenGanancia() {
		return margenGanancia;
	}

	public void setMargenGanancia(BigDecimal margenGanancia) {
		this.margenGanancia = margenGanancia;
	}

	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}
	
	

}
