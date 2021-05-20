package agenda;
/*
	En este ejercicio no se pidio validar los datos ni los strings vacios.
	Esta clase se utilizara en principio para almacenar Emails y Telefonos los cules no seran validados ya que el ejercicio no lo solicita
	Entendimos que tanto Telefono e Email ambos deben tener de forma obligatoria 'contacto' y 'tipo' 
*/

public class ViaDeContacto {
	
	private String contacto;
	private String tipoDeContacto;
	

	/**
	 * Pre: 'contacto' y 'tipoDeContacto' no debe ser NULL
	 * Post: ViaDeContacto queda preparado para guardar contacto y tipo de contacto.
	 */
	public ViaDeContacto(String contacto, String tipoDeContacto) {
		this.contacto = verificarAusenciaNull(contacto);
		this.tipoDeContacto = verificarAusenciaNull(tipoDeContacto);
	}

	/**
	 * Pre: contacto no debe ser NULL.
	 * Post: guarda en 'contacto' el dato contacto.
	 */
	public void setContacto(String contacto) {
		this.contacto = verificarAusenciaNull(contacto);
	}

	/**
	 * Pre: contacto no debe ser NULL.
	 * Post: guarda el dato en 'tipoDeContacto'
	 */
	public void setTipoDeContacto(String tipoDeContacto) {
		this.tipoDeContacto = verificarAusenciaNull(tipoDeContacto);
	}
	
	/**
	 * Pre: contacto no debe ser NULL.
	 * Post: guarda contacto en 'contacto' y tipoDeDato en 'tipoDeContacto'
	 */
	public void setContactoYTipo(String contacto, String tipoDeContacto) {
		this.contacto = verificarAusenciaNull(contacto);
		this.tipoDeContacto = verificarAusenciaNull(tipoDeContacto);
	}
	
	/**
	 * Post: devuelve un String con el 'contacto' y con 'tipoDeContacto' si existe
	 */
	public String toString() {
		 return contacto +"\nTipo:" + tipoDeContacto;
	}
	
	/**
	 * Post: devuelve el dato ingresado si este no es NULL, sino devuelve una excepcion.
	 */
	private String verificarAusenciaNull(String info) {
		if(info == null)
			throw new Error("Es obligatorio la existencia de los datos solicitados");
	
		return info;
	}
}
