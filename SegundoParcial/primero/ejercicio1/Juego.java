package ejercicio1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
 
public class Juego {

	private static Juego juego;
	private TreeSet<Jugador> podio;
	private HashMap<String, Jugador> listaDeJugadores;
	private static final int VALOR_MINIMO = 1;
	private static final int VALOR_MAXIMO = 6;
	
	
	private Juego() {
		this.podio = new TreeSet<>(new PuntajesDeJugador());
		this.listaDeJugadores = new HashMap<>();
	}
	
	public static Juego getJuego() {
		if(juego == null) {
			juego = new Juego();
		}
		return juego;
	}
	
	
	public void ingresarJugada(String jugador, int[]dado) throws ValorDeDadosEx {
		if(!listaDeJugadores.containsKey(jugador)) {
			listaDeJugadores.put(jugador, new Jugador(jugador));
		}

		listaDeJugadores.get(jugador).addJugada(devolverPuntaje(dado));
		podio.add(listaDeJugadores.get(jugador));
	}
	
	
	public String listarPodio() {

		String lista = "";
		
		Iterator<Jugador> iterador = podio.iterator();
		
		while(iterador.hasNext()) {
			Jugador jugador = iterador.next();
			lista += jugador.getNombre() + ": " + jugador.getPuntaje() + "\n";
		}
		
		return lista;
	}


	private int devolverPuntaje(int[] dado) throws ValorDeDadosEx{
		
		verificarCantidadDeDadosArrojados(dado);
		
		int sumaTotal =  verificarValorDelDado(dado[0]) 
				+verificarValorDelDado(dado[1])
				+verificarValorDelDado(dado[2]);
		
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
	
	private void verificarCantidadDeDadosArrojados(int[] dado) throws ValorDeDadosEx  {
		if(dado.length != 3) {
			System.err.println("La cantidad de dados arrojados deben ser 3 y se arrojaron " + dado.length);
			throw new ValorDeDadosEx();
		}
	}
	
	private int verificarValorDelDado(int valorDelDado)throws ValorDeDadosEx {
		if(valorDelDado < VALOR_MINIMO || valorDelDado > VALOR_MAXIMO) {
			System.err.println("El valor del dado debe ser encontrarse entre " + VALOR_MINIMO + " y " + VALOR_MAXIMO + ", y se ingreso un dado con valor: " + valorDelDado );
			throw new ValorDeDadosEx();
		}
		return valorDelDado;
	}
}
