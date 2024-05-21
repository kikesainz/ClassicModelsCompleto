package com.kike.classicmodels.vista;

import java.sql.SQLException;
import java.util.Scanner;

import com.kike.classicmodels.scanner.MiScanner;

public class MenuPrincipal {
	public void imprimirMenuPrincipal() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		int eleccionMenu = 0;
		do {
			System.out.println("       MEN� PRINCIPAL PARA LA GESTI�N DE LA TIENDA CLASSIC MODELS");
			System.out.println("===============================================");
			System.out.println("1. Gesti�n de inventario");
			System.out.println("2. Gesti�n de lineas productos");
			System.out.println("3. Gesti�n de clientes");
			System.out.println("4. Gesti�n de empleados ");
			System.out.println("5. Gesti�n de oficinas");
			System.out.println("6. Gesti�n de Pedidos");
			System.out.println("7. Salir de la aplicaci�n");
			System.out.println("===============================================");
			eleccionMenu = solicitarNumeroEleccionMenu(sc);
			switch (eleccionMenu) {
			case 1:
				VistaInventario vi = new VistaInventario();
				vi.menuGeneralInventario();

				break;
			case 2:
				VistaLineasProductos vlp = new VistaLineasProductos();
				vlp.menuGeneralLineasProducto();
				break;
			case 3:
				VistaClientes vc = new VistaClientes();
				vc.menuGeneralClientes();
				break;
			case 4:
				VistaEmpleados ve = new VistaEmpleados();
				ve.menuGeneral();

				break;
			case 5:
				OficinasVista vo = new OficinasVista();
				vo.menuGeneral();

				break;
			case 6:
				VistaPedido vp = new VistaPedido();
				vp.menuGeneral();
				break;
			case 7:
				System.out.println("Saliste de la aplicacion");
				break;

			default:
				System.out.println("Introduce bien el numero");
				break;
			}

		} while (eleccionMenu != 7);

	}

	private int solicitarNumeroEleccionMenu(Scanner sc) {
		int eleccionMenu;
		try {
			eleccionMenu = sc.nextInt();
			sc.nextLine();
		} catch (NumberFormatException e) {
			eleccionMenu = 0;
		}
		return eleccionMenu;
	}

}
