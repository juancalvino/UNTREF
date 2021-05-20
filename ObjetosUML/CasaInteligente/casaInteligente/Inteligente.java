package casaInteligente;

public abstract class Inteligente  implements Inteligencia{

	protected boolean estaPrendido = false;
	
	@Override
	public void apagar() {
		estaPrendido = false;
	}
	
	@Override
	public void encender() {
		estaPrendido = true;
	}

	public void apagarAutomatico() {
		estaPrendido = false;
		System.out.println("Se apago " + this.getClass().getSimpleName());
	}
}
