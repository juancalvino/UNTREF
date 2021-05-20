package unidadContable;

import java.util.Date;

public class SalarioGerente extends SalarioPermanente{
	
	/**
	 * 
	 * @param tieneConyugue
	 * @param hijos tiene que ser mayor que 0
	 * @param comienzoDeActividad
	 * Post: SalarioGerente queda listo para poder operar
	 */
	public SalarioGerente(boolean tieneConyugue, int hijos, Date comienzoDeActividad) {
		super(tieneConyugue, hijos, comienzoDeActividad);
	}
	
	/**
	 * @return liquidado un sueldo correspondiende al gerente
	 */
	@Override
	public double liquidarSalario() {
		return super.liquidarSalario() + getAdicionalPersonalACargo();
	}
	
	/**
	 * @return el adicional por personal a cargo correspondiende al gerente
	 */
	private double getAdicionalPersonalACargo() {
		return IndicesSalarialesGerente.getAdicionalPersonalACargo()* UnidadRetributiva.getValorActual();
	}
}
