package test;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import juego.CuatroEnLinea;


public class PruebasTuring {

	private CuatroEnLinea juego;
	
	
	// Cuatro en linea HORIZONTAL
	
    @Test
    public void creaFilaHorizontalDeCuatroFichasIgualesComenzandoDeLaColumna1HaciaLaDerecha() {
    	
    	juego = new CuatroEnLinea(4, 4, "Maria", "Laura");
    	fueronSoltadasFichasEnColumnas(1,1,2,2,3,3);
    	
    	juego.soltarFichaEnColumna(4);
    	
    	assertEquals(true, juego.hayGanador());
    	
    }
	
    
    @Test
    public void creaFilaHorizontalDeCuatroFichasIgualesComenzandoDeLaColumna5HaciaLaIzquierda() {
    	
    	juego = new CuatroEnLinea(10, 7, "Hernan", "Juan");
    	fueronSoltadasFichasEnColumnas(5,5,4,4,3,3);
    	
    	juego.soltarFichaEnColumna(2);
    	
    	assertEquals(true, juego.hayGanador());
    	
    }
    
    
    @Test
    public void soltarFichaRojaEnLaColumna6TeniendoHaciaLaDerecha1FichaRojaYHaciaALaIzquierda2FichasRojas() {
    	
    	juego = new CuatroEnLinea(10, 8, "Hernan", "Juan");
    	fueronSoltadasFichasEnColumnas(5,5,7,1,8,3);
    	
    	juego.soltarFichaEnColumna(6);
    	
    	assertEquals(true, juego.hayGanador());
    	
    }
    
    
    @Test
    public void soltarFichaAmarillaEnLaUltimaColumnaYApartirDeEsaPosicionHaciaLaIzquieraSeEncuentran3FichasAmarillas() {
    	
    	juego = new CuatroEnLinea(10, 8, "Hernan", "Juan");
    	fueronSoltadasFichasEnColumnas(1,5,1,7,2,6,1);
    	
    	juego.soltarFichaEnColumna(8);
    	
    	assertEquals(true, juego.hayGanador());
    	
    }
    
    private void fueronSoltadasFichasEnColumnas(int... columnas) {

   	for (int columna : columnas) {
   		juego.soltarFichaEnColumna(columna);
   	}
   }
    
    
    
    
	
}
