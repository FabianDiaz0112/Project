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

@Path("/login")
public class Login {
	
	@EJB
	LoginBean prueba;
	//PruebaEJB prueba;
	
	public Login() {
	    try {
	        //String lookupName = "java:global/FirstRestWebService/PruebaEJB!com.edu.udistrital.ejb.PruebaEJB";
	        String lookupName = "java:global/WSHelpPolice/LoginBean!com.edu.udistrital.beans.LoginBean";
	        //prueba = (PruebaEJB) InitialContext.doLookup(lookupName);
	        prueba = (LoginBean) InitialContext.doLookup(lookupName);
	    } catch (NamingException e) {
	        e.printStackTrace();
	    }
	  }

	@GET
	@Path("/getLogin")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(@QueryParam("idUsuario") final String idUsuario, @QueryParam("pass") final String password){
		System.out.println("Ususario "+idUsuario+" Pass "+password);
		UsuarioModel usuarioModel = new UsuarioModel();
		
		return "Hello world "/*+prueba.ingresarLogin(usuarioModel)*/;
	}
}
