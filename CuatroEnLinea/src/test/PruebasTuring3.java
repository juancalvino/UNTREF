package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import juego.Casillero;
import juego.CuatroEnLinea;
import org.junit.Test;

public class PruebasTuring3 {
	
	private CuatroEnLinea juego;
	
	@Test
	public void soltarPrimerFichaEnColumna0LaDejaEnLaUltimaFila() {
		
		juego = new CuatroEnLinea(6, 5, "Maria", "Fernando");
		juego.soltarFichaEnColumna(1);
		
		asertarFichaRojaEn(6, 1);
		
	}
	
	@Test (expected = Error.class)
	public void soltarPrimerFichaEnColumna1YAsertarFilaMenos1LanzaExcepcion() {
		
		juego = new CuatroEnLinea(6, 5, "Antonio", "Lucas");
		juego.soltarFichaEnColumna(1);
		
		asertarFichaRojaEn(-1, 1);
		
		
	}
	
	@Test (expected = Error.class)
	public void soltarPrimerFichaEnColumna1YAsertarFila2LanzaExcepcion() {
		
		juego = new CuatroEnLinea(6, 5, "Antonio", "Lucas");
		juego.soltarFichaEnColumna(1);
		
		asertarFichaRojaEn(2, 1);
		
		
	}
	
	@Test
	public void probarQueDiagonalOeste1NoHayCuatroEnLinea() {
		
		juego = new CuatroEnLinea(6, 5, "Javier", "Fernanda");
		
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(4);
		
		asertarQueNoHayGanadorAun();
	}
	
	@Test
	public void probarQueDiagonalOeste2NoHayCuatroEnLinea() {
		
		juego = new CuatroEnLinea(6, 5, "Martin", "Raul");
		
		juego.soltarFichaEnColumna(2);
		soltarFichasEnColumna(6, 3, juego);
		soltarFichasEnColumna(4, 2, juego);
		soltarFichasEnColumna(4, 1, juego);
		
		asertarQueNoHayGanadorAun();
		
	}
	
	@Test
	public void probarQueDiagonalOeste3HayCuatroEnLineaYGanaJavier() {
		
		juego = new CuatroEnLinea(6, 5, "Javier", "Fernanda");
		
		juego.soltarFichaEnColumna(3);
		soltarFichasEnColumna(6, 4, juego);
		soltarFichasEnColumna(4, 3, juego);
		soltarFichasEnColumna(4, 2, juego);
		soltarFichasEnColumna(2, 1, juego);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(1);
		
		asertarQueElGanadorEs("Javier");
		
	}
	
	@Test
	public void probarQueDiagonalOeste4HayCuatroEnLineaYGanaNati() {
		
		juego = new CuatroEnLinea(6, 5, "Nati", "Rocio");
		
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(1);
		soltarFichasEnColumna(3, 3, juego);
		soltarFichasEnColumna(4, 2, juego);
		asertarQueElGanadorEs("Nati");
		
	}
	
	@Test
	public void probarQueDiagonalOeste5NoHayCuatroEnLinea() {
		
		juego = new CuatroEnLinea(6, 5, "Nacho", "Jorge");
		
		juego.soltarFichaEnColumna(2);
		soltarFichasEnColumna(4, 1, juego);
		soltarFichasEnColumna(6, 3, juego);
		juego.soltarFichaEnColumna(4);
		soltarFichasEnColumna(4, 2, juego);
		
		asertarQueNoHayGanadorAun();
		
	}
	
	@Test
	public void probarQueDiagonalOeste6NoHayCuatroEnLinea() {
		
		juego = new CuatroEnLinea(6, 5, "Ricky", "Flavio");
		
		juego.soltarFichaEnColumna(3);
		soltarFichasEnColumna(3, 5, juego);
		soltarFichasEnColumna(2, 4, juego);
		
		asertarQueNoHayGanadorAun();
		
	}
	
	@Test
	public void probarQueDiagonalOeste7GanaAlberto() {
		
		juego = new CuatroEnLinea(6, 5, "Alberto S", "Mauro V");
		
		soltarFichasEnColumna(6, 1, juego);
		soltarFichasEnColumna(6, 2, juego);
		soltarFichasEnColumna(6, 3, juego);
		juego.soltarFichaEnColumna(4);
		
		asertarQueElGanadorEs("Alberto S");
		
	}	
	
	private void soltarFichasEnColumna(int fichas, int columna, CuatroEnLinea juego) {
		
		for(int i = 0; i < fichas; i++) {
			juego.soltarFichaEnColumna(columna);
		}
		
	}
	
    private void asertarCasilleroEn(int fila, int columna, Casillero casillero) {
        
        assertEquals("casillero (" + fila + ", " + columna + ")", 
                     casillero, juego.obtenerCasillero(fila, columna));
    }
    
    private void asertarFichaRojaEn(int fila, int columna) {
        
        asertarCasilleroEn(fila, columna, Casillero.ROJO);
    }
    
	
    private void asertarQueElGanadorEs(String ganadorEsperado) {
		
		assertTrue("terminó", juego.termino());
		assertTrue("hay ganador", juego.hayGanador());
		assertEquals("ganador", ganadorEsperado, juego.obtenerGanador());
	}
    
    private void asertarQueNoHayGanadorAun() {
		
		assertFalse("terminó", juego.termino());
		assertFalse("no hay ganador", juego.hayGanador());
		assertNull("ganador", juego.obtenerGanador());
	}
	
}
