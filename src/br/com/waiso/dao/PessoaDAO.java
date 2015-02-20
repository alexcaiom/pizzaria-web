package br.com.waiso.dao;

import br.com.waiso.entidades.Pessoa;


public class PessoaDAO extends GenericDAO<Pessoa> {

	private static final long serialVersionUID = 1L;

	public PessoaDAO() {
		super(Pessoa.class);
	}

}
