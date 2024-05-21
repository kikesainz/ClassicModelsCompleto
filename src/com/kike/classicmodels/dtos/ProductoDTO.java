package com.kike.classicmodels.dtos;

public class ProductoDTO {
	private String productCode;
	private String productName;
	private String productLine;
	private String productDescription;
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public ProductoDTO(String productCode, String productName, String productLine, String productDescription) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productDescription = productDescription;
	}
	@Override
	public String toString() {
		return "Producto[productCode=" + productCode + ", productName=" + productName + ", productLine="
				+ productLine + ", productDescription=" + productDescription + "]";
	}
	

}
