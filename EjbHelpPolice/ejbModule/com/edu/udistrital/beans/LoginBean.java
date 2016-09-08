package com.edu.udistrital.beans;


import java.util.List;

import javax.ejb.EJB;
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
	@EJB
	DataBaseHelper baseHelper;
	
	public static final Gson gson = new Gson();
	
	public LoginBean(){
		/*BeanConfig beanConfig = new BeanConfig();
		baseHelper = (DataBaseHelper) beanConfig.BeanConfigString(DataBaseHelper.class);*/
	}
	
	public String ingresarLogin(UsuarioModel usuarioModel){
		Usuario usuario = (Usuario) baseHelper.getFindById(usuarioModel.getIdusuario(), Usuario.class);
		Perfil pefil = (Perfil) baseHelper.getFindById(1, Perfil.class);
		/*Query query = em.createNamedQuery("Usuario.findAll");
		List<Perfil> list = query.getResultList();*/
		String json = gson.toJson(pefil);
		json = gson.toJson(usuario);
		System.out.println(json);
		usuarioModel = gson.fromJson(json, UsuarioModel.class);
		System.out.println("perfil "+usuarioModel.getPerfil().getDescPerfil());
		return ""+json;
	}
	
}
