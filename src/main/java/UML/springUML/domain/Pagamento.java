package UML.springUML.domain;

import java.io.Serializable;
import java.util.Objects;

import UML.springUML.domain.enums.EstadoPagamento;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public abstract class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer id;
	private EstadoPagamento situacao;
	@OneToOne private Pedido pedido;
	
	public Pagamento() {}

	public Pagamento(Integer id, EstadoPagamento situacao, Pedido pedido) {
		this.id = id;
		this.situacao = situacao;
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getSituacao() {
		return situacao;
	}
	public void setSituacao(EstadoPagamento situacao) {
		this.situacao = situacao;
	}

	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
