package repaso;

import org.junit.Assert;
import org.junit.Test;

public class TestRepaso {
	
	Repaso verificarSi = new Repaso();
	
	
	@Test
	public void verificarSiLosNumerosDe0a15sonPrimos() {
		
		int numero = 0;
		Assert.assertTrue(verificarSi.esPrimo(numero));
		numero = 1;
		Assert.assertTrue(verificarSi.esPrimo(numero));
		numero = 2;
		Assert.assertTrue(verificarSi.esPrimo(numero));
		numero = 3;
		Assert.assertTrue(verificarSi.esPrimo(numero));
		numero = 4;
		Assert.assertFalse(verificarSi.esPrimo(numero));
		numero = 5;
		Assert.assertTrue(verificarSi.esPrimo(numero));
		numero = 6;
		Assert.assertFalse(verificarSi.esPrimo(numero));
		numero = 7;
		Assert.assertTrue(verificarSi.esPrimo(numero));
		numero = 8;
		Assert.assertFalse(verificarSi.esPrimo(numero));
		numero = 9;
		Assert.assertFalse(verificarSi.esPrimo(numero));
		numero = 10;
		Assert.assertFalse(verificarSi.esPrimo(numero));
		numero = 11;
		Assert.assertTrue(verificarSi.esPrimo(numero));
		numero = 12;
		Assert.assertFalse(verificarSi.esPrimo(numero));
		numero = 13;
		Assert.assertTrue(verificarSi.esPrimo(numero));
		numero = 14;
		Assert.assertFalse(verificarSi.esPrimo(numero));
		numero = 15;
		Assert.assertFalse(verificarSi.esPrimo(numero));
	}



	@Test
	public void corroborarLasSiguientesSumasDeMultiplos() {
				
		Assert.assertEquals(verificarSi.sumarMultiplosDeTresYCinco(10), 23);
		Assert.assertEquals(verificarSi.sumarMultiplosDeTresYCinco(16), 60);
		Assert.assertEquals(verificarSi.sumarMultiplosDeTresYCinco(3), 0);
		Assert.assertEquals(verificarSi.sumarMultiplosDeTresYCinco(5), 3);
	}


	@Test
	public void unirMartrices() {

		int[] a1 = {-5, 0, 0, 1, 5};
		int[] a2 = {-10, 0, 7};
		
		int[] arrayResultante = verificarSi.unirArraysOrdenados(a1, a2);
		int[] arrayEsperable = {-10, -5, 0, 0, 0, 1, 5, 7};
		
		Assert.assertArrayEquals(arrayResultante,arrayEsperable);
		
	}
	
	@Test
	public void unirMartricesMejorado() {

		int[] a1 = {-5, 0, 0, 1, 5};
		int[] a2 = {-10, 0, 7};
		
		int[] arrayResultante = verificarSi.intercalarOrdenado(a1, a2);
		int[] arrayEsperable = {-10, -5, 0, 0, 0, 1, 5, 7};
		
		Assert.assertArrayEquals(arrayResultante,arrayEsperable);
		
	}

}