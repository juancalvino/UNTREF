package casaInteligente;

public class LuzExteriorPrincipal extends LuzExterior {

	public LuzExteriorPrincipal(String nombre, int intensidad) {
		super(nombre, intensidad);
		this.tipo = "Principal";
	}
	
	@Override
	public void apagarAutomatico() {
		System.out.println("La " + this.getClass().getSimpleName() + " de " + this.nombre + " NO SE APAGA");
	}
}
