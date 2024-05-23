package com.kike.classicmodels.vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kike.classicmodels.controlador.ProductosControlador;
import com.kike.classicmodels.dtos.ProductoDTO;
import com.kike.classicmodels.scanner.MiScanner;

public class VistaInventario {

	public void menuGeneralInventario() throws ClassNotFoundException, SQLException {
		Integer n;
		do {

			Scanner sc = MiScanner.getInstance();
			System.out.println("Introduzca la operaci�n que desee realizar: ");

			System.out.println("       MEN� PRINCIPAL PARA LA GESTI�N DE IVENTARIO");
			System.out.println("===============================================");
			System.out.println(
					"1. Buscar Producto por Codigo producto, Nombre Producto,Linea de producto, y descripcion");
			System.out.println("2. Insertar Producto");
			System.out.println("3. Actualizar producto ");
			System.out.println("4. Volver al men� principal");
			System.out.println("===============================================");
			n = pedirNumeroMenu(sc);
			switch (n) {
			case 1: {
				menuBuscarProductoConFiltros();
				break;

			}
			case 2: {
				menuCrearProducto();
				break;

			}
			case 3: {
				menuActualizarProducto();
				break;

			}

			default:
				System.out.println("Introduce bien el numero");
			}
		} while (n != 4);

	}

	private void menuActualizarProducto() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduce el codigo del producto");
		String productCode = sc.nextLine();
		System.out.println("Introduce el nombre del producto");
		String productName = sc.nextLine();
		System.out.println("Introduce la linea de producto");
		String productLine = sc.nextLine();
		System.out.println("Introduce la escala del producto");
		String productScale = sc.nextLine();
		System.out.println("Introduce el vendedor producto");
		String productVendor = sc.nextLine();
		System.out.println("Introduce la descripcion del producto");
		String productDescription = sc.nextLine();
		System.out.println("Introduce la cantidad en stock");
		Integer quantityInStock;
		try {
			quantityInStock = sc.nextInt();
			sc.nextLine();

		} catch (Exception e) {
			quantityInStock = 0;
		}
		System.out.println("Introduce el precio de compra");
		float buyPrice;
		try {
			buyPrice = sc.nextFloat();
			sc.nextLine();
		} catch (Exception e) {
			buyPrice = 0;
		}
		System.out.println("Introduce el MSRP");
		float MSRP;
		try {
			MSRP = sc.nextFloat();
			sc.nextLine();
		} catch (Exception e) {
			MSRP = 0;
		}
		Integer resultado = new ProductosControlador().actualizarProducto(productCode, productName, productLine,
				productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP);

		if (resultado != 0) {
			System.out.println("Se ha actualizado con exito");
		}
	}

	private void menuBuscarProductoConFiltros() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduce el Codigo de Producto");
		String productCode = sc.nextLine();
		System.out.println("Introduce el nombre del producto");
		String productName = sc.nextLine();
		System.out.println("Introduce la linea de producto");
		String productLine = sc.nextLine();
		System.out.println("Introduce la escala del producto");
		String productDescription = sc.nextLine();
		List<ProductoDTO> listaResultados = new ArrayList<>();
		ProductosControlador pc = new ProductosControlador();
		listaResultados = pc.buscarProductoConFiltros(productCode, productName, productLine, productDescription, null, null, null, null, null);
		for (ProductoDTO productoDTO : listaResultados) {
			System.out.println(productoDTO);
		}

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

	private void menuCrearProducto() throws ClassNotFoundException, SQLException {
		System.out.println("Menu Creacion Producto");
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduce el codigo del producto a crear");
		String productCode = sc.nextLine();
		System.out.println("Introduce el nombre del producto a crear");
		String productName = sc.nextLine();
		System.out.println("Introduce la linea de producto a crear");
		String productLine = sc.nextLine();
		System.out.println("Introduce la escala del producto a crear");
		String productScale = sc.nextLine();
		System.out.println("Introduce el vendedor producto a crear");
		String productVendor = sc.nextLine();
		System.out.println("Introduce la descripcion del a crear");
		String productDescription = sc.nextLine();
		System.out.println("Introduce la cantidad en stock a crear");
		Integer quantityInStock;
		try {
			quantityInStock = Integer.parseInt(sc.nextLine());

		} catch (Exception e) {
			quantityInStock = 0;
		}
		System.out.println("Introduce buyPrice producto");
		float buyPrice;
		try {
			buyPrice = Float.parseFloat(sc.nextLine());
		} catch (Exception e) {
			buyPrice = 0;
		}
		System.out.println("Introduce MSRP producto");

		float MSRP;
		try {
			MSRP = Float.parseFloat(sc.nextLine());
		} catch (Exception e) {
			MSRP = 0;
		}

		ProductosControlador pc = new ProductosControlador();
		int resultado = pc.crearProducto(productCode, productName, productLine, productScale, productVendor,
				productDescription, quantityInStock, buyPrice, MSRP);
		if (resultado != 0) {
			System.out.println("Operacion realizada con exito");
		}

	}

}
