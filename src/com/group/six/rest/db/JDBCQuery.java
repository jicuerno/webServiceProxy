package com.group.six.rest.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.group.six.rest.db.datos.Datos;
import com.group.six.rest.db.datos.Linea;

public class JDBCQuery {

	@SuppressWarnings("resource")
	public static boolean insertar(Datos datos) {
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			for (Linea item : datos.getLineas()) {
				stmt.execute(creaInsert(item));
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static String creaInsert(Linea item) {
		return "INSERT INTO tablaDatos (codigo,element, url, event, time) " + "VALUES " + "('" + item.getCodigo()
				+ "', '" + item.getElement() + "','" + item.getUrl() + "', '" + item.getEvent() + "', '"
				+ item.getTime() + "')";
	}

	/**
	 * Devuelve una conexion con la BD
	 */

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=");
		return conn;
	}

}
