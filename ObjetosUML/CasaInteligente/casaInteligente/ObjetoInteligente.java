package casaInteligente;

public class ObjetoInteligente extends Inteligente{
	String nombre;
	
	public ObjetoInteligente(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() +" "+ nombre;
	}

}
