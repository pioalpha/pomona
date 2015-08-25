package com.github.pomona.application.dto;

import com.github.common.service.dto.DTO;

public class MedidaDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private String uuid;
	private String nome;

	public MedidaDTO(String uuid, String nome) {
		super();
		
		this.uuid = uuid;
		this.nome = nome;
	}

	public String getUuid() {
		return uuid;
	}

	public String getNome() {
		return nome;
	}

}
