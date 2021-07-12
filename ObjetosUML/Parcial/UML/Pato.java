package UML;

public class Pato extends Ave implements Nadador, Volador {

	public Pato(String nombre, boolean energiaDeGanancia) {
		super(nombre, energiaDeGanancia);
	}

	@Override
	public void volar() {
		System.out.println(getNombre() + " volando ...");

	}

	@Override
	public void nadar() {
		System.out.println(getNombre() + " nadando ...");

	}

	@Override
	protected double calcularEnergiaExtra() {
		return ENERGIA_NETA_MANTENIMIENTO * (0.10 + 0.15);
	}
}
