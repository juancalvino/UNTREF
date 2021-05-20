package UML;

public class Nutria extends Mamifero implements Nadador {

	public Nutria(String nombre, boolean energiaDeGanancia) {
		super(nombre, energiaDeGanancia);
	}

	@Override
	protected double calcularEnergiaExtra() {
		return ENERGIA_NETA_MANTENIMIENTO *0.1;
	}

	@Override
	public void nadar() {
		System.out.println( getNombre() + " nadando ...");
	}
}	
