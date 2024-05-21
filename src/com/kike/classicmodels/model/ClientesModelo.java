package com.kike.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kike.classicmodels.dtos.Clientes;
import com.kike.classicmodels.utils.DBUtils;

public class ClientesModelo {
	public List<Clientes> recuperaNombreTelefonoTodosLosClientes() throws ClassNotFoundException, SQLException {
		Connection conexionBD = DBUtils.conexionBBDD();
		ResultSet clientes;
		Statement statement = conexionBD.createStatement();
		clientes = statement.executeQuery("Select * from customers");
		List<Clientes> listaClientes = new ArrayList<>();

		while (clientes.next()) {
			Clientes nuevoCliente = new Clientes(clientes.getString("customerName"), clientes.getString("phone"));
			listaClientes.add(nuevoCliente);
		}
		conexionBD.close();
		return listaClientes;
	}

	public List<Clientes> recuperaNombreTelefonoFiltraPorNombreTfnoPais(String nombreCliente, String phone, String pais)
			throws ClassNotFoundException, SQLException {
		Connection conexxionBBDD = DBUtils.conexionBBDD();
		String querry = "Select * from customers where customerName like ? or phone like ? or country like ?";

		List<Clientes> listaClientes = new ArrayList<>();
		PreparedStatement ps = conexxionBBDD.prepareStatement(querry);
		ps.setString(1, "%" + nombreCliente + "%");
		ps.setString(2, "%" + phone + "%");
		ps.setString(3, "%" + pais + "%");
		System.out.println(ps);
		ResultSet consultaClientes = ps.executeQuery();
		while (consultaClientes.next()) {
			Clientes c = new Clientes(consultaClientes.getString("customerName"), consultaClientes.getString("phone"));
			listaClientes.add(c);
		}

		return listaClientes;

	}

	public List<Clientes> recuperaNombreTelefonoFiltrarPorNombre(String nombreEmpleado)
			throws ClassNotFoundException, SQLException {
		String querry = "Select * from customers where customerName like ? ";

		Connection conexxionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexxionBD.prepareStatement(querry);
		ps.setString(1, "%" + nombreEmpleado + "%");

		ResultSet clientes = ps.executeQuery();
		List<Clientes> listaClientes = new ArrayList<>();
		while (clientes.next()) {
			Clientes c = new Clientes(clientes.getString("customerName"), clientes.getString("phone"));
			listaClientes.add(c);

		}

		return listaClientes;
	}

	public Integer insertarClientes(int numeroCliente, String nombreCliente, String apellidoContacto,
			String nombreContacto, String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigPostal, String pais, Integer representante, Double credito)
			throws ClassNotFoundException, SQLException {
		String sql = "Insert into customers (customerNumber,CustomerName,contactLastName, contactFirstName,phone,addressLine1,"
				+ "addressLine2,city,state,postalCode,country,salesRepEmployeeNumber,creditLimit )"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Integer resultado = null;
		Connection conexxion = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		ps = conexxion.prepareStatement(sql);
		ps.setInt(1, numeroCliente);
		ps.setString(2, nombreCliente);
		ps.setString(3, apellidoContacto);
		ps.setString(4, nombreContacto);
		ps.setString(5, telefono);
		ps.setString(6, direccion1);
		ps.setString(7, direccion2);
		ps.setString(8, ciudad);
		ps.setString(9, estado);
		ps.setString(10, codigPostal);
		ps.setString(11, pais);
		ps.setInt(12, representante);
		ps.setDouble(13, credito);
		resultado = ps.executeUpdate();
		conexxion.close();

		return resultado;

	}

	public Integer actualizarClientes(int numeroCliente, String nombreCliente, String apellidoContacto,
			String nombreContacto, String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigPostal, String pais, Integer representante, Double credito)
			throws ClassNotFoundException, SQLException {
		String sql = "UPDATE  customers set customername = Case when ? = '' then customerName else ? end,"
				+ "contactLastname = case when ? = '' then contactlastname else ? end ,"
				+ "contactFirstName = case when ? = '' then contactFirstName else ? end ,"
				+ "phone = case when ? = '' then phone else ? end,"
				+ "addressLine1 = case when ? = '' then addressLine1 else ? end, "
				+ "addressLine2 = case when ? = '' then addressLine2 else ? end, "
				+ "city = case when ? = '' then city else ? end, " + "state = case when ? = '' then state else ? end, "
				+ "country = case when ? = '' then country else ? end, "
				+ "postalCode = case when ? = '' then postalCode else ? end, "
				+ "salesRepEmployeeNumber = case when ? = '' then salesRepEmployeeNumber else ? end, "
				+ "creditLimit = case when ? = '' then creditLimit else ? end " + "Where customerNumber = ?";
		Integer resultado = null;

		try (Connection connection = DBUtils.conexionBBDD()) {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps = connection.prepareStatement(sql);
			ps.setString(1, nombreCliente);
			ps.setString(2, nombreCliente);

			ps.setString(3, apellidoContacto);
			ps.setString(4, apellidoContacto);

			ps.setString(5, nombreContacto);
			ps.setString(6, nombreContacto);

			ps.setString(7, direccion1);
			ps.setString(8, direccion1);

			ps.setString(9, direccion1);
			ps.setString(10, direccion1);

			ps.setString(11, direccion1);
			ps.setString(12, direccion2);

			ps.setString(13, ciudad);
			ps.setString(14, ciudad);

			ps.setString(15, estado);
			ps.setString(16, estado);

			ps.setString(17, codigPostal);
			ps.setString(18, codigPostal);

			ps.setString(19, pais);
			ps.setString(20, pais);

			ps.setInt(21, representante);
			ps.setInt(22, representante);

			ps.setDouble(23, credito);
			ps.setDouble(24, credito);

			ps.setInt(25, numeroCliente);

			resultado = ps.executeUpdate();

		}
		return resultado;

	}

	public Integer borrarCliente(Integer customerNumber) throws ClassNotFoundException, SQLException {

		String sql = "Delete from customers where customerNumber = ?";

		Connection connection = DBUtils.conexionBBDD();

		PreparedStatement ps = null;

		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, customerNumber);
		resultado = ps.executeUpdate();
		connection.close();

		return resultado;
	}

}
