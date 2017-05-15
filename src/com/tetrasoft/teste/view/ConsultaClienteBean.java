package com.tetrasoft.teste.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;

import com.tetrasoft.teste.model.Cliente;
import com.tetrasoft.teste.repository.Clientes;
import com.tetrasoft.teste.util.FacesUtil;
import com.tetrasoft.teste.util.Repositorios;


@ManagedBean
@ViewScoped
public class ConsultaClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private Cliente clienteSelecionado = new Cliente();
	private Cliente clientePesquisa = new Cliente();
	private Repositorios repositorios = new Repositorios();
	Clientes clientesRep = this.repositorios.getClientes();
	
	@PostConstruct
	private void init(){
		this.carregarTabela();
	}
	
	public void pesquisarEventoEmail(ValueChangeEvent event) {
		clientePesquisa.setEmail((String) event.getNewValue());
		pesquisar();
		FacesContext.getCurrentInstance().renderResponse();
		
	}
	
	public void pesquisarEventoNome(ValueChangeEvent event) {
		clientePesquisa.setNome((String) event.getNewValue());
		pesquisar();
		FacesContext.getCurrentInstance().renderResponse();
		
	}

	public void carregarTabela() {
		Clientes clientesRep = this.repositorios.getClientes();
		int totalPaginas = clientesRep.quantidadeDeRegistros().intValue();
		if (totalPaginas > 0) {
			this.clientes = clientesRep.todos();
		} else {
			clientes.clear();
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,
					"Nenhum cliente encontrado, por favor refaça sua consulta!",
					"Nenhum cliente encontrado, por favor refaça sua consulta!");
		}
	}
	
	public void pesquisar() {
		clientes.clear();
			clientes=clientesRep.porNomeEmail(clientePesquisa);
			if (clientes.isEmpty()){
				FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,
						"Não a Clientes para serem exibidos!",
						"Não a Clientes para serem exibidos!");
			}
			
		}
		public void pesquisar2() {
			clientes.clear();
			if(clientePesquisa.getNome().equals("")&&clientePesquisa.getEmail().equals("")){
				FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,
						"Insira nome ou email para pesquisar os Clientes!",
						"Insira nome ou email para pesquisar os Clientes!");
			} else {
				clientes=clientesRep.porNomeEmail(clientePesquisa);
				if (clientes.isEmpty()){
					FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,
							"Não a Clientes para serem exibidos!",
							"Não a Clientes para serem exibidos!");
				}
				
			}
		
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public Repositorios getRepositorios() {
		return repositorios;
	}

	public void setRepositorios(Repositorios repositorios) {
		this.repositorios = repositorios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cliente getClientePesquisa() {
		return clientePesquisa;
	}

	public void setClientePesquisa(Cliente clientePesquisa) {
		this.clientePesquisa = clientePesquisa;
	}
}
