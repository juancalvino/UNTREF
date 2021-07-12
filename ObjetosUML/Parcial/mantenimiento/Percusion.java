package mantenimiento;

public abstract class Percusion extends Instrumento {

	public Percusion(String pNombre) {
		super(pNombre);
	}

	@Override
	public void recambiar(String fecha) {
		this.agregarEvento(new Evento(this.getNombre() + ": cambio de parches", fecha));
	}
}
