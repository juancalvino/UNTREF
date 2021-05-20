package sistemaDeAlarma;

public class SensorDeTemperatura extends Sensor{

	public SensorDeTemperatura(String ubicacion) {
		super(ubicacion);
		this.tipo = "Sensor de temperatura";
		this.umbral = 40;
		
	}

	@Override
	public double tomarMedicion() {
		return 28;
	}

}
