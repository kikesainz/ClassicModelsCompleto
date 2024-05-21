package com.kike.classicmodels.vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kike.classicmodels.controlador.EmpleadosControlador;
import com.kike.classicmodels.dtos.EmpleadoDTO;
import com.kike.classicmodels.scanner.MiScanner;

public class VistaEmpleados {

	public void menuGeneral() throws ClassNotFoundException, SQLException {
		Integer n;
		do {

			Scanner sc = MiScanner.getInstance();
			System.out.println("Introduzca la operaci�n que desee realizar: ");

			System.out.println("       MEN� PRINCIPAL PARA LA GESTI�N DE EMPLEADOS");
			System.out.println("===============================================");
			System.out.println("1. Buscar Empleados con filtros");
			System.out.println("2. Insertar Empleado");
			System.out.println("3. Actualizar Empleado ");
			System.out.println("4. Volver al men� principal");
			System.out.println("===============================================");
			n = pedirNumeroMenu(sc);
			switch (n) {
			case 1: {
				menuBuscarEmpleadosConFiltros();
				break;

			}
			case 2: {
				menuInsertarEmpleado();
				break;

			}
			case 3: {
				menuActualizarEmpleado();
				break;

			}

			default:
				System.out.println("Introduce bien el numero");
			}
		} while (n != 4);

	}

	private Integer pedirNumeroMenu(Scanner sc) {
		Integer n;
		try {
			n = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			n = 0;
		}
		return n;
	}

	public void menuBuscarEmpleadosConFiltros() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduce el numero del empleado a buscar");

		Integer employeeNumber = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduce el apellido del empleado a buscar");
		String lastName = sc.nextLine();

		System.out.println("Introduce el nombre del empleado a buscar");
		String firstName = sc.nextLine();

		System.out.println("Introduce la extension del empleado a buscar");
		String extension = sc.nextLine();

		System.out.println("Introduce el titulo del empleado a buscar");
		String jobTitle = sc.nextLine();

		List<EmpleadoDTO> listaEmpleados = new ArrayList<>();
		EmpleadosControlador ec = new EmpleadosControlador();

		listaEmpleados = ec.buscarEmpleadosConFiltros(employeeNumber, lastName, firstName, extension, jobTitle);

		for (EmpleadoDTO empleadoDTO : listaEmpleados) {
			System.out.println(empleadoDTO);
		}

	}

	public void menuInsertarEmpleado() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduce el numero del empleado");
		Integer employeeNumber = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduce el apellido del empleado");
		String lastName = sc.nextLine();

		System.out.println("Introduce el nombre del empleado");
		String firstName = sc.nextLine();

		System.out.println("Introduce la extension del empleado");
		String extension = sc.nextLine();

		System.out.println("Introduce el email del empleado");
		String email = sc.nextLine();

		System.out.println("Introduce el codigo de oficina del empleado");
		String officeCode = sc.nextLine();

		System.out.println("Introduce el codigo del jefe del empleado");
		Integer reportsTo = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduce el titulo del empleado");
		String jobTitle = sc.nextLine();

		EmpleadoDTO empleadoInsertar = new EmpleadoDTO(employeeNumber, lastName, firstName, extension, email,
				officeCode, reportsTo, jobTitle);
		Integer resultado = new EmpleadosControlador().insertarEmpleado(empleadoInsertar);

		if (resultado != 0) {
			System.out.println("Empleado Insertado con exito");

		}

	}

	public void menuActualizarEmpleado() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduce el numero del empleado");
		Integer employeeNumber = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduce el apellido del empleado");
		String lastName = sc.nextLine();

		System.out.println("Introduce el nombre del empleado");
		String firstName = sc.nextLine();

		System.out.println("Introduce la extension del empleado");
		String extension = sc.nextLine();

		System.out.println("Introduce el email del empleado");
		String email = sc.nextLine();

		System.out.println("Introduce el codigo de oficina del empleado");
		String officeCode = sc.nextLine();

		System.out.println("Introduce el codigo del jefe del empleado");
		Integer reportsTo = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduce el titulo del empleado");
		String jobTitle = sc.nextLine();

		EmpleadoDTO empleadoActualizar = new EmpleadoDTO(employeeNumber, lastName, firstName, extension, email,
				officeCode, reportsTo, jobTitle);
		Integer resultado = new EmpleadosControlador().actualizarEmpleado(empleadoActualizar);

		if (resultado != 0) {
			System.out.println("Empleado Insertado con exito");

		}

	}

}
