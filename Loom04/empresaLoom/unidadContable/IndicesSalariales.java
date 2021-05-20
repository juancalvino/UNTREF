package unidadContable;
import verificadores.*;

public abstract class IndicesSalariales {
	
	private static double sueldoBasicoUR = 1000;
	private static double adicionalConyugueUR = 100;
	private static double adicionalPorHijoUR  = 200;
	
	/**
	 * @return el sueldo basico de empleados permanentes en Unidades Retributivas
	 */
	protected static double getSueldoBasicoUR() {
		return sueldoBasicoUR;
	}
	
	/**
	 * @param sueldoBasicoUR debe ser mayor o igual que 0
	 * Post: modifica el valor del 'sueldoBasicoUR'
	 */
	protected static void setSueldoBasicoUR(double sueldoBasicoUR) {
		IndicesSalariales.sueldoBasicoUR = Verificador.negatividad(sueldoBasicoUR); ;
	}

	
	/**
	 * @return el adicional por conyugue en Unidades Retributivas
	 */
	protected static double getAdicionalConyugueUR() {
		return adicionalConyugueUR;
	}
	
	/**
	 * @param adicionalConyugueUR debe ser mayor o igual que 0
	 * Post: modifica el valor del 'adicionalConyugueUR'
	 */
	protected static void setAdicionalConyugueUR(double adicionalConyugueUR) {
		IndicesSalariales.adicionalConyugueUR = Verificador.negatividad(adicionalConyugueUR);
	}

	
	/**
	 * @return el adicional por cada hijo en Unidades Retributivas
	 */
	protected static double getAdicionalPorHijoUR() {
		return adicionalPorHijoUR;
	}

	/**
	 * @param adicionalPorHijoUR debe ser mayor o igual que 0
	 * Post: modifica el valor del 'adicionalPorHijoUR'
	 */
	protected static void setAdicionalPorHijoUR(double adicionalPorHijoUR) {
		IndicesSalariales.adicionalPorHijoUR = Verificador.negatividad(adicionalPorHijoUR);
	}
	
	
}
