package com.kike.classicmodels.main;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

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
import com.kike.classicmodels.vistagui.GestionProductosPanel;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Menu
//		new MenuPrincipal().imprimirMenuPrincipal();
		
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Classic Models Management");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());

            JTabbedPane tabbedPane = new JTabbedPane();

            tabbedPane.addTab("Products", new GestionProductosPanel());
//            tabbedPane.addTab("Product Lines", new ProductLineManagementPanel());

            frame.add(tabbedPane, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }

	}


