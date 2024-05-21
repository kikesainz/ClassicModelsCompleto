package com.kike.classicmodels.vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kike.classicmodels.controlador.OficinasControlador;
import com.kike.classicmodels.dtos.OficinasDTO;
import com.kike.classicmodels.scanner.MiScanner;

public class OficinasVista {
	public void menuBusquedaDeOficinasConFiltros() throws ClassNotFoundException, SQLException {
		List<OficinasDTO> listaOficinas = new ArrayList<>();
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduce el codigo de la oficina");
		String officeCode = sc.nextLine();
		System.out.println("Introduce la ciudad");
		String city = sc.nextLine();
		System.out.println("Introduce el estado de la oficina");
		String state = sc.nextLine();
		System.out.println("Introduce el pais de la oficina");
		String country = sc.nextLine();
		listaOficinas = new OficinasControlador().busquedaDeOficinasConFiltros(officeCode, city, state, country);

		for (OficinasDTO oficinasDTO : listaOficinas) {
			System.out.println(oficinasDTO);
		}

	}

	public void menuInsertarOficina() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Menu Creacion Oficina");

		System.out.println("Introduce el codigo de la oficina");
		String officeCode = sc.nextLine();

		System.out.println("Introduce la ciudad de la oficina");
		String city = sc.nextLine();

		System.out.println("Introduce el telefono de la oficina");
		String phone = sc.nextLine();

		System.out.println("Introduce la direccion 1 de la oficina");
		String addressLine1 = sc.nextLine();

		System.out.println("Introduce la direccion 2 de la oficina");
		String addressLine2 = sc.nextLine();

		System.out.println("Introduce el estado de la oficina");
		String state = sc.nextLine();

		System.out.println("Introduce el pais de la oficina");
		String country = sc.nextLine();

		System.out.println("Introduce el codigo postal de la oficina");
		String postalCode = sc.nextLine();

		System.out.println("Introduce el territorio de la oficina");
		String territory = sc.nextLine();

		OficinasDTO OficinaInsertar = new OficinasDTO(officeCode, city, phone, addressLine1, addressLine2, state,
				country, postalCode, territory);

		Integer resultado = new OficinasControlador().insertarOficina(OficinaInsertar);
		if (resultado != 0) {
			System.out.println("Insertado con exito");

		}

	}

	public void menuActualizarOficina() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduce el codigo de la oficina a actualizar");
		String officeCode = sc.nextLine();

		System.out.println("Introduce la ciudad de la oficina");
		String city = sc.nextLine();

		System.out.println("Introduce el telefono de la oficina");
		String phone = sc.nextLine();

		System.out.println("Introduce la direccion 1 de la oficina");
		String addressLine1 = sc.nextLine();

		System.out.println("Introduce la direccion 2 de la oficina");
		String addressLine2 = sc.nextLine();

		System.out.println("Introduce el estado de la oficina");
		String state = sc.nextLine();

		System.out.println("Introduce el pais de la oficina");
		String country = sc.nextLine();

		System.out.println("Introduce el codigo postal de la oficina");
		String postalCode = sc.nextLine();

		System.out.println("Introduce el territorio de la oficina");
		String territory = sc.nextLine();

		OficinasDTO OficinaInsertar = new OficinasDTO(officeCode, city, phone, addressLine1, addressLine2, state,
				country, postalCode, territory);

		Integer resultado = new OficinasControlador().actualizaOficina(OficinaInsertar);
		if (resultado != 0) {
			System.out.println("Actualizado Con exito");

		}

	}

	public void menuGeneral() throws ClassNotFoundException, SQLException {
		Integer n;
		do {

			Scanner sc = MiScanner.getInstance();
			System.out.println("Introduzca la operaci�n que desee realizar: ");

			System.out.println("       MEN� PRINCIPAL PARA LA GESTI�N DE OFICINAS");
			System.out.println("===============================================");
			System.out.println("1. Buscar Oficinas con filtros");
			System.out.println("2. Insertar Oficina");
			System.out.println("3. Actualizar Oficina");
			System.out.println("4. Volver al men� principal");
			System.out.println("===============================================");
			n = pedirNumeroMenu(sc);
			switch (n) {
			case 1: {
				menuBusquedaDeOficinasConFiltros();
				break;

			}
			case 2: {
				menuInsertarOficina();
				break;

			}
			case 3: {
				menuActualizarOficina();
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

}
