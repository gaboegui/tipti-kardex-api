package com.tipti.kardex.api.model.entity;

import java.io.Serializable;

/**
 * Clase para clave compuesta de StockEnTienda
 * 
 * 
 * @author Gabriel Eguiguren
 *
 */
public class StockEnTiendaPK implements Serializable {
	
	private String SKU;
	private Long producto;
	private Long tienda;
	
	private static final long serialVersionUID = 4827507226010420278L;
	

	public StockEnTiendaPK(String sKU, Long producto, Long tienda) {
		SKU = sKU;
		this.producto = producto;
		this.tienda = tienda;
	}
	
	public StockEnTiendaPK() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SKU == null) ? 0 : SKU.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + ((tienda == null) ? 0 : tienda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockEnTiendaPK other = (StockEnTiendaPK) obj;
		if (SKU == null) {
			if (other.SKU != null)
				return false;
		} else if (!SKU.equals(other.SKU))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (tienda == null) {
			if (other.tienda != null)
				return false;
		} else if (!tienda.equals(other.tienda))
			return false;
		return true;
	}

	public String getSKU() {
		return SKU;
	}
	public void setSKU(String sKU) {
		SKU = sKU;
	}
	public Long getProducto() {
		return producto;
	}
	public void setProducto(Long producto) {
		this.producto = producto;
	}
	public Long getTienda() {
		return tienda;
	}
	public void setTienda(Long tienda) {
		this.tienda = tienda;
	}
	
	
	
	
	
	
	

}
