package UML.springUML.domain.enums;

public enum TipoCliente {
	CPF(1, "Pessoa Física"),
	CPJ(2, "Pessoa Jurídica");
	
	private Integer cod;
	private String tipo;
	
	private TipoCliente(Integer cod, String tipo) {
		this.cod = cod;
		this.tipo = tipo;
	}

	public int getCod() {
		return cod;
	}
	public String getTipo() {
		return tipo;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}

		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id " + cod + " é inválido.");
	}
}