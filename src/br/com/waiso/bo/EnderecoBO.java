package br.com.waiso.bo;

import br.com.waiso.dao.EnderecoDAO;
import br.com.waiso.entidades.Endereco;

public class EnderecoBO {

	private EnderecoDAO enderecoDAO;
	
	public void inserirEndereco(Endereco endereco) {
		getEnderecoDAO().inserir(endereco);
	}

	public EnderecoDAO getEnderecoDAO() {
		return enderecoDAO;
	}

	public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}
}
