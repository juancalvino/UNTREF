package cerraduraConCombinacion;

public class Combinacion {
	private int clave;
	
	
	public Combinacion(int clave){
		verificarLogitud(clave);
		this.clave = clave;
	}

	private void verificarLogitud(int clave) {
		if(clave <0 || clave>999) {
			throw new Error("Deben ser 3 la cantidad de digitos ingresados");
		}
	}
	
	public boolean validadClave(int clave) {	
		if(!(this.clave == clave))
			throw new Error("La clave no es correcta");
		
		return true;
	}
	
	public void cambiarClave(int claveAntiguna, int claveNueva) {
		validadClave(claveAntiguna);
		clave = claveNueva;
	}
}
