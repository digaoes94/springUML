package UML.springUML.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer id;
	private String nome;
	
	@JsonManagedReference @ManyToMany(mappedBy="categorias")
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Categoria() {}

	public Categoria(Integer id, String categoria) {
		this.id = id;
		this.nome = categoria;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoria() {
		return nome;
	}
	public void setCategoria(String categoria) {
		this.nome = categoria;
	}
	
	public List<Produto> getProdutos() {return produtos;}
	public void setProdutos(List<Produto> produtos) {this.produtos = produtos;}

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
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}

	
}
