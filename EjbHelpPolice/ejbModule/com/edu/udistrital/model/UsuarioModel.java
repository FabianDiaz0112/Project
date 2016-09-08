package com.edu.udistrital.model;

import com.edu.udistrital.entity.Perfil;
import com.edu.udistrital.entity.Persona;

public class UsuarioModel {
	
	private String idusuario;

	private String contrase�a;

	private String descripcion;

	private Perfil perfil;

	private Persona persona;

	public UsuarioModel() {
		
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getContrase�a() {
		return this.contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
