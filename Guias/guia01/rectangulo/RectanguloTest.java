package rectangulo;
import org.junit.Assert;
import org.junit.Test;

public class RectanguloTest {
	Rectangulo rectangulo;
	
	@Test(expected = Error.class )
	public void crearClaseCon2AtributosEnterosCeroYCero() {
		rectangulo = new Rectangulo(0,0);
	}
	
	@Test
	public void crearClaseCon2AtributosEnteros() {
		rectangulo = new Rectangulo(1,1);
	}
	
	@Test
	public void crearClaseCon4AtributosEnteros() {
		rectangulo = new Rectangulo(1,1,1,1);
	}
	
	@Test(expected = Error.class)
	public void calcularElAreaDelCuadradoDeLado0() {
		rectangulo = new Rectangulo(0,0,1,1);
		Assert.assertEquals(0,rectangulo.calcularArea());
	}
	
	@Test
	public void calcularElAreaDelCuadradoDeLado1() {
		rectangulo = new Rectangulo(1,1,1,1);
		Assert.assertEquals(1,rectangulo.calcularArea());
	}

	@Test
	public void calcularElAreaDelCuadradoDeLado2() {
		rectangulo = new Rectangulo(2,2,2,2);
		Assert.assertEquals(4,rectangulo.calcularArea());
	}

	@Test
	public void calcularElAreaDelCuadradoDeLado2InicioEnEspacio0() {
		rectangulo = new Rectangulo(0,0,2,2);
		Assert.assertEquals(4,rectangulo.calcularArea());
	}
	
	@Test(expected = Error.class)
	public void calcularElAreaDelRectanguloDeLado0y5InicioEnEspacio0() {
		rectangulo = new Rectangulo(0,0,0,5);
		Assert.assertEquals(0,rectangulo.calcularArea());
	}
	
	@Test(expected = Error.class)
	public void calcularElAreaDelRectanguloDeLadoMenos3y5InicioEnEspacio0() {
		rectangulo = new Rectangulo(0,0,-3,5);
		Assert.assertEquals(-15,rectangulo.calcularArea());
	}
	
	@Test
	public void calcularElAreaDelRectanguloDeLado2y5InicioEnEspacio0() {
		rectangulo = new Rectangulo(0,0,2,5);
		Assert.assertEquals(10,rectangulo.calcularArea());
	}
	
	@Test
	public void calcularElAreaDelRectanguloDeLado2y5InicioEnEspacio3x2y() {
		rectangulo = new Rectangulo(3,2,2,5);
		Assert.assertEquals(10,rectangulo.calcularArea());
	}
	
	@Test
	public void devoverPosicionDelRectanguloUbicadoen3X4Y(){
		rectangulo = new Rectangulo(3,4,2,5);
		Assert.assertEquals("(3,4)", rectangulo.devolverPosicion());
	}
	
	@Test
	public void devoverPosicionDelRectanguloUbicadoen0X0Y(){
		rectangulo = new Rectangulo(0,0,2,5);
		Assert.assertEquals("(0,0)", rectangulo.devolverPosicion());
	}
	
	@Test
	public void devoverPosicionDelRectanguloUbicadoenMenos2X0Y(){
		rectangulo = new Rectangulo(-2,0,2,5);
		Assert.assertEquals("(-2,0)", rectangulo.devolverPosicion());
	}
	
	@Test
	public void cambiarPosicionDelCuboDe0X0YA2X1Y() {
		rectangulo = new Rectangulo(0, 0, 2, 2);
		rectangulo.cambiarDePosicion(2,1);
		Assert.assertEquals("(2,1)",rectangulo.devolverPosicion());
	}
	
	@Test
	public void cambiarPosicionDelCuboDe0X0YAMenos2X0Y() {
		rectangulo = new Rectangulo(0, 0, 2, 2);
		rectangulo.cambiarDePosicion(-2,0);
		Assert.assertEquals("(-2,0)",rectangulo.devolverPosicion());
	}
	
	@Test
	public void elRectanguloDeArea6ContieneElPunto0X0Y() {
		rectangulo = new Rectangulo(3, 2);
		Assert.assertTrue(rectangulo.contieneElPunto(0,0));
	}
	
	@Test
	public void elRectanguloDeArea6NoContieneElPunto3X3Y() {
		rectangulo = new Rectangulo(3, 2);
		Assert.assertFalse(rectangulo.contieneElPunto(3,3));
	}
	
	@Test
	public void elRectanguloDeArea6Posicion0X0YNoContieneElPuntoMenos3X3Y() {
		rectangulo = new Rectangulo(0,0,3,2);
		Assert.assertFalse(rectangulo.contieneElPunto(-3,3));
	}

	@Test
	public void elRectanguloDeArea9PosicionMenos4X2YContieneElPuntoMenos3X3Y() {
		rectangulo = new Rectangulo(-4,2,3,3);
		Assert.assertTrue(rectangulo.contieneElPunto(-3,3));
	}
	
	@Test
	public void elRectanguloDeArea9Posicion4XMenos2YContieneElPunto4X1Y() {
		rectangulo = new Rectangulo(4,-2,3,3);
		Assert.assertTrue(rectangulo.contieneElPunto(4,1));
	}
	
	@Test
	public void elRectanguloDeArea9Posicion4XMenos2YContieneElPunto5XMenos1Y() {
		rectangulo = new Rectangulo(4,-2,3,3);
		Assert.assertTrue(rectangulo.contieneElPunto(5,-1));
	}
	
	@Test
	public void elRectanguloDeArea9Posicion4XMenos2YContieneElPunto0X0Y() {
		rectangulo = new Rectangulo(4,-2,3,3);
		Assert.assertFalse(rectangulo.contieneElPunto(0,0));
	}
	
	@Test
	public void elRectanguloDeArea9PosicionMenos4X2YContieneElPunto0X0Y() {
		rectangulo = new Rectangulo(-4,2,3,3);
		Assert.assertFalse(rectangulo.contieneElPunto(0,0));
	}
}
