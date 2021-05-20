package agenda;
/*
 * En este ejercicio no se solicito reutilizar los indices ya cargados.
 */

public class Agenda {

	private ContactoID[] contacto;
	private int indiceDelContactoAOcupar = 0;

	/**
	 * Pre: @param cantidadDeContactos es mayor a 0 Post: la agenda queda preparada
	 * para guardar contactos para la cantidad de de contactos indicados como
	 * parametro Inicialmente no hay ningún Contacto almacenado.
	 */
	public Agenda(int cantidadDeContactos) {
		validadCantidadDeContactos(cantidadDeContactos);

		this.contacto = new ContactoID[cantidadDeContactos];
	}

	/**
	 * Pre: ContactoID[] debe poseer algun indice apuntando a NULL
	 * 
	 * @param nombre   NO debe ser NULL
	 * @param apellido NO debe ser NULL Post: el contacto queda preparado para
	 *                 guardar los datos del contacto
	 */
	public void newContacto(String nombre, String apellido) {
		contacto[validarIndice(indiceDelContactoAOcupar)] = new ContactoID(nombre, apellido);
		indiceDelContactoAOcupar++;
	}

	/**
	 * Pre: ContactoID[] debe poseer algun indice apuntando a NULL
	 * 
	 * @param nombre   NO debe ser NULL
	 * @param apellido NO debe ser NULL Post: el contacto queda preparado para
	 *                 guardar los datos del contacto
	 */
	public void newContacto(String nombre, String segundoNombre, String apellido) {
		contacto[validarIndice(indiceDelContactoAOcupar)] = new ContactoID(nombre, segundoNombre, apellido);
		indiceDelContactoAOcupar++;
	}

	/**
	 * Pre: @param indiceDelContacto debe ser algun valor dentro del rango de los
	 * indices de Contacto[] y el valor en dicho indice NO debe ser NULL Post:
	 * devuelve el ContactoID para ser modificado
	 */
	public ContactoID setContacto(int indiceDelContacto) {
		return contacto[verificarRango(indiceDelContacto)];
	}

	/**
	 * Pre: @param indiceDelContacto debe encontrarse en el rango de contacto[]
	 * Post: el contacto[indiceDelContacto] apunta a NULL
	 */
	public void deleteContacto(int indiceDelContacto) {
		contacto[verificarRango(indiceDelContacto)] = null;
	}

	/**
	 * Pre: @param indiceDelContacto debe encontrarse en el rango de contacto[]
	 * Post: devuelve la informacion almacenada en contacto[indiceDelContacto] si
	 * este contacto[indiceDelContacto] apuntase a NULL devolvera NULL
	 */
	public String toString(int indiceDelContacto) {
		if (contacto[verificarRango(indiceDelContacto)] == null)
			return null;

		return contacto[indiceDelContacto].toString();

	}

	/**
	 * Post: valida que @param cantidadDeContactos sea mayor o igual a 1
	 */
	private void validadCantidadDeContactos(int cantidadDeContactos) {
		if (cantidadDeContactos < 1)
			throw new Error("La cantidad de contactos deben ser mayores o iguales a 1");
	}

	/**
	 * Post: devuelve el el indiceDelContacto si este es mayor o igual a 0 y menor
	 * que la longitud de contacto[]
	 */
	private int verificarRango(int indiceDelContacto) {
		if (indiceDelContacto < 0 || indiceDelContacto >= contacto.length)
			throw new Error("El indice ingresado esta fuera del rango de la agenda");

		return indiceDelContacto;
	}

	/**
	 * Post: develve el indiceDelContactoAOcupar si este esta dentro del rango
	 * contacto[] sino devuelve algun indice de contacto[] que este apuntando a NULL
	 * o por ultimo devuelve -1 si no hay mas espacio disponible en contacto[] para
	 * almacenar contactos
	 */
	private int validarIndice(int indiceDelContactoAOcupar) {
		if (indiceDelContactoAOcupar >= contacto.length)
			indiceDelContactoAOcupar = buscarIndiceVacio();
		if (indiceDelContactoAOcupar == -1)
			throw new Error("No hay mas espacio para ingresar contactos");

		return indiceDelContactoAOcupar;
	}

	/**
	 * Post: devuelve un indice que en contacto[] este apuntando a NULL sino
	 * devuelve -1
	 */
	private int buscarIndiceVacio() {
		int indiceVacio = -1;

		for (int i = 0; i < contacto.length && indiceVacio == -1; i++) {
			if (contacto[i] == null)
				indiceVacio = i;
		}
		return indiceVacio;
	}

}
