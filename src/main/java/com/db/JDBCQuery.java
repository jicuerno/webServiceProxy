package com.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import com.datos.Datos;
import com.datos.Linea;
import com.datos.Tarea;
import com.datos.Usuario;

public class JDBCQuery {

	public static boolean insertarUsuarios(Datos datos) {
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();

			for (Usuario item : datos.getUsuarios()) {
				stmt.execute(creaInsertUsuario(item));
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

	public static boolean insertarTareas(Datos datos) {
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();

			for (Tarea item : datos.getTareas()) {
				stmt.execute(creaInsertTarea(item));
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

	public static boolean insertarLineas(Datos datos) {
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();

			for (Linea item : datos.getLineas()) {
				stmt.execute(creaInsertLinea(item));
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

	private static String creaInsertLinea(Linea item) {
		return "INSERT INTO datosRequest (keyUsuario, keyTarea, elemento, url, evento, tiempo, pcIp) " + "VALUES "
				+ "('" + item.getKeyUsuario() + "','" + item.getKeyTarea() + "','" + item.getElemento() + "','"
				+ item.getUrl() + "','" + item.getEvento() + "','" + new Timestamp(Long.parseLong(item.getTiempo())) + "','"
				+ item.getPcIp() + "')";
	}

	private static String creaInsertTarea(Tarea item) {
		return "INSERT INTO datosTarea (keyTarea, instrucciones, urlInicio, urlFinal, tiempo) " + "VALUES " + "('"
				+ item.getKeyTarea() + "','" + item.getInstrucciones() + "','" + item.getUrlInicio() + "','"
				+ item.getUrlFinal() + "','" + item.getTiempo() + "')";
	}

	private static String creaInsertUsuario(Usuario user) {
		return "INSERT INTO datosUser (keyUsuario,edad,sexo) " + "VALUES " + "('" + user.getKeyUsuario() + "',"
				+ user.getEdad() + ",'" + user.getSexo() + "')";
	}

	/**
	 * Devuelve una conexion con la BD
	 */

	public static Connection getConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "dbProxyMob";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String password = "";
		String opts = "?useLegacyDatetimeCode=false&serverTimezone=UTC";

		Class<?> driver_class = Class.forName(driver);
		Driver drv = (Driver) driver_class.newInstance();
		DriverManager.registerDriver(drv);

		Connection conn = DriverManager.getConnection(url + dbName + opts, userName, password);

		return conn;
	}

}
