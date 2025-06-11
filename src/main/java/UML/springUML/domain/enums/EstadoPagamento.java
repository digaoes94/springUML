package UML.springUML.domain.enums;

public enum EstadoPagamento {
	PENDENTE(1, "Esperando pagamento"),
	AGUARDANDO_CONFIRMACAO(2, "Aguardando a liberação do banco"),
	CONFIRMADO(3, "Pagamento confirmado"),
	CANCELADO(4, "Pedido cancelado pelo(a) cliente");
	
	private Integer cod;
	private String descricao;
	
	private EstadoPagamento(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {return cod;}
	public String getDescricao() {return descricao;}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}

		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id " + cod + " é inválido.");
	}
}
