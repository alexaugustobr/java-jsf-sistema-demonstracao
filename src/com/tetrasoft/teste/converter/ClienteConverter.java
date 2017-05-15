package com.tetrasoft.teste.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import com.tetrasoft.teste.util.FacesUtil;
import com.tetrasoft.teste.util.HibernateUtil;
import com.tetrasoft.teste.util.Repositorios;
import com.tetrasoft.teste.model.Cliente;
import com.tetrasoft.teste.repository.Clientes;


@FacesConverter(forClass=Cliente.class)
public class ClienteConverter implements Converter {
	private Repositorios repositorios = new Repositorios();
	//busca na lista de clientes com base no value = codigo da cliente
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;
		
		if (value != null && !value.equals("")) {
			Clientes clientes = repositorios.getClientes();
			retorno = clientes.porCodigo(new Integer(value));
			if(retorno==null){
				String descricaoErro = "Cliente não existe.";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,descricaoErro,descricaoErro);
				throw new ConverterException(message);
			}
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			//metodo antigo não funciona quando  usado via parametro
			//ao tentar salvar o objeto na tela da erro
			//return ((Lancamento) value).getCodigo().toString();
			//return ((Cliente) value).getCodigo().toString();
			Integer codigo =((Cliente) value).getCodigo();
			return codigo == null  ? "":codigo.toString();
		}
		return null;
	}

}