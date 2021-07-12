package mantenimiento;

public abstract class Viento extends Instrumento implements Afinable {

	public Viento(String pNombre) {
		super(pNombre);
	}

	@Override
	public void afinar(String fecha) {
		this.agregarEvento(new Evento(this.getNombre() + ": afinando", fecha));
	}

	@Override
	public void recambiar(String fecha) {
		this.agregarEvento(new Evento(this.getNombre() + ": cambio boquilla", fecha));
	}

}
