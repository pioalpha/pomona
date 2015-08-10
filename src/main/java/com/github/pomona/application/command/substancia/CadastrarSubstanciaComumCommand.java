package com.github.pomona.application.command.substancia;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.UnidadeSubstancia;

public class CadastrarSubstanciaComumCommand implements Command {
	private String nome;
	private UnidadeSubstancia unidadeSubstancia;
	
	public CadastrarSubstanciaComumCommand(String nome, UnidadeSubstancia unidadeSubstancia) {
		super();
		this.nome = nome;
		this.unidadeSubstancia = unidadeSubstancia;
	}
	
	public String getNome() {
		return nome;
	}
	
	public UnidadeSubstancia getUnidadeSubstancia() {
		return unidadeSubstancia;
	}
	
}
