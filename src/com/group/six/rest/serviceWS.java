package com.group.six.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.group.six.rest.db.JDBCQuery;
import com.group.six.rest.db.datos.Datos;

@Path(value = "/enviar")
public class serviceWS {

	@POST
	@Path("datos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean enviaPrepedidoBD(String datos) {
		boolean retorno;
		try {
			// Convertimos el JSON que nos llega a un objeto java
			ObjectMapper mapper = new ObjectMapper();
			Datos datosTabla = mapper.readValue(datos, Datos.class);
			retorno = JDBCQuery.insertar(datosTabla);
		} catch (Exception e) {
			retorno = false;
		}

		return retorno;
	}

}
