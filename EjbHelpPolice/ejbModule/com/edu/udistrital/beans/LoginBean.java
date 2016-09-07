package com.edu.udistrital.beans;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.edu.udistrital.entity.Perfil;
import com.edu.udistrital.entity.Usuario;
import com.edu.udistrital.model.PerfilModel;
import com.edu.udistrital.model.UsuarioModel;
import com.google.gson.Gson;

@Stateless
public class LoginBean {

	@PersistenceContext
	EntityManager em;
	
	public static final Gson gson = new Gson();
	
	public LoginBean(){
		
	}
	
	public String ingresarLogin(UsuarioModel usuarioModel){
		Query query = em.createNamedQuery("Usuario.findAll");
		List<Perfil> list = query.getResultList();
		String json = gson.toJson(usuarioModel);
		System.out.println(json);
		Usuario usuario = new Usuario();
		usuario = gson.fromJson(json, Usuario.class);
		System.out.println("perfil"+usuario.getDescripcion());
		return ""+json;
	}
	
}
