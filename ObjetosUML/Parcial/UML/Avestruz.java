package UML;

public class Avestruz extends Ave {

	public Avestruz(String nombre, boolean energiaDeGanancia) {
		super(nombre, energiaDeGanancia);
	}

	@Override
	protected double calcularEnergiaExtra() {
		return 0;
	}

}
