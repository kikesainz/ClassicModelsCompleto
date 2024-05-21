package com.kike.classicmodels.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kike.classicmodels.controlador.PedidoControlador;
import com.kike.classicmodels.dtos.CantidadPedidaProducto;
import com.kike.classicmodels.dtos.EmpleadoDTO;
import com.kike.classicmodels.dtos.OficinasDTO;
import com.kike.classicmodels.model.ClientesModelo;
import com.kike.classicmodels.model.EmpleadosModel;
import com.kike.classicmodels.model.LineasProductoModel;
import com.kike.classicmodels.model.OficinasModel;
import com.kike.classicmodels.model.PedidosModel;
import com.kike.classicmodels.model.ProductosModel;
import com.kike.classicmodels.vista.MenuPrincipal;
import com.kike.classicmodels.vista.VistaClientes;
import com.kike.classicmodels.vista.VistaPedido;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Menu
		new MenuPrincipal().imprimirMenuPrincipal();

	}

}
