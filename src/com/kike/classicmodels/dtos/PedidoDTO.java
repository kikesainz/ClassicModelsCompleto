package com.kike.classicmodels.dtos;

public class PedidoDTO {
	private Integer orderNumber;
	private String orderDate;
	private String requiredDate;
	private String shippedDate;
	private String productCode;
	private Integer quantityOrdered;

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}

	public String getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(String shippedDate) {
		this.shippedDate = shippedDate;
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

	public PedidoDTO(Integer orderNumber, String orderDate, String requiredDate, String shippedDate, String productCode,
			Integer quantityOrdered) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
	}

	@Override
	public String toString() {
		return "PedidoDTO [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", productCode=" + productCode + ", quantityOrdered="
				+ quantityOrdered + "]";
	}
	

}
