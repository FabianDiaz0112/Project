/**
 * 
 */
package com.edu.udistrital.beans;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Fabián Díaz González
 *
 */
public class DataBaseHelper {
	
	@PersistenceContext
	EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	   public List getList( String nombreQuery, Class c){
		   Query q = em.createNamedQuery(c.getSimpleName()+"."+nombreQuery);
		   return (List) q.getResultList();
	   }
	   
	   @SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	   public List getListParam( String nombreQuery, Class c, String nomParametro,String parametro){
		   Query q = em.createNamedQuery(c.getSimpleName()+"."+nombreQuery);
		   q.setParameter(nomParametro, parametro);
		   return (List) q.getResultList();
	   }
	   
	   @TransactionAttribute(TransactionAttributeType.REQUIRED)
	   public List getListParam2( String nombreQuery, Class c, String nomParametro,String parametro, String nomParametro2,String parametro2){
		   Query q = em.createNamedQuery(c.getSimpleName()+"."+nombreQuery);
		   q.setParameter(nomParametro, parametro);
		   q.setParameter(nomParametro2, parametro2);
		   return (List) q.getResultList();
	   }
	   
	   @TransactionAttribute(TransactionAttributeType.REQUIRED)
	   public Object getFindByParam( String nombreQuery, Class c, String nomParametro,String parametro){
		   Query q = em.createNamedQuery(c.getSimpleName()+"."+nombreQuery);
		   q.setParameter(nomParametro, parametro);
		   return q.getSingleResult();
	   }
	   
	   @TransactionAttribute(TransactionAttributeType.REQUIRED)
	   public Object getFindById( String id, Class c){
		   Object objeto = em.find(c, id);
		   return objeto;
	   }
	   @TransactionAttribute(TransactionAttributeType.REQUIRED)
	   public Object getFindById( BigDecimal id, Class c){
		   Object objeto = em.find(c, id);
		   return objeto;	
	   }
	   
	   @TransactionAttribute(TransactionAttributeType.REQUIRED)
	   public Object getFindById( Long id, Class c){
		   Object objeto = em.find(c, id);
		   return objeto;	
	   }
	   
	   @TransactionAttribute(TransactionAttributeType.REQUIRED)
	   public Object getFindById( Object id, Class c){
		   Object objeto = em.find(c, id);
		   return objeto;	
	   }
	   
	   @TransactionAttribute(TransactionAttributeType.REQUIRED)
	   public boolean guardar( Object objGuardar){
		   try{
			   em.persist(objGuardar);
			   return true;
		   }catch (Exception e) {
			   return false;
		   }
	   }
	   
	   @TransactionAttribute(TransactionAttributeType.REQUIRED)
	   public boolean modificar( Object objModificar){
		   try{		   
			   em.merge(objModificar);
			   return true;
		   }catch (Exception e) {
			   return false;
		   }	   
	   }
	   
	   @TransactionAttribute(TransactionAttributeType.REQUIRED)
	   public boolean eliminar( Object o, Class c){
		   try{		   
			   em.remove(em.merge(o));
			   return true;
		   }catch (Exception e) {
			   return false;
		   }	   
	   }
}
