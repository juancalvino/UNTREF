package Local;

public class Heladera extends Electrodomestico{

	EficienciaEnergetica eficienciaEnergetica;
	int capacidad;
	
	public Heladera(String nombre, EficienciaEnergetica eE, int capacidad, double precio) {
		super(nombre, precio);
		this.eficienciaEnergetica = eE;
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return super.toString() + " " + eficienciaEnergetica + " " + capacidad;
	}
}
