package com.kike.classicmodels.vista;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.kike.classicmodels.controlador.ClientesControlador;
import com.kike.classicmodels.dtos.Clientes;
import com.kike.classicmodels.scanner.MiScanner;

public class VistaClientes {
	private void menuRecuperaNombreTelefono() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el nombre del cliente :");
		String nombreEmpleado = sc.next();
		ClientesControlador controladorClientes = new ClientesControlador();
		List<Clientes> listaClientes = controladorClientes.recuperaNombreTelefono(nombreEmpleado);
		for (Clientes clientes : listaClientes) {
			System.out.println(clientes);
		}

	}

	private void menuRecuperarTodosLosClientes() throws ClassNotFoundException, SQLException {
		ClientesControlador controladorClientes = new ClientesControlador();
		List<Clientes> listaClientes = controladorClientes.recuperaNombreTelefonoSinFiltro();
		for (Clientes clientes : listaClientes) {
			System.out.println(clientes);
		}
	}

	private void menuRecuperarNombreTelefonoConFiltros() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca Nombre cliente");
		String nombre = sc.next();
		System.out.println("Introduzca Telefono");
		String tfno = sc.next();
		System.out.println("Introduzca Pais");
		String pais = sc.next();
		ClientesControlador controladorClientes = new ClientesControlador();

		List<Clientes> listaClientes = controladorClientes.recuperaNombreTelefonoFiltraPorNombreTfnoPais(nombre, tfno,
				pais);
		for (Clientes clientes : listaClientes) {
			System.out.println(clientes);
		}

	}

	private void menuInsertarCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el numero del cliente");
		int numeroCliente = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca por favor el nombre del cliente");
		String nombreCliente = sc.nextLine();
		System.out.println("Introduzca po favor el apellido del cliente");
		String apellidoCliente = sc.nextLine();
		System.out.println("Introduzca por favor el nombre de contacto");
		String nombreContacto = sc.nextLine();
		System.out.println("Introduzca por favor el telefono");
		String telefono = sc.nextLine();
		System.out.println("Introduzca por favor la direccion del cliente");
		String direccion1 = sc.nextLine();
		System.out.println("Introduzca por favor la direccion2 del cliente");
		String direccion2 = sc.nextLine();
		System.out.println("Introduzca por favor la ciudad del cliente");
		String ciudad = sc.nextLine();
		System.out.println("Introduzca por favor el estado del cliente");
		String estado = sc.nextLine();
		System.out.println("Introduzca por favor el codigo postal del cliente");
		String codigoPostal = sc.nextLine();
		System.out.println("Introduzca por favor el pais del cliente");
		String pais = sc.nextLine();
		System.out.println("Introduzca Por favor el numero del cliente");
		int representante = 1002;
		try {
			representante = Integer.parseInt(sc.nextLine());

		} catch (Exception e) {
			System.out.println("No se ha introducido numero de representante de ventas");

		}
		System.out.println("Introduzca por favor credito (n�mero con decimales)");
		Double credito = 0.0;
		try {
			credito = Double.parseDouble(sc.nextLine());

		} catch (Exception e) {
			System.out.println("No se ha introducido credito");

		}
		ClientesControlador controladorClientes = new ClientesControlador();
		int resultado = controladorClientes.insertarClientes(numeroCliente, nombreCliente, apellidoCliente,
				nombreContacto, telefono, direccion1, direccion2, ciudad, estado, codigoPostal, pais, representante,
				credito);
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con exito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}

	}

	private void menuActualizarCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el numero del cliente");
		int numeroCliente = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca por favor el nombre del cliente");
		String nombreCliente = sc.nextLine();
		System.out.println("Introduzca po favor el apellido del cliente");
		String apellidoCliente = sc.nextLine();
		System.out.println("Introduzca por favor el nombre de contacto");
		String nombreContacto = sc.nextLine();
		System.out.println("Introduzca por favor el telefono");
		String telefono = sc.nextLine();
		System.out.println("Introduzca por favor la direccion del cliente");
		String direccion1 = sc.nextLine();
		System.out.println("Introduzca por favor la direccion2 del cliente");
		String direccion2 = sc.nextLine();
		System.out.println("Introduzca por favor la ciudad del cliente");
		String ciudad = sc.nextLine();
		System.out.println("Introduzca por favor el estado del cliente");
		String estado = sc.nextLine();
		System.out.println("Introduzca por favor el codigo postal del cliente");
		String codigoPostal = sc.nextLine();
		System.out.println("Introduzca por favor el pais del cliente");
		String pais = sc.nextLine();
		System.out.println("Introduzca Por favor el numero del cliente");
		int representante = 1002;
		try {
			representante = Integer.parseInt(sc.nextLine());

		} catch (Exception e) {
			System.out.println("No se ha introducido numero de representante de ventas");

		}
		System.out.println("Introduzca por favor credito (n�mero con decimales)");
		Double credito = 0.0;
		try {
			credito = Double.parseDouble(sc.nextLine());

		} catch (Exception e) {
			System.out.println("No se ha introducido credito");

		}
		ClientesControlador controladorClientes = new ClientesControlador();
		int resultado = controladorClientes.actualizarCliente(numeroCliente, nombreCliente, apellidoCliente,
				nombreContacto, telefono, direccion1, direccion2, ciudad, estado, codigoPostal, pais, representante,
				credito);
		if (resultado == 1) {
			System.out.println("Se ha actualizado el registro con exito");
		} else {
			System.out.println("Se ha producido un error al actualizar el registro");
		}

	}

	private void menuBorrarCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca el numero del usuario a borrar");
		Integer customerNumber = Integer.parseInt(sc.next());

		ClientesControlador controladorClientes = new ClientesControlador();
		int resultado = controladorClientes.borrarCliente(customerNumber);
		if (resultado == 1) {
			System.out.println("Se ha actualizado el registro con exito");
		} else {
			System.out.println("Se ha producido un error al actualizar el registro");
		}
	}

	public void menuGeneralClientes() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int menuEleccion = 0;
		do {
			System.out.println("Introduzca la operaci�n que desee realizar: ");

			System.out.println("       MEN� PRINCIPAL PARA LA GESTI�N DE CLIENTES");
			System.out.println("===============================================");
			System.out.println("1. Buscar cliente por nombre");
			System.out.println("2. Buscar cliente por nombre, tel�fono o pa�s");
			System.out.println("3. Insertar cliente ");
			System.out.println("4. Actualizar cliente ");
			System.out.println("5. Borrar cliente");
			System.out.println("6. Volver al men� principal");
			System.out.println("===============================================");
			menuEleccion = solicitarNumeroMenu(sc);
			switch (menuEleccion) {
			case 1:
				menuRecuperaNombreTelefono();
				break;
			case 2:
				menuRecuperarNombreTelefonoConFiltros();
				break;
			case 3:
				menuInsertarCliente();

				break;
			case 4:
				menuActualizarCliente();

				break;
			case 5:
				menuBorrarCliente();

				break;
			case 6:
				return;

			default:
				System.out.println("Introduce Bien el numero");
				break;
			}

		} while (menuEleccion != 6);

	}

	private int solicitarNumeroMenu(Scanner sc) {
		int menuEleccion;
		try {
			menuEleccion = sc.nextInt();
			sc.nextLine();
		} catch (NumberFormatException e) {
			menuEleccion = 0;

		}
		return menuEleccion;
	}

}
