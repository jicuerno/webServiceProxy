package com.group.six.rest.db.datos;

public class Usuario {
	String keyUsuario;
	Integer edad;
	String sexo;

	public Usuario() {
		super();
	}

	public Usuario(String keyUsuario, Integer edad, String sexo) {
		super();
		this.keyUsuario = keyUsuario;
		this.edad = edad;
		this.sexo = sexo;
	}

	public String getKeyUsuario() {
		return keyUsuario;
	}

	public void setKeyUsuario(String keyUsuario) {
		this.keyUsuario = keyUsuario;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
