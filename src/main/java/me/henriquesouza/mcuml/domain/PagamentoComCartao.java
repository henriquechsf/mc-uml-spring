package me.henriquesouza.mcuml.domain;

import javax.persistence.Entity;

import me.henriquesouza.mcuml.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	// subclasse não precisa implementar Serializable
	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	

}
