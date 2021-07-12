package mantenimiento;

import java.util.ArrayList;

public abstract class Instrumento {
	private String nombre;
	private ArrayList<Evento> eventos;

	public Instrumento(String pNombre) {
		this.nombre = pNombre;
		this.eventos = new ArrayList<Evento>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarEvento(Evento e) {
		this.eventos.add(e);
	}

	public void listarEventos() {
		System.out.println(this.nombre);
		for (Evento e : eventos) {
			System.out.println("\t" + e.descripcion + " (" + e.fecha + ")");
		}
	}

	public abstract void recambiar(String fecha);

}
