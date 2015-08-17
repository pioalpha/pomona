package com.github.pomona.application.command.paciente;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.TipoCorPele;

public class AtualizarCorPeleDoPacienteCommand implements Command {
	private String planoAlimentarId;
	private TipoCorPele tipoCorPele;
	
	public AtualizarCorPeleDoPacienteCommand(String planoAlimentarId, TipoCorPele tipoCorPele) {
		super();
		this.planoAlimentarId = planoAlimentarId;
		this.tipoCorPele = tipoCorPele;
	}
	
	public String getPlanoAlimentarId() {
		return planoAlimentarId;
	}
	
	public TipoCorPele getTipoCorPele() {
		return tipoCorPele;
	}
	
}
