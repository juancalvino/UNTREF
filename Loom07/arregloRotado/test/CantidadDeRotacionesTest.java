package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ArregloRotado.ContadorDeRotaciones;

public class CantidadDeRotacionesTest {

	ContadorDeRotaciones arregloCircular = new ContadorDeRotaciones();
	int promedio;

	private double logDe(int num) {
		return (Math.log(num) / Math.log(2));
	}

	@Test(expected = NullPointerException.class)
	public void arregloNull() {
		int[] arreglo = null;
		arregloCircular.devloverCantidadDeRotaciones(arreglo);
	}

	@Test
	public void arregloDe1Numero() {
		int[] arreglo = { 20 };
		assertEquals(0, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe2NumerosConsecutivosInicioPosicion0() {
		int[] arreglo = { 1, 2 };
		assertEquals(0, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe2NumerosConsecutivosInicioPosicion1() {
		int[] arreglo = { 2, 1 };
		assertEquals(1, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe6NumerosNaturalesConsecutivosInicioPosicion0() {
		int[] arreglo = { 1, 2, 3, 4, 5, 6 };
		assertEquals(0, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe6NumerosNaturalesConsecutivosInicioPosicion1() {
		int[] arreglo = { 6, 1, 2, 3, 4, 5 };
		assertEquals(-1, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe6NumerosNaturalesConsecutivosInicioPosicion2() {
		int[] arreglo = { 5, 6, 1, 2, 3, 4 };
		assertEquals(-2, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe6NumerosNaturalesConsecutivosInicioPosicion3() {
		int[] arreglo = { 4, 5, 6, 1, 2, 3 };
		assertEquals(3, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe6NumerosNaturalesConsecutivosInicioPosicion4() {
		int[] arreglo = { 3, 4, 5, 6, 1, 2 };
		assertEquals(2, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe6NumerosNaturalesConsecutivosInicioPosicion5() {
		int[] arreglo = { 2, 3, 4, 5, 6, 1 };
		assertEquals(1, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe11NumerosNaturalesConsecutivosInicioPosicion3() {
		int[] arreglo = { 9, 10, 11, 1, 2, 3, 4, 5, 6, 7, 8 };
		assertEquals(-3, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe17NumerosNaturalesConsecutivosInicioPosicion10() {
		int[] arreglo = { 9, 10, 11, 12, 13, 14, 15, 16, 17, 1, 2, 3, 4, 5, 6, 7, 8 };
		assertEquals(8, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe33NumerosNaturalesConsecutivosInicioPosicion29() {
		int[] arreglo = { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
				30, 31, 32, 33, 1, 2, 3, 4 };
		assertEquals(4, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe33NumerosNaturalesConsecutivosInicioPosicion0() {
		int[] arreglo = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, 31, 32, 33 };
		assertEquals(0, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe33NumerosNaturalesConsecutivosInicioPosicion32() {
		int[] arreglo = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, 31, 32, 33, 1 };
		assertEquals(1, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe8NumerosNegativosNoConsecutivosInicioPosicion2() {
		int[] arreglo = { -3, -2, -20, -15, -10, -5, -4 };
		assertEquals(-2, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe6NumerosNaturalesNoConsecutivosInicioPosicion4() {
		int[] arreglo = { 8, 9, 10, 2, 4, 6 };
		assertEquals(3, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe12NumerosNaturalesNoConsecutivosInicioPosicion3() {
		int[] arreglo = { 17, 21, 23, 1, 3, 5, 7, 8, 9, 11, 13 };
		assertEquals(-3, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe6NumerosEnterosNoConsecutivosInicioPosicion5() {
		int[] arreglo = { 2, 3, 4, 5, 6, -6, -5, 1 };
		assertEquals(3, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

	@Test
	public void arregloDe8NumerosNegativosConsecutivosInicioPosicion3() {
		int[] arreglo = { -3, -2, -1, -8, -7, -6, -5, -4 };
		assertEquals(-3, (arregloCircular.devloverCantidadDeRotaciones(arreglo)));
		assertTrue(arregloCircular.contador <= logDe(arreglo.length));
	}

}
