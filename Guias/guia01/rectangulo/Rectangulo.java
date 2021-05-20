package rectangulo;

public class Rectangulo {
	private int posicionX;
	private int posicionY;
	private int ancho;
	private int alto;


	public Rectangulo(int ancho, int alto){
		verificarPositividad(ancho,alto);
		
		this.posicionX = 0;
		this.posicionY = 0;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	/**
	 * pre: 'ancho' y 'alto' deben ser mayor que 0 
	 * post: crea un rectangulo en la posicion (posicionX, posicionY) 
	 * de alto ['alto'] y largo ['largo']
	 */
	public Rectangulo(int posicionX, int posicionY, int ancho, int alto) {
	
		verificarPositividad(ancho, alto);
		
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	
	/**
	 * pre:
	 * @param ancho
	 * @param alto
	 * post: arroja una excepcion si el 'alto' o el 'ancho'son menores que 1.
	 */
	
	private void verificarPositividad(int ancho, int alto) {
		if(ancho <1 || alto <1)
			throw new Error("El ancho y alto deben ser mayores que 0");
	}

	
	public int calcularArea() {
		return ancho*alto;
	}

	public String devolverPosicion() {
		return "("+posicionX +","+ posicionY+")";
	}


	public void cambiarDePosicion(int posicionX, int posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	public boolean contieneElPunto(int posicionX, int posicionY) {
		return (posicionX >= this.posicionX && posicionX <=this.posicionX + ancho) &&
					(posicionY >= this.posicionY  && posicionY <= this.posicionY + alto);
	}
	

	
}
