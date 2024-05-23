package com.kike.classicmodels.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kike.classicmodels.dtos.ProductoDTO;
import com.kike.classicmodels.model.ProductosModel;

public class ProductosControlador {

	public int crearProducto(String productCode, String productName, String productLine, String productScale,
			String productVendor, String productDescription, Integer quantityInStock, float buyPrice, float MSRP)
			throws ClassNotFoundException, SQLException {
		ProductosModel pm = new ProductosModel();
		return pm.crearProducto(productCode, productName, productLine, productScale, productVendor, productDescription,
				quantityInStock, buyPrice, MSRP);
	}

	public List<ProductoDTO> buscarProductoConFiltros(String productCode, String productName, String productLine,
			String productDescription, String productScale, String productVendor, Integer quantityInStock, Float buyPrice, Float MSRP)  throws ClassNotFoundException, SQLException {
		List<ProductoDTO> listaProductos = new ArrayList<>();
		ProductosModel pm = new ProductosModel();
		listaProductos = pm.buscarProductoConFiltros(productCode, productName,  productLine,
				 productDescription,  productScale,  productVendor,  quantityInStock,  buyPrice,  MSRP) ;
		return listaProductos;
	}
	
	public int actualizarProducto(String productCode, String productName, String productLine, String productScale,
			String productVendor, String productDescription, Integer quantityInStock, float buyPrice, float MSRP)
			throws ClassNotFoundException, SQLException {
		ProductosModel pm = new ProductosModel();
		return pm.actualizarProducto(productCode, productName, productLine, productScale, productVendor, productDescription,
				quantityInStock, buyPrice, MSRP);
	}

}
