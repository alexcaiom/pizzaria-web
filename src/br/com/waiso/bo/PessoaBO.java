package br.com.waiso.bo;

import br.com.waiso.dao.PessoaDAO;
import br.com.waiso.entidades.Pessoa;

public class PessoaBO {

	private PessoaDAO pessoaDAO = new PessoaDAO();
	
	public void inserirPessoaFisica(Pessoa pessoa) {
		getPessoaDAO().inserir(pessoa);
	}

	public PessoaDAO getPessoaDAO() {
		return pessoaDAO;
	}

	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}
}
