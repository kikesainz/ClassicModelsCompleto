package com.kike.classicmodels.utils;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private DBUtils() {

	}

	public static Connection conexionBBDD() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String servidor = "jdbc:mysql://localhost:3306/classicmodels";
		String username = "root";
		String password = "PracticaRoot";
		Connection conexionBD = DriverManager.getConnection(servidor, username, password);
		System.out.println(conexionBD);
		return conexionBD;
	}



}
