package UML;

public abstract class Ave extends Animal {

	public Ave(String nombre, boolean energiaDeGanancia) {
		super(nombre, energiaDeGanancia);
	}

	@Override
	protected double calcularEnergiaBasica() {
		return energiaNeta * 0.7;
	}

}
