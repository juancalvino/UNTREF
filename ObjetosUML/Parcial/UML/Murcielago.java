package UML;

public class Murcielago extends Mamifero implements Volador {

	public Murcielago(String nombre, boolean energiaDeGanancia) {
		super(nombre, energiaDeGanancia);
	}

	@Override
	public void volar() {
		System.out.println(getNombre() + " volando ...");
	}

	@Override
	protected double calcularEnergiaExtra() {
		return ENERGIA_NETA_MANTENIMIENTO * 0.15;
	}

}
