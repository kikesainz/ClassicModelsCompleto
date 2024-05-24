package com.kike.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kike.classicmodels.dtos.ProductoDTO;
import com.kike.classicmodels.utils.DBUtils;

public class ProductosModel {

	public int crearProducto(String productCode, String productName, String productLine, String productScale,
			String productVendor, String productDescription, Float quantityInStock, float buyPrice, float MSRP)
			throws ClassNotFoundException, SQLException {
		String sql = "Insert into products (productCode,productName,productLine,productScale,productVendor,productDescription,quantityInStock,buyPrice,MSRP)"
				+ "values" + "(?,?,?,?,?,?,?,?,?)";
		Integer resultado = null;
		Connection conexxion = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		ps = conexxion.prepareStatement(sql);
		ps.setString(1, productCode);
		ps.setString(2, productName);
		ps.setString(3, productLine);
		ps.setString(4, productScale);
		ps.setString(5, productVendor);
		ps.setString(6, productDescription);
		ps.setFloat(7, quantityInStock);
		ps.setFloat(8, buyPrice);
		ps.setFloat(9, MSRP);
		resultado = ps.executeUpdate();
		ps.close();
		return resultado;
	}

	public int actualizarProducto(String productCode, String productName, String productLine, String productScale,
			String productVendor, String productDescription, Float quantityInStock, float buyPrice, float MSRP)
			throws ClassNotFoundException, SQLException {
		Integer resultado = null;
		String sql = "UPDATE  products set productName = Case when ? = '' then productName else ? end,"
				+ "productLine = case when ? = '' then productLine else ? end ,"
				+ "productScale = case when ? = '' then productScale else ? end ,"
				+ "productVendor = case when ? = '' then productVendor else ? end,"
				+ "productDescription = case when ? = '' then productDescription else ? end, "
				+ "quantityInStock = case when ? = '' then quantityInStock else ? end, "
				+ "buyPrice = case when ? = '' then buyPrice else ? end, "
				+ "MSRP = case when ? = '' then MSRP else ? end " + "Where productCode = ?";

		Connection conexxion = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		ps = conexxion.prepareStatement(sql);
		ps.setString(1, productName);
		ps.setString(2, productName);

		ps.setString(3, productLine);
		ps.setString(4, productLine);

		ps.setString(5, productScale);
		ps.setString(6, productScale);

		ps.setString(7, productVendor);
		ps.setString(8, productVendor);

		ps.setString(9, productDescription);
		ps.setString(10, productDescription);

		ps.setFloat(11, quantityInStock);
		ps.setFloat(12, quantityInStock);

		ps.setFloat(13, buyPrice);
		ps.setFloat(14, buyPrice);

		ps.setFloat(15, MSRP);
		ps.setFloat(16, MSRP);

		ps.setString(17, productCode);
		System.out.println(ps);

		resultado = ps.executeUpdate();

		conexxion.close();

		return resultado;
	}

	public List<ProductoDTO> buscarProductoConFiltros(String productCode, String productName, String productLine,
			String productDescription, String productScale, String productVendor, Float quantityInStock, Float buyPrice, Float MSRP) throws ClassNotFoundException, SQLException {
		String sql = "Select * from products" 
				+ " where productCode like ?"
				+ " and productName like ?"
				+ " and productLine like ?" 
				+ " and productDescription like ?"
				+ " and productScale like ? "
				+ " and productVendor like ? "
				+ " and quantityInStock >= ? "
				+ " and buyPrice >= ? "
				+ " and MSRP >= ? ";
		List<ProductoDTO> listaProductos = new ArrayList<>();
		Connection conexxion = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		ps = conexxion.prepareStatement(sql);
		ps.setString(1, "%" + productCode + "%");
		ps.setString(2, "%" + productName + "%");
		ps.setString(3, "%" + productLine + "%");
		ps.setString(4, "%" + productDescription + "%");
		ps.setString(5, "%" + productScale + "%");
		ps.setString(6, "%" + productVendor + "%");
		ps.setFloat(7, quantityInStock );
		ps.setFloat(8, buyPrice );
		ps.setFloat(9, MSRP );
		System.out.println(ps);

		ResultSet listaResultado = ps.executeQuery();

		while (listaResultado.next()) {
			ProductoDTO nuevoResultado = new ProductoDTO(listaResultado.getString("productCode"),
					listaResultado.getString("productName"), listaResultado.getString("productLine"),
					listaResultado.getString("productDescription"), listaResultado.getString("productScale"), listaResultado.getString("productVendor"),
					listaResultado.getFloat("quantityInStock"), listaResultado.getFloat("buyPrice"), 
					listaResultado.getFloat("mSRP"));

			listaProductos.add(nuevoResultado);
		}
		conexxion.close();

		return listaProductos;
	}

}
