package br.com.waiso.dao;

import br.com.waiso.entidades.Produto;

public class ProdutoDAO extends GenericDAO<Produto> {

	private static final long serialVersionUID = 1L;

	public ProdutoDAO() {
		super(Produto.class);
	}

}
