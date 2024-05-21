package com.kike.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kike.classicmodels.dtos.LineasProductoDTO;
import com.kike.classicmodels.utils.DBUtils;

public class LineasProductoModel {
	public List<LineasProductoDTO> buscarLineaProducto(String productLine, String textDescription)
			throws ClassNotFoundException, SQLException {
		List<LineasProductoDTO> listaLineasProductos = new ArrayList<>();
		String sql = "Select productLine, textDescription from productLines" + " where productLine like ?"
				+ " and textDescription like  ? ";
		Connection conexxion = DBUtils.conexionBBDD();
		PreparedStatement ps = conexxion.prepareStatement(sql);
		ps.setString(1, "%" + productLine + "%");
		ps.setString(2, "%" + textDescription + "%");
		System.out.println(ps);
		ResultSet resultado = ps.executeQuery();
		while (resultado.next()) {
			LineasProductoDTO linea = new LineasProductoDTO(resultado.getString(1), resultado.getString(2));
			listaLineasProductos.add(linea);

		}
//		for (LineasProductoDTO lineasProductoDTO : listaLineasProductos) {
//			System.out.println(lineasProductoDTO);
//		}
		return listaLineasProductos;

	}

	public Integer insertarProducto(String productLine, String textDescription, String htmlDescription)
			throws ClassNotFoundException, SQLException {
		String sql = "insert into productlines (productLine, textDescription, htmlDescription) " + "values "
				+ "(?,?,?);";
		Connection conexxion = DBUtils.conexionBBDD();
		PreparedStatement ps = conexxion.prepareStatement(sql);
		ps.setString(1, productLine);
		ps.setString(2, textDescription);
		ps.setString(3, htmlDescription);
		Integer resultado = ps.executeUpdate();
		return resultado;

	}

	public Integer actualizarProductos(String productLine, String textDescription, String htmlDescription)
			throws ClassNotFoundException, SQLException {

		String sql = "UPDATE  productlines set textDescription = case when ? = '' then textDescription else ? end ,"
				+ "htmlDescription = case when ? = '' then htmlDescription else ? end " + "Where productLine = ?";

		Connection conexxion = DBUtils.conexionBBDD();
		PreparedStatement ps = conexxion.prepareStatement(sql);
		ps.setString(1, textDescription);
		ps.setString(2, textDescription);

		ps.setString(3, htmlDescription);
		ps.setString(4, htmlDescription);
		
		ps.setString(5, productLine);

		
		System.out.println(ps);
		Integer resultado = ps.executeUpdate();
		return resultado;

	}

}
