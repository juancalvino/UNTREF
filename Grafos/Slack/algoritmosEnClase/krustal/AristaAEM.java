package algoritmosEnClase.krustal;

public class AristaAEM implements Comparable<AristaAEM> {
	private String origen;
	private String destino;
	private double peso;
	
	public AristaAEM(String origen, String destino, double peso) {
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	@Override
	public int compareTo(AristaAEM arista) {
		return Double.compare(this.peso, arista.peso);
	}
}