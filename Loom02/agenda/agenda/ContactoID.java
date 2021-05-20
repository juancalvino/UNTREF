package agenda;
/*
	En este ejercicio no se pidio validar los datos ni los strings vacios.
	Y los atributos ingresados no deben ser > 1, ejemplo no deben haber mas de dos telefonos por contacto.
*/

public class ContactoID {

	private String nombre;
	private String segundoNombre;
	private String apellido;
	private ViaDeContacto telefono;
	private ViaDeContacto email;
	private Domicilio domicilio;
	private String cumpleanios;
	private String empresa;

	/**
	 * Pre: 'nombre' y 'apellido' no pueden ser NULL Post: 'contactoID' queda
	 * preparado para almacenar y cambiar los datos del contacto.
	 */
	public ContactoID(String nombre, String apellido) {
		this.nombre = verificarAusenciaNull(nombre);
		this.apellido = verificarAusenciaNull(apellido);
	}

	/**
	 * Pre: 'nombre' y 'apellido' no pueden ser NULL Post: 'contactoID' queda
	 * preparado para almacenar y cambiar los datos del contacto.
	 */
	public ContactoID(String nombre, String segundoNombre, String apellido) {
		this(nombre, apellido);
		this.segundoNombre = segundoNombre;
	}

	/**
	 * Pre: 'nombre' no puede ser NULL. Post: modifica el valor de nombre a
	 * 'nombre'.
	 */
	public void setNombre(String nombre) {
		this.nombre = verificarAusenciaNull(nombre);
	}

	/**
	 * Pre: para eliminar el 'segundoNombre' debe ingresarse el valor NULL Post:
	 * modifica el valor de segundoNombre a 'segundoNombre'.
	 */
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	/**
	 * Pre: 'apellido' no puede ser NULL. Post: modifica el valor de apellido a
	 * 'apellido'.
	 */
	public void setApellido(String apellido) {
		this.apellido = verificarAusenciaNull(apellido);
	}

	/**
	 * Pre: telefono,atriuto de la clase, debe poseer el valor NULL. 'telefono' y
	 * 'tipo',parametros, no pueden ser NULL. Post: se agrega ViaDeContacto a
	 * telefono.
	 */
	public void addTelefono(String telefono, String tipo) {
		if (this.telefono != null)
			throw new Error("Ya existe un telefono ingresado");

		this.telefono = new ViaDeContacto(telefono, tipo);
	}

	/**
	 * Pre:el atributo telefono debe estar inicializado. Post: permite acceder al
	 * atributo telefono para ser modificado.
	 */
	public ViaDeContacto setTelefono() {
		if (telefono == null)
			throw new Error("Para camiar un telefono primero debe agregarlo");
		return telefono;
	}

	/**
	 * Post: elimina el telefono.
	 */
	public void deleteTelefono() {
		this.telefono = null;
	}

	/**
	 * Pre: email,atributo de la clase, debe poseer el valor NULL. 'email' y
	 * 'tipo',parametros, no pueden ser NULL. Post: se agrega ViaDeContacto a email.
	 */
	public void addEmail(String email, String tipo) {
		if (this.email != null)
			throw new Error("Ya existe un email");

		this.email = new ViaDeContacto(email, tipo);
	}

	/**
	 * Pre: el atributo email debe estar inicializado. Post: permite acceder al
	 * atributo email para ser modificado.
	 */
	public ViaDeContacto setEmail() {
		if (email == null)
			throw new Error("Para camiar un email primero debe agregarlo");
		return email;
	}

	/**
	 * Post: elimina el email.
	 */
	public void deleteEmail() {
		this.email = null;
	}

	/**
	 * Pre: domicilio, atributo de la clase, debe ser NULL. los valores ingresado
	 * por parametro no pueden ser NULL. Post: se agrega un Domicilio a domicilio.
	 */
	public void addDomicilio(String calle, int numero, String localidad, String provincia, String pais) {
		if (this.domicilio != null)
			throw new Error("Ya existe un domicilio");

		this.domicilio = new Domicilio(calle, numero, localidad, provincia, pais);
	}

	/**
	 * Pre: el atributo domicilio debe estar inicializado. Post: permite acceder a
	 * domicilio,atributo de la clase, para ser modificado.
	 */
	public Domicilio setDomicilio() {
		if (domicilio == null)
			throw new Error("Para camiar un domicilio primero debe agregarlo");
		return domicilio;
	}

	/**
	 * Post: elimina el domicilio.
	 */
	public void deleteDomicilio() {
		this.domicilio = null;
	}

	/**
	 * Post: asigna el valor 'cumpleanios' al atributo cumpleanios.
	 */
	public void setCumpleanios(String cumpleanios) {
		this.cumpleanios = cumpleanios;
	}

	/**
	 * Post: asigna el valor 'empresa' al atributo empresa.
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * Post: devuelve un String con toda la informacion que este en los atributos de
	 * la clase y sean distintos de NULL.
	 */
	public String toString() {

		String informacion = "Nombre:" + nombre;

		if (segundoNombre != null)
			informacion += " " + segundoNombre;

		informacion += "\nApellido:" + apellido;

		if (telefono != null)
			informacion += "\nTelefono:" + telefono.toString();

		if (email != null)
			informacion += "\nEmail:" + email.toString();

		if (domicilio != null)
			informacion += "\nDomicilio\n" + domicilio.toString();

		if (cumpleanios != null)
			informacion += "\nCumpleaños:" + cumpleanios;

		if (empresa != null)
			informacion += "\nEmpresa:" + empresa;

		return informacion;
	}

	/**
	 * Post: devuelve el dato ingresado si este no es NULL, sino devuelve una
	 * excepcion.
	 */
	private String verificarAusenciaNull(String info) {
		if (info == null)
			throw new Error("Es obligatorio la existencia de los datos solicitados");

		return info;
	}

}
