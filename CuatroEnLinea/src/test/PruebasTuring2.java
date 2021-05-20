package test;

import juego.Casillero;
import juego.CuatroEnLinea;

import org.junit.Test;
import org.junit.Assert;

public class PruebasTuring2 {
	
	private CuatroEnLinea juego;
	
	@Test(expected = Error.class)
	public void seInicializarElTableroConFilasYColumnas0DaError(){
		juego = new CuatroEnLinea(0, 0, "Juan", "Pedro");
	}
	
	@Test(expected = Error.class)
	public void seInicializarElTableroConFilas0YColumnas10DaError(){
		juego = new CuatroEnLinea(0, 10, "Juan", "Pedro");
	}
	
	@Test(expected = Error.class)
	public void seInicializarElTableroConFilasMenos1YColumnasMenos1DaError(){
		juego = new CuatroEnLinea(-1, -1, "Juan", "Pedro");
	}
	
	@Test(expected = Error.class)
	public void seInicializarElTableroConFilasMenos1YColumnas5DaError(){
		juego = new CuatroEnLinea(1, 5, "Juan", "Pedro");
	}
	
	@Test(expected = Error.class)
	public void seInicializarElTableroConFilas5YColumnas3DaError(){
		juego = new CuatroEnLinea(5, 3, "Juan", "Pedro");
	}
	
	@Test(expected = Error.class)
	public void seInicializarElTableroConFilas4YColumnas3DaError(){
		juego = new CuatroEnLinea(4, 3, "Juan", "Pedro");
	}
	
	@Test(expected = Error.class)
	public void seInicializarElTableroConFilas3YColumnas4DaError(){
		juego = new CuatroEnLinea(3, 4, "Juan", "Pedro");
	}
	
	@Test(expected = Error.class)
	public void seInicializarElTableroConFilas3YColumnas8DaError(){
		juego = new CuatroEnLinea(3, 8, "Juan", "Pedro");
	}
	
	@Test(expected = Error.class)
	public void seInicializarElTableroConFilas3YColumnas3DaError(){
		juego = new CuatroEnLinea(3, 3, "Juan", "Pedro");
	}
	
	@Test
	public void seInicializarElTableroConFilas4YColumnas4NoDaError(){
		juego = new CuatroEnLinea(4, 4, "Juan", "Pedro");
	}
	
	@Test
	public void seInicializarElTableroConFilas50YColumnas25NoDaError(){
		juego = new CuatroEnLinea(50, 25, "Juan", "Pedro");
	}
	
	@Test
	public void seInicializarElTableroConFilas5YColumnas50NoDaError(){
		juego = new CuatroEnLinea(7, 8, "Juan", "Pedro");
	}
	
	@Test
	public void laPrimeraFichaDelJugadorRojoSeTiraEnLaPrimeraColumnaYQuedaEnLaFila7yColumna1(){
		juego = new CuatroEnLinea(7, 8, "Juan", "Pedro");
		juego.soltarFichaEnColumna(1);
		Casillero ficha = juego.obtenerCasillero(7,1);
		
		Assert.assertEquals(ficha,Casillero.ROJO);
	}
	
	@Test
	public void laPrimeraFichaDelJugadorRojoSeTiraEnLaUltimaColumnaYQuedaEnLaFila7yColumna8(){
		juego = new CuatroEnLinea(7, 8, "Juan", "Pedro");
		juego.soltarFichaEnColumna(8);
		Casillero ficha = juego.obtenerCasillero(7,8);
		
		Assert.assertEquals(ficha,Casillero.ROJO);
	}
	
	@Test
	public void hay3FichasRojasConsecutivasTodasEnLaColumna1Y2FichasAmarillasEnLaColumna2NoTerminoLaPartida(){
		juego = new CuatroEnLinea(7, 8, "Juan", "Pedro");
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(1);
		
		boolean termino= juego.termino();
		
		Assert.assertFalse(termino);
	}
	
	@Test
	public void hay3FichasRojasConsecutivasTodasEnLaColumna1Otras2FichasAmarillasEnLaColumna2YUnaUltimaFichaAmarillaEnLaColumna1NoTerminoLaPartida(){
		juego = new CuatroEnLinea(7, 8, "Juan", "Pedro");
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(1);
		
		boolean termino= juego.termino();
		
		Assert.assertFalse(termino);
	}
	
	@Test
	public void hay4FichasRojasConsecutivasTodasEnLaColumna1Y3FichasAmarillasEnLaColumna2TerminoLaPartida(){
		juego = new CuatroEnLinea(7, 8, "Juan", "Pedro");
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(1);
		
		boolean termino= juego.termino();
		
		Assert.assertTrue(termino);
	}
}