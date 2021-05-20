package agenda;
/*
 * En este ejercicio no se pidio validar los datos ni los strings vacios.
 */
public class Domicilio {

	private String calle;
	private int numero;
	private String localidad;
	private String provincia;
	private String pais;
	private InformacionOpcional informacionOpcional;

	
	/**
	 * Pre: ninguno de los parametros ingresados puede ser NULL;
	 * Post:El domicilio queda preparado para ser modificado y/o agregar datos opcionales
	 */
	public Domicilio(String calle, int numero, String localidad, String provincia, String pais) {
	
		this.calle = verificarAusenciaNull(calle);
		this.numero = numero;
		this.localidad = verificarAusenciaNull(localidad);
		this.provincia = verificarAusenciaNull(provincia);
		this.pais = verificarAusenciaNull(pais);

	}
	
	/**
	 * Pre: 'calle' no puede ser NULL.
	 * Post: modifica el valor de calle a 'calle'.
	 */
	public void setCalle(String calle) {
		this.calle = verificarAusenciaNull(calle);
	}
	

	/**
	 * Post: modifica el valor de numero a 'numero'.
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	
	/**
	 * Pre: 'localidad' no puede ser NULL.
	 * Post: modifica el valor de localidad a 'localidad'.
	 */
	public void setLocalidad(String localidad) {
		this.localidad = verificarAusenciaNull(localidad);
	}


	/**
	 * Pre: 'localidad' no puede ser NULL.
	 * Post: modifica el valor de provincia a 'provincia'.
	 */
	public void setProvincia(String provincia) {
		this.provincia = verificarAusenciaNull(provincia);
	}


	/**
	 * Pre: 'pais' no puede ser NULL.
	 * Post: modifica el valor de provincia a 'pais'.
	 */
	public void setPais(String pais) {
		this.pais = verificarAusenciaNull(pais);
	}
	
	/**
	 * Post: Si 'informacionOpcional' es NULL sea instancia un nuevo Objeto de tipo InformacionOpcional; 
	 *		 Devuelve 'informacionOpcional' de tipo InformacionOpcional
	 */		
	public InformacionOpcional setOpcional() {
		if(informacionOpcional == null)
			informacionOpcional =  new InformacionOpcional();
	
		return informacionOpcional;
	}
	
	
	/**
	 * Post: devuelve un String con todos los datos Obligatorios e InformacionOpcional si los hubiera.
	 */
	public String toString() {
		String informacion = "";
		
		informacion+=	"Calle:" + calle + "\n"
						+"Numero:" + numero + "\n";
		
		informacion+= verificarYDevolverOpcional();
		
		informacion+=	 "Localidad:" + localidad + "\n"
						+"Provincia:" + provincia + "\n"
						+"Pais:" + pais;					
		
		return informacion;
	}
	
	/**
	 * Post:devuelve la informacion en informacionOpcional. 
	 * 		Si su informacion es "" le asigna NULL a informacionOpcional y devuelve "".
	 * 		
	 */
	private String verificarYDevolverOpcional(){
		
		if(informacionOpcional == null)
			return "";
		
		String informacionOpcional = this.informacionOpcional.toString();
		
		if(informacionOpcional == "") {
			this.informacionOpcional = null;
		}
		
		return informacionOpcional; 
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
