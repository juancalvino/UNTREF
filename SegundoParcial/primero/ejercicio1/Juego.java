package ejercicio1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;
 
public class Juego {

	TreeSet<Jugador> podio;
	HashMap<String, Jugador> listaDeJugadores;
	
	public Juego() {
		this.podio = new TreeSet<>(new PuntajesDeJugador());
		this.listaDeJugadores = new HashMap<>();
	}
	
	public void ingresarJugada(String jugador, int[]dado) {
		if(!listaDeJugadores.containsKey(jugador)) {
			listaDeJugadores.put(jugador, new Jugador(jugador));
		}
		
	}
	
	public int devolverPuntaje(int[] dado) {
		int sumaTotal =  dado[0] + dado[1] + dado[2];
		
		if(sumaTotal%3 == 0) {
			return sumaTotal + 100;
		}
		
		Arrays.sort(dado);
		
		if(dado[0] == dado[1] || dado[1] == dado[2]) {
			return sumaTotal + 50;
		}
		
		if(dado[0]+1 == dado[1] && dado[1]+1 == dado[2]) {
			return sumaTotal + 25;
		}
		
		return sumaTotal;
	}
	
	
}
