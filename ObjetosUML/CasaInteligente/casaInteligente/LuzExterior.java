package casaInteligente;

public class LuzExterior extends Luz{
	
	protected String tipo;

	public LuzExterior(String nombre, int intensidad) {
		super(nombre, intensidad);
		this.tipo = "Secundaria";

	}

}
