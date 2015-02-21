package br.com.waiso.bo;

import java.util.List;

import br.com.waiso.dao.PessoaDAO;
import br.com.waiso.dao.finder.FinderPessoa;
import br.com.waiso.entidades.Pessoa;

public class PessoaBO {

	private PessoaDAO pessoaDAO = new PessoaDAO();
	private FinderPessoa pessoaFinder = new FinderPessoa();
	
	public void inserirPessoaFisica(Pessoa pessoa) {
		getPessoaDAO().inserir(pessoa);
	}
	
	public void inserirPessoaJuridica(Pessoa pessoa) {
		getPessoaDAO().inserir(pessoa);
	}
	
	public void atualizarPessoaJuridica(Pessoa pessoa) {
		getPessoaDAO().atualizar(pessoa);
		
	}
	
	public Pessoa pesquisarPessoaPorNomeEIdentificacao(String nome, Long identificacao) {
		return getPessoaFinder().pesquisarPessoaPorNomeEIdentificacao(nome, identificacao);
	}
	
	public List<Pessoa> listarPessoas(){
		return getPessoaDAO().listar();
	}

	public PessoaDAO getPessoaDAO() {
		return pessoaDAO;
	}

	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

	public FinderPessoa getPessoaFinder() {
		return pessoaFinder;
	}

	public void setPessoaFinder(FinderPessoa pessoaFinder) {
		this.pessoaFinder = pessoaFinder;
	}

}
