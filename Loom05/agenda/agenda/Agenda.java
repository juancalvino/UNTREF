package agenda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Agenda {
	private ArrayList<Persona> contactos;

	public Agenda() {
		contactos = new ArrayList<Persona>();
	}

	public void agregarContacto(String pNombre, String pApellido, String pMail) {

		Persona contacto = new Persona(pNombre, pApellido, pMail);
		contactos.add(contacto);
	}

	/**
	 * Borra un contacto de la agenda
	 * 
	 * @param pApellido Apellido del contacto a borrar
	 * @throws ContactoInexistenteEx si no se encuentra el apellido buscado
	 */
	public void borrarContacto(String pApellido) throws ContactoInexistenteEx {
		int indice;

		indice = this.buscarContacto(pApellido);
		contactos.remove(indice);
	}

	/**
	 * Busca un contacto por apellido
	 * 
	 * @param pApellido apellido del contacto buscado
	 * @return devuelve la primera aparición del apellido buscado
	 * @throws ContactoInexistenteEx si no existe ningún contacto con el apellido
	 *                               buscado
	 */
	private int buscarContacto(String pApellido) throws ContactoInexistenteEx {
		int i = 0;
		for (Persona contacto : contactos) {
			if (contacto.getApellido().equals(pApellido)) {
				return i;
			}
			i++;
		}

		throw new ContactoInexistenteEx(pApellido);
	}

	/**
	 * Muestra por pantalla todos los contactos de la Agenda Nota: no está bueno que
	 * un método muestre por pantalla los datos pero por ahora hasta que tengamos
	 * iteradores elegimos hacerlo de esta manera para no devolver todo el arreglo
	 * de contactos
	 */
	public void mostrarTodosLosContactos() {
		int i = 0;
		for (Persona contacto : contactos) {
			System.out.println(i + ":\t" + contacto);
			i++;
		}
		System.out.println("\nTotal: " + i + " contactos\n");
	}

	/**
	 * Carga todos los contactos que puede en al agenda. El formato del archivo de
	 * entrada es el siguiente: Una línea por cada contacto, y en cada linea
	 * separado por coma y etiquetados los datos del contacto. Ej nombre: Juan,
	 * apellido: Perez, mail: jperez@gmail.com
	 * 
	 * @param pArchivo nombre del archivo (path absoluto o relativo a la carpeta src
	 *                 del proyecto
	 */
	public int cargarArchivo(String pArchivo) {

		FileReader archivo = null;
		BufferedReader lector = null;
		int lineasLeidas = 0;
		int contactosCargados = 0;

		try {
			archivo = new FileReader(pArchivo);
			lector = new BufferedReader(archivo);
			String linea;

			while ((linea = lector.readLine()) != null) {
				lineasLeidas++;
				try {
					cargarLinea(linea);
					contactosCargados++;
				} catch (ArrayIndexOutOfBoundsException e) {
					System.err.println(
							"Revise el formato del contacto ubicado en la linea " + lineasLeidas++ + " del archivo");
					e.printStackTrace();
				} catch (LineaIncorrectaEx e) {
					System.err.println(e + " en la linea " + lineasLeidas++ + " del archivo");
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (archivo != null)
				try {
					archivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return contactosCargados;
	}

	/**
	 * Lee una linea serealizada y si su formato es correcto y completo agrega el
	 * contacto a la agenda
	 * 
	 * @param linea serealizada
	 * @throws LineaIncorrectaEx
	 */
	private void cargarLinea(String linea) throws LineaIncorrectaEx {
		Validacion data = new Validacion();
		linea.trim();

		if (!linea.isEmpty() && data.validarInformacion(linea)) {
			agregarContacto(data.getNombre(), data.getApellido(), data.getEmail());
		}
	}

	/**
	 * Guarda la agenda completa en disco, en el archivo especificado como parámetro
	 * Con el siguiente formato. Una línea por contacto, con los datos etiquetados
	 * nombre: Juan, apellido: Perez, mail: jperez@gmail.com
	 * 
	 * @param pArchivo nombre del archivo (path absoluto o relativo a la carpeta src
	 *                 del proyecto
	 */
	public void guardarAgenda(String pArchivo) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(pArchivo + ".txt");
			pw = new PrintWriter(fichero);

			for (Persona contacto : contactos) {
				pw.println(contacto.toStringFormatoCarga());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
