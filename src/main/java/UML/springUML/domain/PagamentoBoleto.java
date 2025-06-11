package UML.springUML.domain;

import java.time.LocalDate;

import UML.springUML.domain.enums.EstadoPagamento;

public class PagamentoBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private LocalDate geracao;
	private LocalDate vencimento;
	private LocalDate pagamento;
	
	public PagamentoBoleto() {}

	public PagamentoBoleto(Integer id, EstadoPagamento situacao, Pedido pedido) {
		super(id, situacao, pedido);
		this.geracao = LocalDate.now();
		this.vencimento = this.geracao.plusDays(7);
		this.pagamento = this.vencimento;
	}

	public LocalDate getGeracao() {
		return geracao;
	}
	public void setGeracao(LocalDate geracao) {
		this.geracao = geracao;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}
	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}

	public LocalDate getPagamento() {
		return pagamento;
	}
	public void setPagamento(LocalDate pagamento) {
		this.pagamento = pagamento;
	}

	
	
}
