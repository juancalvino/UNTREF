package colaDeProcesos;

public class Proceso implements Comparable<Proceso> {

	private String nombre;
	private int t_arribo;
	private int t_ejecucion;
	private int prioridad;
	private Estado status;

	public Proceso(String nombre, int t_arribo, int t_ejecucion, int prioridad) {
		this.nombre = nombre;
		this.t_arribo = verificarPosividad(t_arribo);
		this.t_ejecucion = verificarPosividad(t_ejecucion);
		this.prioridad = verificarPrioridad(prioridad);
		this.status = Proceso.Estado.LISTO;
	}

	public enum Estado {
		LISTO, TERMINADO
	};

	public long getT_ejecucion() {
		return this.t_ejecucion;
	}

	public Estado getStatus() {
		return this.status;
	}

	public void setStatus(Estado finalizado) {
		status = finalizado;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public int getT_arribo() {
		return t_arribo;
	}

	/**
	 * Devuelve el nombre del proceso
	 */
	@Override
	public String toString() {
		return nombre;
	}

	/**
	 * Compara las prioridades del 1 al 5, siendo el 1 la mayor prioridad y el 5 la
	 * menor.
	 */
	public int compareTo(Proceso other) {
		
		if (this.getPrioridad() > other.getPrioridad())
			return 1;
		if (this.getPrioridad() < other.getPrioridad())
			return -1;
		
		return new OrdenadorProcesosArribo().compare(this, other);
	}
	
	/**
	 * @param prioridad debe ser mayor o igual a 1 y menor o igual a 5.
	 * @return prioridad
	 * @exception IllegalArgumentException
	 */
	private int verificarPrioridad(int prioridad) {
		if (prioridad < 1 || prioridad > 5) {
			throw new IllegalArgumentException("El orden de prioridad del proceso " + nombre + "es invalido");
		}
		return prioridad;
	}

	/**
	 * @param prioridad debe ser mayor o igual a 1 y menor o igual a 5.
	 * @return prioridad
	 * @exception IllegalArgumentException
	 */
	private int verificarPosividad(int numero) {
		if (numero < 0) {
			throw new IllegalArgumentException("El orden de prioridad del proceso " + nombre + "es invalido");
		}

		return numero;
	}

}
