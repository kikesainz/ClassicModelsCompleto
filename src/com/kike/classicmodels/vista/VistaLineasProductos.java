package com.kike.classicmodels.vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kike.classicmodels.controlador.LineasProductoControlador;
import com.kike.classicmodels.dtos.LineasProductoDTO;
import com.kike.classicmodels.scanner.MiScanner;

public class VistaLineasProductos {

	public void menuGeneralLineasProducto() throws ClassNotFoundException, SQLException {
		Integer n;

		do {

			Scanner sc = MiScanner.getInstance();
			System.out.println("Introduzca la operaci�n que desee realizar: ");

			System.out.println("       MEN� PRINCIPAL PARA LA GESTI�N DE LINEAS DE PRODUCTO");
			System.out.println("===============================================");
			System.out.println("1. Buscar Linea de producto con filtros");
			System.out.println("2. Insertar Linea de producto");
			System.out.println("3. Actualizar Linea de producto ");
			System.out.println("4. Volver al men� principal");
			System.out.println("===============================================");
			n = pedirNumeroMenu(sc);
			switch (n) {
			case 1: {
				menuBuscarLineasProducto();
				break;

			}
			case 2: {
				menuInsertarLineaProducto();
				break;

			}
			case 3: {
				menuActualizarLineaProducto();
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

	public void menuBuscarLineasProducto() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		List<LineasProductoDTO> listaLineas = new ArrayList<>();
		System.out.println("Introduce el nombre de la linea de producto");
		String productLine = sc.nextLine();
		System.out.println("Introduce la descripcion");
		String textDescription = sc.nextLine();
		LineasProductoControlador lineasControlador = new LineasProductoControlador();
		listaLineas = lineasControlador.buscarLineaProducto(productLine, textDescription);
		for (LineasProductoDTO lineasProductoDTO : listaLineas) {
			System.out.println(lineasProductoDTO);
		}

	}

	public void menuInsertarLineaProducto() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduce el nombre de la linea de producto");
		String productLine = sc.nextLine();
		System.out.println("Introduzca una descripcion de la linea de producto");
		String textDescription = sc.nextLine();
		System.out.println("Introduzca una direccion url");
		String url = sc.nextLine();
		int resultado = new LineasProductoControlador().insertarProducto(productLine, textDescription, url);
		if (resultado == 1) {
			System.out.println("Insertado con exito");
			return;
		}
		System.out.println("No se ha podido insertar");

	}

	public void menuActualizarLineaProducto() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduce el nombre de la linea de producto a actualizar");
		String productLine = sc.nextLine();
		System.out.println("Introduzca una descripcion de la linea de producto");
		String textDescription = sc.nextLine();
		System.out.println("Introduzca una direccion url");
		String url = sc.nextLine();
		int resultado = new LineasProductoControlador().actualizarLineaProducto(productLine, textDescription, url);
		if (resultado == 1) {
			System.out.println("Insertado con exito");
			return;
		}
		System.out.println("No se ha podido insertar");

	}

}
