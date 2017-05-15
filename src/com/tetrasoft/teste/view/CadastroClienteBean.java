package com.tetrasoft.teste.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.tetrasoft.teste.model.Cliente;
import com.tetrasoft.teste.repository.Clientes;
import com.tetrasoft.teste.service.GestaoClientes;
import com.tetrasoft.teste.service.RegraNegocioException;
import com.tetrasoft.teste.util.Repositorios;


import util.string.FormatarString;


@ManagedBean
@ViewScoped
public class CadastroClienteBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Cliente cliente = new Cliente();
	private Repositorios repositorios = new Repositorios();
	

	public void setCliente(Cliente cliente) throws CloneNotSupportedException {
		if(cliente==null){
			this.cliente = new Cliente();
		} else {
			this.cliente = (Cliente) cliente.clone();
		}
		
	}
	
	public boolean isEditando(){ 
		if (this.cliente.getCodigo()!=null){
			return true;
		} else {
			return false;
		}
	}
	
	
	public void cadastrar() {
		Clientes clientesRep = repositorios.getClientes();
		//clientesRep.guardar(this.cliente);
		GestaoClientes gestaoClientes = new GestaoClientes(clientesRep);
		
		try {
			cliente.setNome(FormatarString.removerEspacosDuplicados(cliente.getNome()));
			cliente.setEmail(cliente.getEmail().toLowerCase());
			gestaoClientes.salvar(cliente);
			String msg;
			if (isEditando()){
				msg = "Alterações no cadastro do cliente foram salvas!";
			} else {
				msg = "Cadastro de Cliente efetuado com sucesso!";
			}
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
			this.cliente = new Cliente();
		} catch (RegraNegocioException e) {
			String msg = e.getMessage();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
	}
	
	public Cliente getCliente() {
		return cliente;
	}
}
