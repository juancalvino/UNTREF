package unidadContable;

import java.util.Date;

public class SalarioParcialPermanente extends SalarioParcial {

	private Date comienzoDeActividad;
	
	/**
	 * 
	 * @param tieneConyugue
	 * @param hijos tiene que ser mayor que 0
	 * @param comienzoDeActividad
	 * @param horasTrabajadas tiene que ser mayor que 0
	 * Post: SalarioParcialPermanente queda listo para poder operar
	 */
	public SalarioParcialPermanente(boolean tieneConyugue,int hijos, Date comienzoDeActividad, int horasTrabajadas) {
		
		super(tieneConyugue, hijos, horasTrabajadas);
		this.comienzoDeActividad = comienzoDeActividad;
	}
	
	
	/**
	 * @return liquidacion de un sueldo correspondiende al empleado parcial de planta permanente
	 */
	@Override
	public double liquidarSalario() {
		return super.liquidarSalario() + calcularAntiguedad();
	}
	
	
	/**
	 * @return el adicional correspondiente a la antiguedad del empleado parcial de planta permanente
	 */
	private double calcularAntiguedad() {
	
		long unAnioEnMs = 31556900000L;
		double antiguedad = (System.currentTimeMillis()
							- this.comienzoDeActividad.getTime())
							/ unAnioEnMs;

		double adicionalAntiguedad = antiguedad* IndicesSalarialesPermanente.getAdicionalAntiguedadXAnioUR();
		
		double tope = IndicesSalarialesPermanente.getTopeDeAntiguedadUR();	
		if(adicionalAntiguedad > tope)
			adicionalAntiguedad = tope;

		return adicionalAntiguedad * UnidadRetributiva.getValorActual();
	}
	
}
