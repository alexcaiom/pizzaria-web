package br.com.waiso.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import br.com.waiso.bo.PessoaBO;
import br.com.waiso.entidades.Pessoa;
import br.com.waiso.entidades.enums.Perfil;
import br.com.waiso.utils.DateUtils;

public class TesteInsercao {

	@Test
	public void test() {
		inserirPessoa();
	}
	
	private void inserirPessoa() {

		Calendar dataAtual = new GregorianCalendar();
		System.out.println(DateUtils.getInstance().calendarToInteger(dataAtual));
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Fabiano");
		pessoa.setSobrenome("Matias");
		pessoa.setIdentificacao("111.111.111-11");
		pessoa.setTelefone("(011) 3111 1111");
		pessoa.setCelular("(011) 91111 1111");
		pessoa.setEmail("fabiano@waiso.com.br");
		pessoa.setSenha("fabiano");
		pessoa.setPerfil(Perfil.PESSOA_FISICA);
		
		PessoaBO pessoaBO = new PessoaBO();
		pessoaBO.inserirPessoaFisica(pessoa);
	}
	
}
