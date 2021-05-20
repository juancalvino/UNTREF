package unidadContable;

import verificadores.Verificador;

public class SalarioBasico {
	
	private boolean tieneConyugue;
	private int hijos;
	
	/**
	 * @param tieneConyugue
	 * @param hijos debe ser mayor o igual a 0
	 * Post: SalarioBasico queda listo para poder operar
	 */
	public SalarioBasico(boolean tieneConyugue, int hijos) {
		this.tieneConyugue = tieneConyugue;
		this.hijos = Verificador.negatividad(hijos);
	}
	
	/**
	 * @return liquidado un sueldo basico correspondiende al empleado
	 */
	public double liquidarSalario() {
		return  getSueldoBasico()+ getSalarioFamiliar();
		}

	
	/**
	 * @return un sueldo basico correspondiende al empleado
	 */
	protected double getSueldoBasico() {
		return IndicesSalariales.getSueldoBasicoUR() * UnidadRetributiva.getValorActual(); 
	}

	
	/**
	 * @return el salario familiar correspondiende al empleado
	 */
	private double getSalarioFamiliar() {
		return getAdicionalConyugue() + getAdicionalPorHijo();
	}
	
	
	/**
	 * @return el adicional por hijo correspondiende al empleado
	 */
	private double getAdicionalPorHijo() {
		return this.hijos * IndicesSalariales.getAdicionalPorHijoUR() * UnidadRetributiva.getValorActual();
	}
	
	
	/**
	 * @return el adicional por conyugue correspondiende al empleado
	 */
	
	private double getAdicionalConyugue() {
		return (this.tieneConyugue)?
				(IndicesSalariales.getAdicionalConyugueUR()* UnidadRetributiva.getValorActual()):0; 
	}
	
}
