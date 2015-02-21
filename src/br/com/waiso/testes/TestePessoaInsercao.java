package br.com.waiso.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import br.com.waiso.bo.PessoaBO;
import br.com.waiso.entidades.Pessoa;
import br.com.waiso.entidades.enums.Perfil;
import br.com.waiso.utils.DateUtils;

public class TestePessoaInsercao {

	@Test
	public void test() {
		inserirPessoaJuridica();
	}
	
	private void inserirPessoaFisica() {

		Calendar dataAtual = new GregorianCalendar();
		System.out.println(DateUtils.getInstance().calendarToInteger(dataAtual));
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Fabiano");
		pessoa.setSobrenome("Matias");
		pessoa.setIdentificacao(11111111111l);
		pessoa.setTelefone("(011) 3111 1111");
		pessoa.setCelular("(011) 91111 1111");
		pessoa.setEmail("fabiano@waiso.com.br");
		pessoa.setSenha("fabiano");
		pessoa.setPerfil(Perfil.PF);
		
		PessoaBO pessoaBO = new PessoaBO();
		pessoaBO.inserirPessoaFisica(pessoa);
	}
	
	private void inserirPessoaJuridica() {

		Calendar dataAtual = new GregorianCalendar();
		System.out.println(DateUtils.getInstance().calendarToInteger(dataAtual));
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("La Gondola");
		pessoa.setSobrenome("Pizzas");
		pessoa.setIdentificacao(11111111000102l);
		pessoa.setTelefone("(011) 4111 1112");
		pessoa.setCelular("(011) 91111 1112");
		pessoa.setEmail("contato@lagondola.com.br");
		pessoa.setSenha("lagondola");
		pessoa.setPerfil(Perfil.PJ);
		
		PessoaBO pessoaBO = new PessoaBO();
		pessoaBO.inserirPessoaJuridica(pessoa);
	}
	
}
