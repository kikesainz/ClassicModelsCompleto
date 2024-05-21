package com.kike.classicmodels.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kike.classicmodels.dtos.LineasProductoDTO;
import com.kike.classicmodels.model.LineasProductoModel;

public class LineasProductoControlador {
	public List<LineasProductoDTO> buscarLineaProducto(String productLine, String 	textDescription ) throws ClassNotFoundException, SQLException {
		List<LineasProductoDTO> lista = new ArrayList<>();
		lista = new LineasProductoModel().buscarLineaProducto(productLine, textDescription);
		return lista;
		
	}
	public Integer insertarProducto(String productLine,String textDescription, String htmlDescription) throws ClassNotFoundException, SQLException {
		return new LineasProductoModel().insertarProducto(productLine, textDescription, htmlDescription);
	}
	public Integer actualizarLineaProducto(String productLine,String textDescription, String htmlDescription) throws ClassNotFoundException, SQLException {
		return new LineasProductoModel().actualizarProductos(productLine, textDescription, htmlDescription);
	}

}
