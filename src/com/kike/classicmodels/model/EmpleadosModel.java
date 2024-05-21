package com.kike.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kike.classicmodels.dtos.EmpleadoDTO;
import com.kike.classicmodels.utils.DBUtils;

public class EmpleadosModel {
	public List<EmpleadoDTO> buscarEmpleadosConFiltros(Integer employeeNumber, String lastName, String firstName,
			String extension, String jobTitle) throws ClassNotFoundException, SQLException {
		List<EmpleadoDTO> listaEmpleado = new ArrayList<>();
		String sql = "select * from employees " + "where employeeNumber like ?" + "and lastName like ? "
				+ "and firstName like ? " + "and extension like ? and jobTitle like ?";

		Connection conexxion = DBUtils.conexionBBDD();
		PreparedStatement ps = conexxion.prepareStatement(sql);

		ps.setString(1, "%" + employeeNumber + "%");
		ps.setString(2, "%" + lastName + "%");
		ps.setString(3, "%" + firstName + "%");
		ps.setString(4, "%" + extension + "%");
		ps.setString(5, "%" + jobTitle + "%");

		ResultSet resultados = ps.executeQuery();

		while (resultados.next()) {
			EmpleadoDTO nuevoEmpleado = new EmpleadoDTO(resultados.getInt("employeeNumber"),
					resultados.getString("lastName"), resultados.getString("firstName"),
					resultados.getString("extension"), resultados.getString("email"),
					resultados.getString("officeCode"), resultados.getInt("reportsTo"),
					resultados.getString("jobTitle"));
			listaEmpleado.add(nuevoEmpleado);
		}
		conexxion.close();

		return listaEmpleado;

	}

	public Integer insertarEmpleado(EmpleadoDTO empleado) throws ClassNotFoundException, SQLException {
		String sql = "insert into employees (employeeNumber, lastName, firstName,extension,email,officeCode,reportsTo,jobTitle) "
				+ "values " + "(?,?,?,?,?,?,?,?);";
		Connection conexxion = DBUtils.conexionBBDD();

		PreparedStatement ps = conexxion.prepareStatement(sql);
		ps.setInt(1, empleado.getEmployeeNumber());
		ps.setString(2, empleado.getLastName());
		ps.setString(3, empleado.getFirstName());
		ps.setString(4, empleado.getExtension());
		ps.setString(5, empleado.getEmail());
		ps.setString(6, empleado.getOfficeCode());
		ps.setInt(7, empleado.getReportsTo());
		ps.setString(8, empleado.getJobTitle());
		System.out.println(ps);

		Integer resultado = ps.executeUpdate();
		return resultado;

	}

	public Integer actualizarEmpleado(EmpleadoDTO empleado) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE  employees set lastName = Case when ? = '' then lastName else ? end,"
				+ "firstName = case when ? = '' then firstName else ? end ,"
				+ "extension = case when ? = '' then extension else ? end ,"
				+ "email = case when ? = '' then email else ? end,"
				+ "officeCode = case when ? = '' then officeCode else ? end, "
				+ "reportsTo = case when ? = '' then reportsTo else ? end, "
				+ "jobTitle = case when ? = '' then jobTitle else ? end " + "Where employeeNumber = ?";
		Connection conexxion = DBUtils.conexionBBDD();

		PreparedStatement ps = conexxion.prepareStatement(sql);

		ps.setString(1, empleado.getLastName());
		ps.setString(2, empleado.getLastName());

		ps.setString(3, empleado.getFirstName());
		ps.setString(4, empleado.getFirstName());

		ps.setString(5, empleado.getExtension());
		ps.setString(6, empleado.getExtension());

		ps.setString(7, empleado.getEmail());
		ps.setString(8, empleado.getEmail());

		ps.setString(9, empleado.getOfficeCode());
		ps.setString(10, empleado.getOfficeCode());

		ps.setInt(11, empleado.getReportsTo());
		ps.setInt(12, empleado.getReportsTo());

		ps.setString(13, empleado.getJobTitle());
		ps.setString(14, empleado.getJobTitle());

		ps.setInt(15, empleado.getEmployeeNumber());
		System.out.println(ps);
		Integer resultado = ps.executeUpdate();
		return resultado;

	}
}
