package UML.springUML.domain;

import java.io.Serializable;
import java.util.Objects;

import UML.springUML.domain.pk.ItemPedidoPK;
import jakarta.persistence.Id;

public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id private ItemPedidoPK id = new ItemPedidoPK();
	private Double preco, subtotal;
	private Integer qtd;
	
	public ItemPedido() {}
	
	public ItemPedido(Pedido pedido, Produto prod, Integer qtd, Double desc) {
		id.setPedido(pedido);
		id.setProd(prod);
		this.preco = prod.getPreco();
		this.qtd = qtd;
		this.subtotal = preco * qtd * (1.0 - desc);
	}

	public ItemPedidoPK getId() {
		return id;
	}
	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public Produto getProduto() {
		return id.getProd();
	}
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getQtd() {
		return qtd;
	}
	public void setQtd(Integer qtd) {
		this.qtd = qtd;
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
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
}