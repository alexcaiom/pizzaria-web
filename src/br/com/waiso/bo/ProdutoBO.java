package br.com.waiso.bo;

import br.com.waiso.dao.ProdutoDAO;
import br.com.waiso.entidades.Produto;

public class ProdutoBO {

	private ProdutoDAO produtoDAO;
	
	public void inserirProduto(Produto produto) {
		getProdutoDAO().inserir(produto);
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}
	
}
