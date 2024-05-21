package com.kike.classicmodels.controlador;

import java.sql.SQLException;
import java.util.List;

import com.kike.classicmodels.dtos.OficinasDTO;
import com.kike.classicmodels.model.OficinasModel;

public class OficinasControlador {
	public List<OficinasDTO> busquedaDeOficinasConFiltros(String officeCode, String city, String state, String country)
			throws ClassNotFoundException, SQLException {
		return new OficinasModel().busquedaDeOficinasConFiltros(officeCode, city, state, country);
	}

	public Integer insertarOficina(OficinasDTO oficinaInsertar) throws SQLException, ClassNotFoundException {
		return new OficinasModel().insertarOficina(oficinaInsertar);
	}

	public Integer actualizaOficina(OficinasDTO oficinaActualizar) throws SQLException, ClassNotFoundException {
		return new OficinasModel().actualizarOficina(oficinaActualizar);
	}

}
