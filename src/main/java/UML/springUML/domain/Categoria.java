package UML.springUML.domain;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String categoria;
	
	public Categoria() {}

	public Categoria(Integer id, String categoria) {
		this.id = id;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
}
