package unidadContable;
import verificadores.*;

public class IndicesSalarialesParciales extends IndicesSalariales {

	private static double sueldoBasicoUR = IndicesSalariales.getSueldoBasicoUR()/3;	
	private static double horaTrabajoParcialUR = 10;
	private static double topeTrabajoParcialUR = 1000;

	/**
	 * @return el sueldo basico de empleados parciales en Unidades Retributivas
	 */
	protected static double getSueldoBasicoUR() {
		return sueldoBasicoUR;
	}
	
	/**
	 * @param sueldoBasicoUR debe ser mayor o igual que 0
	 * Post: modifica el valor del 'sueldoBasicoUR'
	 */
	protected  static void setSueldoBasicoUR(double sueldoBasicoUR) {
		IndicesSalarialesParciales.sueldoBasicoUR = Verificador.negatividad(sueldoBasicoUR); ;
	}
	
	
	/**
	 * @return el valor por hora trabajada del empleado parcial en Unidades Retributivas
	 */
	public static double getHoraTrabajoParcial() {
		return horaTrabajoParcialUR;
	}
	
	/**
	 * @param horaTrabajoParcial debe ser mayor o igual que 0
	 * Post: modifica el valor del 'horaTrabajoParcial'
	 */
	public static void setHoraTrabajoParcial(double horaTrabajoParcial) {
		IndicesSalarialesParciales.horaTrabajoParcialUR = Verificador.negatividad(horaTrabajoParcial);
	}
	
	
	/**
	 * @return el tope pagado por horas trabajadas en Unidades Retributivas hacia empleados de tiempo parcial
	 *			teniendo en cuenta el salario basico
	 */
	public static double getTopeTrabajoParcial() {
		return topeTrabajoParcialUR;
	}
	
	/**
	 * @param topeTrabajoParcial debe ser mayor o igual que 0
	 * Post: modifica el valor del 'topeTrabajoParcial'
	 */
	public static void setTopeTrabajoParcial(double topeTrabajoParcial) {
		IndicesSalarialesParciales.topeTrabajoParcialUR = Verificador.negatividad(topeTrabajoParcial);
	}
	
}
