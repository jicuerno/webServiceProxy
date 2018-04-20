package com.group.six.rest.db.datos;

import java.sql.Date;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Linea {
	private String codigo;
	private String element;
	private String url;
	private String event;
	private Date time;

	public Linea() {
		super();
	}

	public Linea(String codigo, String element, String url, String event, Date time) {
		super();
		this.codigo = codigo;
		this.element = element;
		this.url = url;
		this.event = event;
		this.time = time;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setTime(String time) {
		this.time = new Date(Long.parseLong(time));
	}
}
