package com.tetrasoft.teste.service;


import com.tetrasoft.teste.model.Cliente;
import com.tetrasoft.teste.repository.Clientes;

import com.tetrasoft.teste.service.RegraNegocioException;


public class GestaoClientes {

	private Clientes Clientes;
	private Cliente ClienteSelecionado;

	public Cliente getClienteSelecionado() {
		return ClienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		ClienteSelecionado = clienteSelecionado;
	}

	public GestaoClientes(Clientes Clientes) {
		this.Clientes = Clientes;
	}


	public void salvar(Cliente cliente) throws RegraNegocioException {
		if (this.comEmailIgual(cliente)) {
			throw new RegraNegocioException("Já existe um cliente com esse email! Favor escolha outro email!");
		} else {
			this.Clientes.guardar(cliente);
		}
	}

	private boolean comEmailIgual(Cliente cliente) {
		Cliente clienteComEamilIgual = Clientes.comEmailIgual(cliente);
		if (clienteComEamilIgual != null) {
			if (clienteComEamilIgual.getCodigo() == cliente.getCodigo()) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public boolean clienteExiste(Cliente cliente) {
		ClienteSelecionado = this.Clientes.porCodigo(cliente.getCodigo());

		if (ClienteSelecionado == null) {
			return false;
		} else {
			return true;
		}

	}

}
