package mantenimiento;

import java.util.ArrayList;

public class Sistema {

	private ArrayList<Instrumento> instrumentos;
	private ArrayList<Afinable> afinables;

	public Sistema() {
		instrumentos = new ArrayList<Instrumento>();
		afinables = new ArrayList<Afinable>();
	}

	/*
	 * Agrega el instrumento al contendor de instrumentos e intenta incluirlo
	 * también en el contenedor de afinables, manejando la excepción que pudiera
	 * ocurrir. Si el instrumento no es afinable, solo ignora la excepcion
	 */
	public void agregarInstrumento(Instrumento i) {
		instrumentos.add(i);
		try {
			afinables.add((Afinable) i);
		} catch (Exception e) {
		}
	}

	public Instrumento getInstrumento(int i) {
		return instrumentos.get(i);
	}

	public void listarEventos() {
		for (Instrumento i : instrumentos) {
			i.listarEventos();
		}
	}

	public void afinarTodos(String fecha) {
		for (Afinable a : afinables) {
			a.afinar(fecha);
		}
	}

	public void recambiarTodos(String fecha) {
		for (Instrumento i : instrumentos) {
			i.recambiar(fecha);
		}
	}

}
