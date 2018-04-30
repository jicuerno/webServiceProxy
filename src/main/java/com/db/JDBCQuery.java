package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.datos.Datos;
import com.datos.Linea;
import com.datos.Tarea;
import com.datos.Usuario;

public class JDBCQuery {

	@SuppressWarnings("resource")
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

	@SuppressWarnings("resource")
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

	@SuppressWarnings("resource")
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
		return "INSERT INTO datosRequest ('keyUsuario', 'keyTarea', 'elemento', 'url', 'evento', 'tiempo', 'pcIp') "
				+ "VALUES " + "('" + item.getKeyUsuario() + "', '" + item.getKeyTarea() + "','" + item.getElemento()
				+ "', '" + item.getUrl() + "', '" + item.getEvento() + "', '" + item.getTiempo() + "', '"
				+ item.getPcIp() + "')";
	}

	private static String creaInsertTarea(Tarea item) {
		return "INSERT INTO datosTarea ('keyTarea', 'instrucciones', 'urlInicio', 'urlFinal', 'tiempo') " + "VALUES "
				+ "('" + item.getKeyTarea() + "', '" + item.getInstrucciones() + "','" + item.getUrlInicio() + "', '"
				+ item.getUrlFinal() + "', '" + item.getTiempo() + "')";
	}

	private static String creaInsertUsuario(Usuario user) {
		return "INSERT INTO datosUser ('keyUsuario', 'edad', 'sexo') " + "VALUES " + "('" + user.getKeyUsuario()
				+ "', '" + user.getEdad() + "','" + user.getSexo() + "')";
	}

	/**
	 * Devuelve una conexion con la BD
	 */

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbProxyMob");
		return conn;
	}

}
