package com.github.pomona.application.command.calculaIndiceMeta;

import com.github.common.service.command.Command;

public class CadastrarFatorAtividadeFisicaCommand implements Command {
	private String atividade;
	private float fator;

	public CadastrarFatorAtividadeFisicaCommand(String atividade, float fator) {
		super();
		this.atividade = atividade;
		this.fator = fator;
	}

	public String getAtividade() {
		return atividade;
	}

	public float getFator() {
		return fator;
	}

}
