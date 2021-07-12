package ejercicio1;

import java.util.Arrays;

public class Jugador{

	private int puntajeTotal;
	private String nombre;
	private int[] mejoresJugadas;
	
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntajeTotal = 0;
		this.mejoresJugadas = new int[5];
	}
		
	public int getPuntaje() {
		Arrays.sort(mejoresJugadas);
		if(mejoresJugadas[0] <= 0 ) {
			return 0;
		}
		return this.puntajeTotal;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void addJugada(int puntajeJugada) {
		Arrays.sort(mejoresJugadas);
		if(puntajeJugada > mejoresJugadas[0]) {
			puntajeTotal -= mejoresJugadas[0];
			puntajeTotal += puntajeJugada;
			mejoresJugadas[0] = puntajeJugada;
		};
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}

	@Override
	public boolean equals(Object obj) {
		Jugador otro = (Jugador) obj;
		return this.nombre.equals(otro.getNombre());
	}
	
}
