package com.github.pomona.domain.model;

import com.github.common.domain.model.AbstractId;

public class ClassificacaoIMCId extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7035480752855904878L;

	public ClassificacaoIMCId() {
		super();
	}

	public ClassificacaoIMCId(String umId) {
		super(umId);
	}

	@Override
	protected int hashValorImpar() {
		// TODO Auto-generated method stub
		return 57853;
	}

	@Override
	protected int hashValorPrimo() {
		// TODO Auto-generated method stub
		return 31;
	}
}
