package unidadContable;

import java.util.Date;

public class SalarioPermanente extends SalarioBasico {
	
	private Date comienzoDeActividad;
	
	
	/**
	 * 
	 * @param tieneConyugue
	 * @param hijos tiene que ser mayor que 0
	 * @param comienzoDeActividad
	 * Post: SalarioPermanente queda listo para poder operar
	 */
	public SalarioPermanente(boolean tieneConyugue, int hijos, Date comienzoDeActividad) {
		super(tieneConyugue, hijos);
		this.comienzoDeActividad = comienzoDeActividad;
	}
	
	
	/**
	 * @return liquidado un sueldo correspondiende al empleado de planta permanente
	 */
	@Override
	public double liquidarSalario() {
		return super.liquidarSalario() + calcularAntiguedad();
	}

	
	/**
	 * @return el adicional correspondiente a la antiguedad del empleado planta permanente
	 */
	private double calcularAntiguedad() {
		
		long unAnioEnMs = 31556900000L;
		double antiguedad = (System.currentTimeMillis()
							- this.comienzoDeActividad.getTime())
							/ unAnioEnMs;

		double adicionalAntiguedad = antiguedad * IndicesSalarialesPermanente.getAdicionalAntiguedadXAnioUR();
		
		double tope = IndicesSalarialesPermanente.getTopeDeAntiguedadUR(); 
	
		if(adicionalAntiguedad > tope)
			adicionalAntiguedad = tope;

		return adicionalAntiguedad * UnidadRetributiva.getValorActual();
	}
}
