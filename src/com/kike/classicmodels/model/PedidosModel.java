package com.kike.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kike.classicmodels.dtos.CantidadPedidaProducto;
import com.kike.classicmodels.dtos.PedidoDTO;
import com.kike.classicmodels.utils.DBUtils;

public class PedidosModel {
	public Integer crearPedido(String orderDate, String requiredDate, String status, String comments,
			int customerNumber, List<CantidadPedidaProducto> listaProducto)
			throws ClassNotFoundException, SQLException {
		String insertOrder = "Insert into orders (orderDate, requiredDate, status,comments,customerNumber)"
				+ "Values(?,?,?,?,?)";

		String insertOrderDetail = "Insert into orderDetails (orderNumber,productCode,quantityOrdered,orderLineNumber)"
				+ "Values(?,?,?,?)";

		String actualizacionInventario = "Update products set quantityInStock = quantityInStock - ? "
				+ "Where productCode = ? ";

		Connection connection = DBUtils.conexionBBDD();
		connection.setAutoCommit(false);

		PreparedStatement psInsertOrder = connection.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS);
		PreparedStatement psInsertOrderDetails = connection.prepareStatement(insertOrderDetail);
		PreparedStatement psActualizacionInventario = connection.prepareStatement(actualizacionInventario);

		psInsertOrder.setString(1, orderDate);
		psInsertOrder.setString(2, requiredDate);
		psInsertOrder.setString(3, status);
		psInsertOrder.setString(4, comments);
		psInsertOrder.setInt(5, customerNumber);
		psInsertOrder.executeUpdate();

		ResultSet rs = psInsertOrder.getGeneratedKeys();
		int orderNumber = 10;
		if (rs.next()) {
			orderNumber = rs.getInt(1);

		}

		int orderLine = 1;
		for (CantidadPedidaProducto producto : listaProducto) {
			// insercion
			psInsertOrderDetails.setInt(1, orderNumber);
			psInsertOrderDetails.setString(2, producto.getProductCode());
			psInsertOrderDetails.setInt(3, producto.getQuantityOrdered());
			psInsertOrderDetails.setInt(4, orderLine);
			orderLine++;
			// actulizacionInventario
			psActualizacionInventario.setInt(1, producto.getQuantityOrdered());
			psActualizacionInventario.setString(2, producto.getProductCode());
			psInsertOrderDetails.executeUpdate();
			psActualizacionInventario.toString();
			System.out.println("Ejectuado " + orderLine + " vez");
			System.out.println("order " + orderNumber);

			psActualizacionInventario.executeUpdate();

		}

		connection.commit();
		connection.close();
		return orderNumber;

	}

	public List<PedidoDTO> buscarPedidos(Integer orderNumber) throws ClassNotFoundException, SQLException {
		List<PedidoDTO> listaPedidos = new ArrayList<>();
		String query ="SELECT od.OrderNumber,od.OrderDate,requiredDate,shippedDate,productCode,quantityOrdered FROM orders od "
				+"Inner join orderdetails odt on od.orderNumber = odt.orderNumber"
				+" where od.orderNumber =?"; 


		Connection conexionBD = DBUtils.conexionBBDD();
		
		PreparedStatement ps  = conexionBD.prepareStatement(query);
		ps.setInt(1, orderNumber);
//		System.out.println(ps);

		ResultSet pedidos = ps.executeQuery();	
		while (pedidos.next()) {
			PedidoDTO nuevoPedido = new PedidoDTO(pedidos.getInt(1), pedidos.getString(2), pedidos.getString(3), pedidos.getString(4), pedidos.getString(5), pedidos.getInt(1));
			listaPedidos.add(nuevoPedido);
		}
		conexionBD.close();
//		for (PedidoDTO pedidoDTO : listaPedidos) {
//			System.out.println(pedidoDTO);
//		}

		



		return listaPedidos;
	}

}
