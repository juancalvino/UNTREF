package tendidoMinimo;

import grafo.Arista;

public class AristaAEM {

	String origen;
	String destino;
	double peso; 

	public AristaAEM(String origen, Arista arista) {
		this.origen = origen;
		this.destino = arista.getDestino().getNombre();
		this.peso = arista.getPeso();
	}

	public String getOrigen() {
		return origen;
	}
	public String getDestino() {
		return destino;
	}
	public double getPeso() {
		return peso;
	}	
	
	@Override
	public String toString() {
		return origen + "--" + peso + "->" + destino + " | ";
	}
}
