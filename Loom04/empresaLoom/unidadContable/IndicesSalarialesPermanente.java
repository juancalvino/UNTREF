package unidadContable;
import verificadores.*;

public class  IndicesSalarialesPermanente extends IndicesSalariales {

	private static double adicionalAntiguedadXAnioUR = 100 ;
	private static double topeDeAntiguedadUR = 2000;
	
	/**
	 * @return el adicional de antiguedad por año trabajado en Unidades Retributivas
	 */
	protected static double getAdicionalAntiguedadXAnioUR() {
		return adicionalAntiguedadXAnioUR;
	}
	
	/**
	 * @param adicionalAntiguedadXAnioUR debe ser mayor o igual que 0
	 * Post: modifica el valor del 'adicionalAntiguedadXAnioUR'
	 */
	protected static void setAdicionalAntiguedadXAnioUR(double adicionalAntiguedadXAnioUR) {
		IndicesSalarialesPermanente.adicionalAntiguedadXAnioUR = Verificador.negatividad(adicionalAntiguedadXAnioUR);
	}
	
	
	/**
	 * @return el adicional tope por antiguedad en Unidades Retributivas
	 */
	protected static double getTopeDeAntiguedadUR() {
		return topeDeAntiguedadUR;
	}
	
	/**
	 * @param topeDeAntiguedadUR debe ser mayor o igual que 0
	 * Post: modifica el valor del 'topeDeAntiguedadUR'
	 */
	protected static void setTopeDeAntiguedadUR(double topeDeAntiguedadUR) {
		IndicesSalarialesPermanente.topeDeAntiguedadUR = Verificador.negatividad(topeDeAntiguedadUR);
	}


}
