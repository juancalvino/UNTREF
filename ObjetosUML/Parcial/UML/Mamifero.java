package UML;

public abstract class Mamifero extends Animal{

	public Mamifero(String nombre, boolean energiaDeGanancia) {
		super(nombre, energiaDeGanancia);
	}

	@Override
	public double calcularEnergiaBasica() {
		return this.energiaNeta * 0.9;
	}

}
