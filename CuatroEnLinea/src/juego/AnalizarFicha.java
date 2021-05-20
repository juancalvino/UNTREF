package juego;

public class AnalizarFicha {
	
	private Casillero[][] tablero;
	private int filasDelTablero;
	private int columnasDelTablero;
	
	private int fila;
	private int columna;
	
	private int filaSiguiente;
	private int columnaSiguiente;
	
	/**
	 * pre: el juego no termino, comlumna esta en el intervalo [1,contarColumnas()],
	 * filas esta en el intervalo [1,contarFilas()] y aun queda Casilleros.VACIO en
	 * el tablero.
	 * 
	 * post: devuelve si hay 4 fichas consecutivas tanto en sentido vertical, horizontal o diagonal.
	 */
	
	public AnalizarFicha(Casillero[][] tablero, int fila, int columna) {
		
		this.tablero = tablero;	
		this.columnasDelTablero = tablero[0].length;
		this.filasDelTablero = tablero.length;
		
		this.fila = fila;
		this.columna = columna;
		
	}
	
	
	public boolean calcularCuatroEnLinea() {
	
		int vertical = 1 + analizarAumentando(1,0);
		int horizontal = 1 + analizarAumentando(0,1) + analizarAumentando(0,-1);
		int diagonalUno = 1 + analizarAumentando(1,1) + analizarAumentando(-1,-1);
		int diagonalDos = 1 + analizarAumentando(1,-1) + analizarAumentando(-1,1);
		
		return (vertical>3) || (horizontal>3) || (diagonalUno>3) || (diagonalDos>3);

	}
	
	
	private int analizarAumentando(int filas, int columnas) {
		
		int fichasConsecutivas = 0;
		
		filaSiguiente = fila + filas;
		columnaSiguiente = columna + columnas;
			
			while ( seguirAvanzando() &&  seguirContando(fichasConsecutivas)) {
	
					fichasConsecutivas++;
					filaSiguiente+=filas;
					columnaSiguiente += columnas;
				 
			}
			
		return fichasConsecutivas;
	}	
	
	
	private boolean seguirAvanzando() {
		
		if( (filaSiguiente >= 0) && (filaSiguiente< filasDelTablero) 
				&& (columnaSiguiente>=0) && (columnaSiguiente < columnasDelTablero)) 
			return true;
	
	 return false;
	
	}
	
	
	private boolean seguirContando(int fichasConsecutivas) {
		
		if((tablero[fila][columna] == siguienteCasillero()) && fichasConsecutivas<4) 
			return true;
		
		
	 return false;
		
	}

	
	private Casillero siguienteCasillero () {

		return tablero[filaSiguiente][columnaSiguiente];
	}
	
	
	
}