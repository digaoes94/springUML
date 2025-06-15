package UML.springUML.domain.pk;

import java.io.Serializable;
import java.util.Objects;

import UML.springUML.domain.Pedido;
import UML.springUML.domain.Produto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ItemPedidoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	@ManyToOne @JoinColumn(name="produto_id")
	private Produto prod;
	
	public ItemPedidoPK(Pedido pedido, Produto prod) {
		this.pedido = pedido;
		this.prod = prod;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Produto getProd() {
		return prod;
	}
	public void setProd(Produto prod) {
		this.prod = prod;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(pedido, prod);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoPK other = (ItemPedidoPK) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(prod, other.prod);
	}
	
	
}
