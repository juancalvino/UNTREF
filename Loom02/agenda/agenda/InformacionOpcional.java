package agenda;
/*
 * En este ejercicio no se pidio validar los datos ni los strings vacios.
 */

public class InformacionOpcional {

	private String piso;
	private String depto;
	private String partido;
	
	/**
	 * Pre: Para eliminar un valor se debe colocar NULL como paramentro.
	 * Post: Se le asigna un piso a 'piso'
	 */
	public void setPiso(String piso) {
		this.piso = piso;
	}

	/**
	 * Pre: Para eliminar un valor se debe colocar NULL como paramentro.
	 * Post: Se le asigna un depto a 'depto'	
	 */
	public void setDepto(String depto) {
		this.depto = depto;
	}
	
	/**
	 * Pre: Para eliminar un valor se debe colocar NULL como paramentro.
	 * Post: Se le asigna un partido a 'partido'	
	 */
	public void setPartido(String partido) {
		this.partido = partido;
	}

	/**
	 * Post: Devuelve un String con la informacion que se encuentra en 'informacionOpcional'
	 * 		Si 'informacioOpcional' es NULL devuelve "".
	 */
	
	public String toString() {
		
		String informacion = "";	
			
		if(piso != null)
			informacion+= "Piso:" + piso + "\n";
		
		if(depto != null)
			informacion+= "Depto:" + depto + "\n";
		
		if(partido!= null)
			informacion+= "Partido:" + partido + "\n";

		return informacion;
	}
}
