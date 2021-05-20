package tDD;
import org.junit.Test;
import org.junit.Assert;

public class TestSumaMultiplos3y5 {

	Ejercicios calcular =  new Ejercicios(); 

	@Test
	public void calcularLaSumaHasta10() {
		int suma = calcular.sumarMultiplosTresYCinco(10);
		Assert.assertEquals(23, suma);
	}

	@Test
	public void calcularLaSumaHasta12() {
		Assert.assertEquals(33, calcular.sumarMultiplosTresYCinco(12));
	}
	
	@Test(expected = Error.class)
	public void calcularLaSumaHastaMenos12() {
		calcular.sumarMultiplosTresYCinco(-12);
	}
	
	@Test
	public void calcularLaSumaHasta1000() {
		Assert.assertEquals(233168, calcular.sumarMultiplosTresYCinco(1000));
	}

}
