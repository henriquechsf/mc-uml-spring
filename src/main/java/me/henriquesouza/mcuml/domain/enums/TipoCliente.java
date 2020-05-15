package me.henriquesouza.mcuml.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), 
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	// construtor de tipo enumerado deve ser private
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	// tipo enum deve usar somente get
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	// recebe um cod e retorna objeto TipoCliente ja instanciado conforme o cod
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
