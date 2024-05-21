package com.kike.classicmodels.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kike.classicmodels.dtos.CantidadPedidaProducto;
import com.kike.classicmodels.dtos.PedidoDTO;
import com.kike.classicmodels.model.PedidosModel;

public class PedidoControlador {
	public Integer crearPedido(String orderDate, String requiredDate, String status, String comments,
			int customerNumber, List<CantidadPedidaProducto> listaProducto) throws ClassNotFoundException, SQLException {
		PedidosModel pm = new PedidosModel();
		
		return pm.crearPedido(orderDate, requiredDate, status, comments, customerNumber, listaProducto);

	}

	public List<PedidoDTO> buscarPedidoFiltro(Integer orderNumber) throws ClassNotFoundException, SQLException {
		List<PedidoDTO> listaPedidos = new ArrayList<>();
		PedidosModel pm = new PedidosModel();
		listaPedidos = pm.buscarPedidos(orderNumber);
		return listaPedidos;
	}

}
