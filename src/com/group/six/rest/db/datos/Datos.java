package com.group.six.rest.db.datos;

import java.util.ArrayList;

public class Datos {
	private ArrayList<Linea> lineas = null;

	public Datos() {
		super();
	}

	public Datos(ArrayList<Linea> lineas) {
		super();
		this.lineas = lineas;
	}

	public ArrayList<Linea> getLineas() {
		return lineas;
	}

	public void setLineas(ArrayList<Linea> lineas) {
		this.lineas = lineas;
	}

}
