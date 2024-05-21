package com.kike.classicmodels.dtos;

public class CantidadPedidaProducto {
	private String productCode;
	private Integer quantityOrdered;
	
	public CantidadPedidaProducto(String productCode, Integer quantityOrdered) {
		super();
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	

}
