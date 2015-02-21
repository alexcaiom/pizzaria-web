package br.com.waiso.testes;

import java.util.List;

import org.junit.Test;

import br.com.waiso.bo.PessoaBO;
import br.com.waiso.bo.ProdutoBO;
import br.com.waiso.dao.Classe;
import br.com.waiso.entidades.Pessoa;
import br.com.waiso.entidades.Produto;

public class TesteProdutoListagem extends Classe {

	@Test
	public void test() {
//		fail("Not yet implemented");
		
//		listarProdutosPorPessoa("La Gondola", 11111111000102l);
		
		listaProdutos();
	}


	private void listarProdutosPorPessoa(String nome, long identificacao) {
		/*String nome = "La papini";
		Long identificacao = 11111111000101l;*/
		PessoaBO pessoaBO = new PessoaBO();
		Pessoa pessoa = pessoaBO.pesquisarPessoaPorNomeEIdentificacao(nome, identificacao);
		if (existe(pessoa)) {
			for (Produto p : pessoa.getProdutos()) {
				System.out.println(p.getNome() + " - R$ " + p.getPreco().doubleValue());
			}
		}
	}

	private void listaProdutos() {
		ProdutoBO produtoBO = new ProdutoBO();
		List<Produto> lista = produtoBO.listar();
		for (Produto produto : lista) {
			System.out.println(produto.getPessoa().getNome() + " - " + produto.getDescricao() + " - R$" + produto.getPreco());
		}
		
	}
}
