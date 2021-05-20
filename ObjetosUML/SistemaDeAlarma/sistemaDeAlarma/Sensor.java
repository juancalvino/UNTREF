package sistemaDeAlarma;

public abstract class Sensor {

	private String ubicacion;
	private boolean estado;
	private double ultimoValorMedido;
	protected String tipo;
	protected double umbral;

	public Sensor(String ubicacion) {
		this.ubicacion = ubicacion;
		this.ultimoValorMedido = tomarMedicion();
		this.estado = false;
	}

	public abstract double tomarMedicion();

	public void cambiarEstado() {
		this.estado = (this.estado == false);
	}
	
	public String getUbicacion() {
		return ubicacion;
	}

	public double getUltimoValorMedido() {
		return ultimoValorMedido;
	}

	public double getUmbral() {
		return umbral;
	}

}
