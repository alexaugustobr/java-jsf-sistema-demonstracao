package com.tetrasoft.teste.repository;

import java.util.List;

import com.tetrasoft.teste.model.Cliente;

public interface Clientes {
		public List<Cliente> todos();
		public Cliente porCodigo(Integer codigo);
		public void deletar(Cliente cliente);
		public void guardar(Cliente cliente);
		public Long quantidadeDeRegistros();
		Cliente comEmailIgual(Cliente cliente);
		List<Cliente> porNomeEmail(Cliente cliente);
}
