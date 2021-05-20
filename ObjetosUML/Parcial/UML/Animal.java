package UML;

public abstract class Animal {
	 
	private String nombre;


	int energiaNeta;
	protected static final int ENERGIA_NETA_MANTENIMIENTO = 100; 
	protected static final int ENERGIA_NETA_GANANCIA = 150; 
	
	
	public Animal(String nombre, boolean energiaDeGanancia) {
		this.nombre = nombre;
		this.energiaNeta = energiaDeGanancia? ENERGIA_NETA_GANANCIA: ENERGIA_NETA_MANTENIMIENTO;
	}
	
	public double energiaTotal() {
	return calcularEnergiaBasica() + calcularEnergiaExtra();	
	}

	public String getNombre() {
		return nombre;
	}

	protected abstract double calcularEnergiaBasica();

	protected abstract double calcularEnergiaExtra();


}
