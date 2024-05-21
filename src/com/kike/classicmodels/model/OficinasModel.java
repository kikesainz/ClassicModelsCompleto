package com.kike.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kike.classicmodels.dtos.OficinasDTO;
import com.kike.classicmodels.utils.DBUtils;

public class OficinasModel {
	public List<OficinasDTO> busquedaDeOficinasConFiltros(String officeCode, String city, String state, String country)
			throws ClassNotFoundException, SQLException {
		List<OficinasDTO> listaOficinas = new ArrayList<>();
		String sql = "select * from offices " + "where officeCode like ?" + "and city like ? " + "and state like ? "
				+ "and country like ?"

		;
		try (Connection conexion = DBUtils.conexionBBDD(); PreparedStatement ps = conexion.prepareStatement(sql)) {
			ps.setString(1, "%" + officeCode + "%");
			ps.setString(2, "%" + city + "%");
			ps.setString(3, "%" + state + "%");
			ps.setString(4, "%" + country + "%");
			System.out.println(ps);
			ResultSet resultados = ps.executeQuery();

			while (resultados.next()) {
				OficinasDTO nuevaOficina = new OficinasDTO(resultados.getString("officeCode"),
						resultados.getString("city"), resultados.getString("phone"),
						resultados.getString("addressLine1"), resultados.getString("addressLine2"),
						resultados.getString("state"), resultados.getString("country"),
						resultados.getString("postalCode"), resultados.getString("territory"));
				listaOficinas.add(nuevaOficina);
			}
		}
		return listaOficinas;

	}

	public Integer insertarOficina(OficinasDTO oficinaInsertar) throws SQLException, ClassNotFoundException {
		String sql = "Insert into offices (officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory)"
				+ "values (?,?,?,?,?,?,?,?,?)";

		try (Connection conexion = DBUtils.conexionBBDD(); PreparedStatement ps = conexion.prepareStatement(sql)) {
			ps.setString(1, oficinaInsertar.getOfficeCode());
			ps.setString(2, oficinaInsertar.getCity());
			ps.setString(3, oficinaInsertar.getPhone());

			ps.setString(4, oficinaInsertar.getAddressLine1());
			ps.setString(5, oficinaInsertar.getAddressLine2());
			ps.setString(6, oficinaInsertar.getState());

			ps.setString(7, oficinaInsertar.getCountry());
			ps.setString(8, oficinaInsertar.getPostalCode());
			ps.setString(9, oficinaInsertar.getTerritory());

			System.out.println(ps);

			return ps.executeUpdate();
		}
	}

	public Integer actualizarOficina(OficinasDTO oficina) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE  offices set city = Case when ? = '' then city else ? end,"
				+ "phone = case when ? = '' then phone else ? end ,"
				+ "addressLine1 = case when ? = '' then addressLine1 else ? end ,"
				+ "addressLine2 = case when ? = '' then addressLine2 else ? end,"
				+ "state = case when ? = '' then state else ? end, "
				+ "country = case when ? = '' then country else ? end, "
				+ "postalCode = case when ? = '' then postalCode else ? end,"
				+ "territory = case when ? = '' then territory else ? end " + "Where officeCode = ?";
		try (Connection conexion = DBUtils.conexionBBDD(); PreparedStatement ps = conexion.prepareStatement(sql)) {
			ps.setString(1, oficina.getCity());
			ps.setString(2, oficina.getCity());

			ps.setString(3, oficina.getPhone());
			ps.setString(4, oficina.getPhone());

			ps.setString(5, oficina.getAddressLine1());
			ps.setString(6, oficina.getAddressLine1());

			ps.setString(7, oficina.getAddressLine2());
			ps.setString(8, oficina.getAddressLine2());

			ps.setString(9, oficina.getState());
			ps.setString(10, oficina.getState());

			ps.setString(11, oficina.getCountry());
			ps.setString(12, oficina.getCountry());

			ps.setString(13, oficina.getPostalCode());
			ps.setString(14, oficina.getPostalCode());

			ps.setString(15, oficina.getTerritory());
			ps.setString(16, oficina.getTerritory());

			ps.setString(17, oficina.getOfficeCode());

			System.out.println(ps);

			return ps.executeUpdate();
		}

	}

}
