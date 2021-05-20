package colaDeProcesos;

import java.util.Comparator;

public class OrdenadorProcesosArribo implements Comparator<Proceso> {
	/**
	 * Compara los arribos de los procesos. menor.
	 * 
	 * @return 1 si el arribo de proceso1 es mayor que proceso2, -1 si el arribo de
	 *         proceso1 es menor que proceso2, 0 si los arribos de ambos procesos
	 *         son iguales.
	 */
	@Override
	public int compare(Proceso proceso1, Proceso proceso2) {
		int arribo1 = proceso1.getT_arribo();
		int arribo2 = proceso2.getT_arribo();

		return (arribo1 > arribo2) ? 1 : ((arribo1 == arribo2) ? 0 : -1);
	}

}
