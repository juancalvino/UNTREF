package ejercicio1;

import java.util.Comparator;

public class PuntajesDeJugador implements Comparator<Jugador> {

	@Override
	public int compare(Jugador jugador1, Jugador jugador2) {
		if(jugador1.getPuntaje() < jugador2.getPuntaje()) {
			return 1;
		}
		return -1;
	}
}
