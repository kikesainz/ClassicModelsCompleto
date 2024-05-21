package com.kike.classicmodels.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kike.classicmodels.dtos.EmpleadoDTO;
import com.kike.classicmodels.model.EmpleadosModel;

public class EmpleadosControlador {
	public List<EmpleadoDTO> buscarEmpleadosConFiltros(Integer employeeNumber, String lastName, String firstName,
			String extension, String jobTitle) throws ClassNotFoundException, SQLException {
		List<EmpleadoDTO> listaEmpleado = new ArrayList<>();
		EmpleadosModel em = new EmpleadosModel();
		listaEmpleado = em.buscarEmpleadosConFiltros(employeeNumber, lastName, firstName, extension, jobTitle);

		return listaEmpleado;
	}

	public Integer insertarEmpleado(EmpleadoDTO empleado) throws ClassNotFoundException, SQLException {
		return new EmpleadosModel().insertarEmpleado(empleado);
	}
	public Integer actualizarEmpleado(EmpleadoDTO empleado) throws ClassNotFoundException, SQLException {
		return new EmpleadosModel().actualizarEmpleado(empleado);
	}
}
