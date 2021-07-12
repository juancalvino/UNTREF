package mantenimiento;

public abstract class Cuerdas extends Instrumento implements Afinable {

	public Cuerdas(String pNombre) {
		super(pNombre);
	}

	@Override
	public void afinar(String fecha) {
		this.agregarEvento(new Evento(this.getNombre() + ": afinando", fecha));
	}

	@Override
	public void recambiar(String fecha) {
		this.agregarEvento(new Evento(this.getNombre() + ": cambio de cuerdas", fecha));
	}

}
