package agenda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Validacion {

	private String nombre;
	private String apellido;
	private String email;

	/**
	 * Valida si el nombre ingresado es correcto y luego lo agrega al objeto
	 * 
	 * @param nombre no debe ser NULL
	 * @throws LineaIncorrectaEx
	 */
	protected void setNombre(String nombre) throws LineaIncorrectaEx {
		this.nombre = validarExistencia(nombre.trim().toLowerCase(), "nombre");
	}

	/**
	 * 
	 * @return nombre del objeto
	 * @throws LineaIncorrectaEx
	 */
	protected String getNombre() throws LineaIncorrectaEx {
		return this.nombre;
	}

	/**
	 * Valida si el apellido ingresado es correcto y luego lo agrega al objeto
	 * 
	 * @param apellido
	 * @throws LineaIncorrectaEx
	 */
	protected void setApellido(String apellido) throws LineaIncorrectaEx {
		this.apellido = validarExistencia(apellido.trim().toLowerCase(), "apellido");
	}

	/**
	 * 
	 * @return apellido del objeto
	 * @throws LineaIncorrectaEx
	 */
	protected String getApellido() throws LineaIncorrectaEx {
		return this.apellido;
	}

	/**
	 * Valida si el email si tiene @ y es correcto,luego lo agrega al objeto
	 * 
	 * @param email
	 * @throws LineaIncorrectaEx
	 */
	protected void setEmail(String email) throws LineaIncorrectaEx {
		this.email = validarExistencia(validarEmail(email.trim().toLowerCase()), "email");
	}

	/**
	 *
	 * @return email del objeto
	 */
	protected String getEmail() {
		return this.email;
	}

	/**
	 * Guarda en el objeto asociado los valores de la linea correctamente
	 * serializados
	 * 
	 * @param linea
	 * @return true si los campos estan todos los campos correctamente serializados
	 * @throws LineaIncorrectaEx              en las lineas que tengan un error en
	 *                                        los campos serializados
	 * @throws ArrayIndexOutOfBoundsException si el valor de uno de los campos esta
	 *                                        vacio
	 */
	protected boolean validarInformacion(String linea) throws LineaIncorrectaEx, ArrayIndexOutOfBoundsException {

		String[] datosSegmentados = linea.split(",");
		for (String segmento : datosSegmentados) {
			String[] dato = segmento.split(":");

			String etiqueta = dato[0].trim().toLowerCase();
			String valor = dato[1];

			if (etiqueta.equals("nombre") && this.nombre == null) {
				setNombre(valor);
			} else if (etiqueta.equals("apellido") && this.apellido == null) {
				setApellido(valor);
			} else if (etiqueta.equals("mail") && this.email == null) {
				setEmail(valor);
			} else {
				throw new LineaIncorrectaEx("Tiene un error en los campos ingresados");
			}
		}
		return contactoCompleto();
	}

	/**
	 * Verifica la existencia de todos los atributos dentro del objeto
	 * (nombre,apellido y email)
	 * 
	 * @return true si todos los atributos del objeto tienen un valor distinto de
	 *         null
	 */
	protected boolean contactoCompleto() {
		return ((this.nombre != null) && (this.apellido != null) && (this.email != null));
	}

	/**
	 * Valida que el valor ingresado no sea Null o este vacio
	 * 
	 * @param valor
	 * @param etiqueta
	 * @return valor si es distinto de null y no esta vacio
	 * @throws LineaIncorrectaEx si valor es igual a null o esta vacio
	 */
	private String validarExistencia(String valor, String etiqueta) throws LineaIncorrectaEx {
		if (valor == null || valor.isEmpty())
			throw new LineaIncorrectaEx("Fallo el " + etiqueta + " ingresado");
		return valor;
	}

	/**
	 * Verifica que el emial ingresado contenga '@' y que contenga un dominio con
	 * '.'
	 * 
	 * @param email
	 * @return email si esta bien serealizado
	 * @throws LineaIncorrectaEx si el email no esta bien serealizado
	 */
	private String validarEmail(String email) throws LineaIncorrectaEx {

		String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPat.matcher(email);

		if (!matcher.find())
			throw new LineaIncorrectaEx("El Email '" + email + "' es invalido");

		return email;
	}
}
