package cerraduraConCombinacion;

public class CerraduraConCombinacion {

	private Combinacion clave;
	private boolean abierto;

	public CerraduraConCombinacion(int clave) {

		this.clave = new Combinacion(clave);
		this.abierto = false;
	}

	public void abrirCerradura(int clave) {
		abierto = this.clave.validadClave(clave);
	}

	public void cerrarCerradura() {
		abierto = false;
	}

	public void cambiarCombinacion(int claveAntiguna, int claveNueva) {
		this.clave.cambiarClave(claveAntiguna, claveNueva);
	}

	public boolean isAbierto() {
		return abierto;
	}
}
