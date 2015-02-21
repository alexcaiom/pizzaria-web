package br.com.waiso.testes;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.waiso.bo.PessoaBO;
import br.com.waiso.bo.ProdutoBO;
import br.com.waiso.entidades.Pessoa;
import br.com.waiso.entidades.Produto;

public class TesteProdutoInsercao {
	
	@Test
	public void test(){
		inserirProduto();
	}

	public static void main(String[] args) {
		new TesteProdutoInsercao().inserirProduto();
	}
	
	private void inserirProduto() {
		String nome = "La Gondola";
		Long identificacao = 11111111000102l;
		PessoaBO pessoaBO = new PessoaBO();
		Pessoa pessoa = pessoaBO.pesquisarPessoaPorNomeEIdentificacao(nome, identificacao);
		Produto produto = new Produto();
		produto.setCategoria("Pizza");
		produto.setDescricao("Pizza de Atum");
		produto.setNome("Pizza de Atum");
		produto.setPessoa(pessoa);
		produto.setPreco(new BigDecimal(35.9));
		produto.setSubCategoria("Massas");
		
		produto = new ProdutoBO().inserirProduto(produto);
		pessoa.getProdutos().add(produto);
		pessoaBO.atualizarPessoaJuridica(pessoa);
	}
	

}
