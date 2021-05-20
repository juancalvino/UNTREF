
public class Cliente {

	private TipoCliente tipo;
	
	public Cliente(TipoCliente tipo) {
		this.tipo = tipo;
	}

	public TipoCliente getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		return getTipo().name();
	}
	
}
