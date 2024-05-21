package com.kike.classicmodels.vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kike.classicmodels.controlador.ClientesControlador;
import com.kike.classicmodels.controlador.PedidoControlador;
import com.kike.classicmodels.dtos.CantidadPedidaProducto;
import com.kike.classicmodels.dtos.PedidoDTO;
import com.kike.classicmodels.scanner.MiScanner;

public class VistaPedido {
	public void menuCrearPedido() throws ClassNotFoundException, SQLException {
		List<CantidadPedidaProducto> listaPedidos = new ArrayList<>();
		Scanner sc = MiScanner.getInstance();
		int n = 0;

		do {
			System.out.println("Introduzca el codigo de producto");
			String codigoProducto = sc.nextLine();

			System.out.println("Introduzca la cantidad del producto" + codigoProducto);
			Integer cantidadProducto = sc.nextInt();
			sc.nextLine();
			CantidadPedidaProducto nuevoProducto = new CantidadPedidaProducto(codigoProducto, cantidadProducto);
			listaPedidos.add(nuevoProducto);

			System.out.println("Desea A�adir Otro pedido");
			System.out.println("1. SI");
			System.out.println("2. NO");
			n = Integer.parseInt(sc.nextLine());

		} while (n != 2);
		System.out.println("Introduzca la fecha de realizacion del pedido (YYYY/MM/DD)");
		String fechaRealizacion = sc.nextLine();
		System.out.println("Introduzca la fecha requerida del pedido (YYYY/MM/DD)");
		String fechaRequerida = sc.nextLine();
		System.out.println("Introduzca el estado del pedido");
		String estado = sc.nextLine();
		System.out.println("Introduzca el comentario del pedido");
		String comentario = sc.nextLine();
		System.out.println("Introduzca el numero del cliente");
		Integer cliente = null;
		try {
			cliente = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido cliente");
		}
		PedidoControlador pc = new PedidoControlador();
		if (!pc.crearPedido(fechaRealizacion, fechaRequerida, estado, comentario, cliente, listaPedidos).equals(0)) {
			System.out.println("Creado Pedido");

		}

	}

	public void menuGeneral() throws ClassNotFoundException, SQLException {
		Integer eleccionPedido;
		do {
			System.out.println("       MEN� PRINCIPAL PARA LA GESTI�N DE LOS PEDIDOS DE LA TIENDA CLASSIC MODELS");
			System.out.println("===============================================");
			System.out.println("1. Crear Nuevo Pedido");
			System.out.println("2. Busqueda de Pedidos");
			System.out.println("3. Volver al menu Principal");
			System.out.println("===============================================");
			Scanner sc = MiScanner.getInstance();
			try {
				eleccionPedido = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				eleccionPedido =0;
			}
			switch (eleccionPedido) {
			case 1:
				menuCrearPedido();

				break;
			case 2:
				menuBuscarPedidoConFiltro();

				break;

			default:
				break;
			}

		} while (eleccionPedido != 3);
	}

	private void menuBuscarPedidoConFiltro() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca EL codigo del pedido");
		Integer orderNumber;
		try {
			orderNumber = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			orderNumber = 0;
			e.printStackTrace();
		}
		PedidoControlador pc = new PedidoControlador();
		List<PedidoDTO> listaPedidos = pc.buscarPedidoFiltro(orderNumber);
		for (PedidoDTO pedidoDTO : listaPedidos) {
			System.out.println(pedidoDTO);
		}

	}

}
