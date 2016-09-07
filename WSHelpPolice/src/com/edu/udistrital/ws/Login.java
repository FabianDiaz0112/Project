package com.edu.udistrital.ws;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.edu.udistrital.beans.LoginBean;
import com.edu.udistrital.model.PerfilModel;
import com.edu.udistrital.model.UsuarioModel;
import com.edu.udistrital.resource.BeanConfig;

@Path("/User")
public class Login {
	
	@EJB
	LoginBean prueba;
	//PruebaEJB prueba;
	
	public Login() {
	    BeanConfig beanConfig = new BeanConfig();
	    prueba = (LoginBean) beanConfig.BeanConfigString(LoginBean.class);
	  
	  }

	@GET
	@Path("/getUser")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUser(@QueryParam("idUsuario") final String idUsuario, @QueryParam("pass") final String password){
		System.out.println("Ususario "+idUsuario+" Pass "+password);
		UsuarioModel usuarioModel = new UsuarioModel();
		usuarioModel.setContraseña(password);
		usuarioModel.setDescripcion(idUsuario);
		return "Hello world "+prueba.ingresarLogin(usuarioModel);
	}
}
