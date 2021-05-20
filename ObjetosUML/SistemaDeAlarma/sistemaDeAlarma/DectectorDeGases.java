package sistemaDeAlarma;

public class DectectorDeGases extends Sensor {

	public DectectorDeGases(String ubicacion) {
		super(ubicacion);
		this.tipo = "Detector de Gases";
		this.umbral = 20;
	}

	@Override
	public double tomarMedicion() {
		return 3;
	}


}
