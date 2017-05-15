package com.tetrasoft.teste.repository.infra;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tetrasoft.teste.model.Cliente;
import com.tetrasoft.teste.repository.Clientes;


public class ClientesHibernate implements Clientes, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Session session;
	
	public ClientesHibernate(Session session){
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> todos() {
		return session.createCriteria(Cliente.class)
				.addOrder(Order.asc("nome"))
				.list();
	}

	@Override
	public Cliente porCodigo(Integer codigo) {
		return (Cliente) session.get(Cliente.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> porNomeEmail(Cliente cliente) {
		return session.createCriteria(Cliente.class)
				.add(Restrictions.ilike("email", cliente.getEmail(), MatchMode.ANYWHERE))
				.add(Restrictions.ilike("nome", cliente.getNome(), MatchMode.ANYWHERE))
				.list();
	}
	
	@Override
	public Cliente comEmailIgual(Cliente cliente) {
			return (Cliente) this.session.createCriteria(Cliente.class)
					.add(Restrictions.ilike("email", cliente.getEmail()))
					.uniqueResult();
		
	}

	@Override
	public void deletar(Cliente cliente) {
		session.delete(cliente);
	}

	@Override
	public void guardar(Cliente cliente) {
		session.merge(cliente);
	}
	

	
	public Long quantidadeDeRegistros() {
		Long numLinhasTotalTabela = (Long) session
		.createCriteria(Cliente.class)
		.setProjection(Projections.rowCount())
		.uniqueResult();
		return numLinhasTotalTabela;
		
	}
	
	

}
