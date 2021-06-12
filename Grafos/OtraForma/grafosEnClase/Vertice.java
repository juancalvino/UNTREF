package grafosEnClase;

import java.util.HashSet;

public class Vertice {

	private HashSet<Arista> aristasAdyacentes;
	private int grado;
	
	public Vertice() {
		
		this.aristasAdyacentes = new HashSet<>();
		this.grado = 0;
	}
	
	public HashSet<Arista> getAristasAdyacentes() {
		
		return this.aristasAdyacentes;
	}
	
	public void addArista(Arista arista) {
		
		this.aristasAdyacentes.add(arista);
	}
	
	public void aumentarGrado() {
		
		this.grado += 1;
	}
	
	public int getrGrado() {
		
		return this.grado;
	}
	
	@Override
	public String toString() {
		
		return this.aristasAdyacentes.toString();
	}
}
