package com.kike.classicmodels.dtos;

public class LineasProductoDTO {
	private String productLine;
	private String textDescription;
	public LineasProductoDTO(String productLine, String textDescription) {
		super();
		this.productLine = productLine;
		this.textDescription = textDescription;
	}
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	public String getTextDescription() {
		return textDescription;
	}
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}
	@Override
	public String toString() {
		return "LineasProductoDTO [productLine=" + productLine + ", textDescription=" + textDescription + "]";
	}

}
