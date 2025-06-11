package UML.springUML.domain;

import UML.springUML.domain.enums.EstadoPagamento;

public class PagamentoCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer parcelas;
	
	public PagamentoCartao() {}

	public PagamentoCartao(Integer id, EstadoPagamento situacao, Pedido pedido, Integer parcelas) {
		super(id, situacao, pedido);
		this.parcelas = parcelas;
	}

	public Integer getParcelas() {
		return parcelas;
	}
	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	
}
