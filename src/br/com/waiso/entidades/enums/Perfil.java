package br.com.waiso.entidades.enums;

public enum Perfil {
	
	PESSOA_FISICA(1), PESSOA_JURIDICA(2);
	
	private final Integer perfil;
	
	private Perfil(Integer perfil) {
		this.perfil = perfil;
	}

	public Integer getPerfil() {
		return perfil;
	}
}
