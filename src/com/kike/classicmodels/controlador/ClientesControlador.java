package com.kike.classicmodels.controlador;

import java.sql.SQLException;
import java.util.List;

import com.kike.classicmodels.dtos.Clientes;
import com.kike.classicmodels.model.ClientesModelo;

public class ClientesControlador {

	public List<Clientes> recuperaNombreTelefono(String nombreEmpleado) throws ClassNotFoundException, SQLException {
		ClientesModelo cm = new ClientesModelo();
		return cm.recuperaNombreTelefonoFiltrarPorNombre(nombreEmpleado);
	}

	public List<Clientes> recuperaNombreTelefonoSinFiltro() throws ClassNotFoundException, SQLException {
		ClientesModelo cm = new ClientesModelo();
		return cm.recuperaNombreTelefonoTodosLosClientes();
	}

	public List<Clientes> recuperaNombreTelefonoFiltraPorNombreTfnoPais(String nombre, String tfno, String pais)
			throws ClassNotFoundException, SQLException {
		ClientesModelo cm = new ClientesModelo();
		return cm.recuperaNombreTelefonoFiltraPorNombreTfnoPais(nombre, tfno, pais);
	}

	public int insertarClientes(int numeroCliente, String nombreCliente, String apellidoContacto, String nombreContacto,
			String telefono, String direccion1, String direccion2, String ciudad, String estado, String codigPostal,
			String pais, int representante, Double credito) throws ClassNotFoundException, SQLException {
		ClientesModelo cm = new ClientesModelo();

		return cm.insertarClientes(numeroCliente, nombreCliente, apellidoContacto, nombreContacto, telefono, direccion1,
				direccion2, ciudad, estado, codigPostal, pais, representante, credito);
	}

	public int actualizarCliente(int numeroCliente, String nombreCliente, String apellidoContacto,
			String nombreContacto, String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigPostal, String pais, int representante, Double credito)
			throws ClassNotFoundException, SQLException {
		ClientesModelo cm = new ClientesModelo();

		return cm.actualizarClientes(numeroCliente, nombreCliente, apellidoContacto, nombreContacto, telefono,
				direccion1, direccion2, ciudad, estado, codigPostal, pais, representante, credito);
	}

	public int borrarCliente(Integer customerNumber) throws ClassNotFoundException, SQLException {

		ClientesModelo cm = new ClientesModelo();
		return cm.borrarCliente(customerNumber);
	}

}
