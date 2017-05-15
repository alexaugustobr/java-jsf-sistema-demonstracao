package com.tetrasoft.teste.validator;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

import util.string.FormatarString;

@FacesValidator("com.tetrasoft.teste.validator.Endereco")
public class EnderecoValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		String nome = (String) value;
		if (nome != null) {
			nome=(FormatarString.removerEspacosDuplicados(nome));
			if (nome.isEmpty() || nome.equalsIgnoreCase(" ") || nome.equalsIgnoreCase("  +")){
				Object label = MessageFactory.getLabel(context, component);
				
				String descricaoErro = label + "O Endereço não pode estar vazio.";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						descricaoErro, descricaoErro);
				throw new ValidatorException(message);
			}
			
		}
	}

}