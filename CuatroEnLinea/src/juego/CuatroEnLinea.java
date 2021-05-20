package juego;

/**
 * Juego Cuatro en L�nea
 * 
 * Reglas:
 * 
 * 		...
 *
 */
public class CuatroEnLinea {
	
	
	private int filas;
	private int columnas;
	private String jugadorRojo;
	private String jugadorAmarillo;
	private boolean turnoRojo = false;
	private boolean termino = false;
	private boolean hayGanador = false;
	private int casillerosLibres;
	
	private Casillero[][] tablero;

	/**
	 * pre : 'filas' y 'columnas' son mayores o iguales a 4.
	 * post: empieza el juego entre el jugador que tiene fichas rojas, identificado como 
	 * 		 'jugadorRojo' y el jugador que tiene fichas amarillas, identificado como
	 * 		 'jugadorAmarillo'. 
	 * 		 Todo el tablero est� vac�o.
	 * 
	 * @param filas : cantidad de filas que tiene el tablero.
	 * @param columnas : cantidad de columnas que tiene el tablero.
	 * @param jugadorRojo : nombre del jugador con fichas rojas.
	 * @param jugadorAmarillo : nombre del jugador con fichas amarillas.
	 */
	public CuatroEnLinea(int filas, int columnas, String jugadorRojo, String jugadorAmarillo) {
		
		if((filas >=4) && (columnas >= 4)) {
			
			
			this.filas = filas;
			this.columnas = columnas;
			this.jugadorRojo = jugadorRojo;
			this.jugadorAmarillo = jugadorAmarillo;
			this.turnoRojo = true;
			this.casillerosLibres = filas * columnas;
		
			this.tablero = new Casillero[filas][columnas];
			inicializarTablero();
		}
		else {throw new Error ("Las filas y columnas deben ser mayores igual a 4"); }
	
	}
		
	private void inicializarTablero() {
		
			
			for(int j=0; j< filas; j++) {
				
				for(int i=0; i<columnas; i++) {

					tablero[j][i] = Casillero.VACIO;
					
				}
			}
			
	}


	/**
	 * post: devuelve la cantidad m�xima de fichas que se pueden apilar en el tablero.
	 */
	public int contarFilas() {
		
		return filas;
	}

	/**
	 * post: devuelve la cantidad m�xima de fichas que se pueden alinear en el tablero.
	 */
	public int contarColumnas() {
		return columnas;
	}

	/**
	 * pre : fila est� en el intervalo [1, contarFilas()],
	 * 		 columnas est� en el intervalo [1, contarColumnas()].
	 * post: indica qu� ocupa el casillero en la posici�n dada por fila y columna.
	 * 
	 * @param fila
	 * @param columna
	 */
	public Casillero obtenerCasillero(int fila, int columna) {
		
		if ((fila < 1) || (fila > filas)) {
			throw new Error ("Fila fuera de rango: " + fila);
		
		} else if ((columna < 1) || (columna > columnas)) {
			throw new Error ("Columna fuera de rango: " + columna);
		
		} else {
			return tablero [fila - 1][columna - 1];
		}
		
	}
	
	/**
	 * pre : el juego no termin�, columna est� en el intervalo [1, contarColumnas()]
	 * 		 y a�n queda un Casillero.VACIO en la columna indicada. 
	 * post: deja caer una ficha en la columna indicada.
	 * 
	 * @param columna
	 */
	

	public void soltarFichaEnColumna(int columna) {
		
		int fila = ultimaFilaVacia(columna);
		Casillero casilleroSeleccionado = tablero[fila][columna-1];
		AnalizarFicha jugador = new AnalizarFicha(tablero, fila, columna-1);
		

		if((casilleroSeleccionado == Casillero.VACIO) 
				&& (!termino)) {
			
			if (turnoRojo) {			
				tablero[fila][columna-1] = Casillero.ROJO;
			}
			else {
				tablero[fila][columna-1] = Casillero.AMARILLO;
			}
			
			cambioDeTurno();
			casillerosLibres--;
		}

		
		if(casillerosLibres <=0){
			termino = true;
		}
		
		if( jugador.calcularCuatroEnLinea()) {	
			hayGanador = true;
			termino = true;
		}
		
		
	}
	
	private int ultimaFilaVacia(int columna) {
		
		int ultimaFilaVacia = tablero.length - 1;
		Casillero ultimoCasillero = tablero[ultimaFilaVacia][columna-1] ;
		
		while (( ultimoCasillero != Casillero.VACIO) 
				&& (ultimaFilaVacia != 0)) {
			
			ultimaFilaVacia--;
			ultimoCasillero = tablero[ultimaFilaVacia][columna-1] ;
		}
		
		return  ultimaFilaVacia;
		
	}

	
	private void cambioDeTurno() {
		
		if (turnoRojo) {
			turnoRojo = false;
			
		} else {
			turnoRojo = true;
		}		
	}
	

	
	/**
	 * post: indica si el juego termin� porque uno de los jugadores
	 * 		 gan� o no existen casilleros vac�os.
	 */
	public boolean termino() {
		
		return termino;
	}

	/**
	 * post: indica si el juego termin� y tiene un ganador.
	 */
	public boolean hayGanador() {
		
		if(!hayGanador){
			System.out.println("no hay ganador");
		}
		
		return hayGanador;
	}

	/**
	 * pre : el juego termin�.
	 * post: devuelve el nombre del jugador que gan� el juego.
	 */
	public String obtenerGanador() {
		
		if(hayGanador) {
			if (turnoRojo) {
				return jugadorAmarillo;
			} 
			else {
				return jugadorRojo;
			}
		}
		
		else {
			System.out.println("no existe el ganador");
			}
		
		return null;
	}
}