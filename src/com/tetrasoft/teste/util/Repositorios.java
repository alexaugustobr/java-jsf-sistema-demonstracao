package com.tetrasoft.teste.util;

import java.io.Serializable;

import org.hibernate.Session;

import com.tetrasoft.teste.repository.Clientes;
import com.tetrasoft.teste.repository.infra.ClientesHibernate;


public class Repositorios implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Session getSession(){
		return (Session) FacesUtil.getRequestAttribute("session");
	}
	
	
	public Clientes getClientes(){
		return new ClientesHibernate(this.getSession());
		
	}
	
}
