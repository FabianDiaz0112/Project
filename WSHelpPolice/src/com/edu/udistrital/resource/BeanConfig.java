/**
 * 
 */
package com.edu.udistrital.resource;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.edu.udistrital.beans.LoginBean;

/**
 * @author Fabián Díaz González
 *
 */
public class BeanConfig {

	/**
	 * 
	 */
	public Object BeanConfigString(Class c) {
		String lookupName = "java:global/WSHelpPolice/"+c.getSimpleName()+"!"+c.getName();
		try {
			return InitialContext.doLookup(lookupName);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
