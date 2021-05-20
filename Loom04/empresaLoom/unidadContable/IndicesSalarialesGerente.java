package unidadContable;
import verificadores.*;

public class IndicesSalarialesGerente extends IndicesSalarialesPermanente {

	private static double adicionalPersonalACargo = 2000;

	
	/**
	 * @return el adicional por personal a Cargo en Unidades Retributivas
	 */
	protected static double getAdicionalPersonalACargo() {
		return adicionalPersonalACargo;
	}
	
	/**
	 * @param adicionalPersonalACargo debe ser mayor o igual que 0
	 * Post: modifica el valor del 'adicionalPersonalACargo'
	 */
	protected static void setAdicionalPersonalACargo(double adicionalPersonalACargo) {
		IndicesSalarialesGerente.adicionalPersonalACargo = Verificador.negatividad(adicionalPersonalACargo);
	}
	
}
