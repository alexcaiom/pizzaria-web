package br.com.waiso.testes;

import java.util.List;

import org.junit.Test;

import br.com.waiso.bo.PessoaBO;
import br.com.waiso.dao.Classe;
import br.com.waiso.entidades.Pedido;
import br.com.waiso.entidades.Pessoa;

public class TestePessoaListagem extends Classe {

	@Test
	public void test() {
		listarPessoas();
	}
	
	private void listarPessoas() {
		PessoaBO pessoaBO = new PessoaBO();
		List<Pessoa> pessoas = pessoaBO.listarPessoas();
		
		if (existe(pessoas)) {
			for (Pessoa pessoa : pessoas) {
				System.out.println(pessoa.getNome());
				if (pessoa.getPedidos() != null) {
					for (Pedido p : pessoa.getPedidos()) {
						System.out.println(p.getDataPedido() + " - " + p.getDescricao());
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new TestePessoaListagem().listarPessoas();
	}
	
}
