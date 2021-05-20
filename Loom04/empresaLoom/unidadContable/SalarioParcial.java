package unidadContable;

import verificadores.Verificador;

public class SalarioParcial extends SalarioBasico {

	private int horasTrabajadas;

	/**
	 * 
	 * @param tieneConyugue
	 * @param hijos mayor que 0
	 * @param horasTrabajadas mayor que 0
	 * Post: SalarioParcial queda listo para poder operar
	 */
	public SalarioParcial(boolean tieneConyugue, int hijos,int horasTrabajadas) {
		super(tieneConyugue, hijos);
		this.horasTrabajadas = Verificador.negatividad(horasTrabajadas);
	}
	
	/**
	 * @return liquidacion de un sueldo correspondiende al empleado parcial
	 */
	@Override
	protected double getSueldoBasico() {
		double sueldoTotalHorasTrabajadas = (horasTrabajadas* IndicesSalarialesParciales.getHoraTrabajoParcial())
											+ IndicesSalarialesParciales.getSueldoBasicoUR();

		double salarioTopeParcial = IndicesSalarialesParciales.getTopeTrabajoParcial();
	
		if(sueldoTotalHorasTrabajadas   > salarioTopeParcial){
			sueldoTotalHorasTrabajadas  = salarioTopeParcial;}
		
		return sueldoTotalHorasTrabajadas  * UnidadRetributiva.getValorActual();
	}
		
}
