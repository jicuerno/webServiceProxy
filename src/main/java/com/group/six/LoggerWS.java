package com.group.six;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.datos.Datos;
import com.db.JDBCQuery;

@Path("enviar")
public class LoggerWS {

	private static Logger logger = Logger.getLogger(LoggerWS.class);

	@GET
	@Path("hola")
	@Produces("text/html")
	public String getHtml() {
		logger.debug("##### hola ######");
		return "<html lang=\"es\"><body><h1>Servicio operativo</h1></body></html>";
	}

	@POST
	@Path("usuarios")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertaUsuarios(String datos) {
		boolean retorno;
		try {
			// Convertimos el JSON que nos llega a un objeto java
			ObjectMapper mapper = new ObjectMapper();
			Datos datosTabla = mapper.readValue(datos, Datos.class);
			logger.debug("##### Usuarios (" + datosTabla.toString() + ") ######");

			retorno = JDBCQuery.insertarUsuarios(datosTabla);
		} catch (Exception e) {
			retorno = false;
		}

		return retorno ? "isOk" : "noOk";
	}

	@POST
	@Path("tareas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertaTareas(String datos) {
		boolean retorno;
		try {
			// Convertimos el JSON que nos llega a un objeto java
			ObjectMapper mapper = new ObjectMapper();
			Datos datosTabla = mapper.readValue(datos, Datos.class);
			logger.debug("##### Tareas (" + datosTabla.toString() + ") ######");
			retorno = JDBCQuery.insertarTareas(datosTabla);
		} catch (Exception e) {
			retorno = false;
		}

		return retorno ? "isOk" : "noOk";
	}

	@POST
	@Path("lineas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String enviaPrepedidoBD(String datos) {
		boolean retorno;
		try {
			// Convertimos el JSON que nos llega a un objeto java
			ObjectMapper mapper = new ObjectMapper();
			Datos datosTabla = mapper.readValue(datos, Datos.class);
			logger.debug("##### Lineas (" + datosTabla.toString() + ") ######");
			retorno = JDBCQuery.insertarLineas(datosTabla);
		} catch (Exception e) {
			retorno = false;
		}
		return retorno ? "isOk" : "noOk";
	}
}
