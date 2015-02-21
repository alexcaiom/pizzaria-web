package br.com.waiso.bo;

import java.util.List;

import br.com.waiso.dao.ProdutoDAO;
import br.com.waiso.dao.finder.FinderProduto;
import br.com.waiso.entidades.Pessoa;
import br.com.waiso.entidades.Produto;

public class ProdutoBO {

	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private FinderProduto produtoFinder = new FinderProduto();
	
	public Produto inserirProduto(Produto produto) {
		return getProdutoDAO().inserir(produto);
	}
	
	public Produto pesquisarPorNome(String nomeDoProduto, Pessoa pessoa) {
		return getProdutoFinder().pesquisarPorNome(nomeDoProduto, pessoa);
	}
	

	public List<Produto> listar() {
		return getProdutoFinder().listar();
		
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	public FinderProduto getProdutoFinder() {
		return produtoFinder;
	}

	public void setProdutoFinder(FinderProduto produtoFinder) {
		this.produtoFinder = produtoFinder;
	}

	
}
