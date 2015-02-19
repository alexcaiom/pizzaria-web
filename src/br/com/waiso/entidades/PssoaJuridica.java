package br.com.waiso.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tbl_pessoa_juridica")
@PrimaryKeyJoinColumn(name="id_pessoa")
public class PssoaJuridica extends Pessoa 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pessoa_juridica")
	private Long id;
	
	@Column(name="nomeFantasia")
	private String nomeFantasia;
	
	@Column(name="razaoSocial")
	private String razaoSocial;
	
	@Column(name="cnpj")
	private Integer cnpj;

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getNomeFantasia() 
	{
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) 
	{
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() 
	{
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) 
	{
		this.razaoSocial = razaoSocial;
	}

	public Integer getCnpj() 
	{
		return cnpj;
	}

	public void setCnpj(Integer cnpj) 
	{
		this.cnpj = cnpj;
	}
}