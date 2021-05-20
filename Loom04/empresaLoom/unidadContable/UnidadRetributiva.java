package unidadContable;

import verificadores.Verificador;

public class UnidadRetributiva {
	
	private static double valorActual = 10;

	/**
	 * @return el valor actual de las Unidades Retributivas
	 */
	public static double getValorActual() {
		return valorActual;
	}

	/**
	 * @param valorActual debe ser mayor o igual que 0
	 * Post: modifica el valor del 'valorActual'
	 */
	public static void setValorActual(double valorActual) {
		UnidadRetributiva.valorActual = Verificador.negatividad(valorActual);
	}

}
