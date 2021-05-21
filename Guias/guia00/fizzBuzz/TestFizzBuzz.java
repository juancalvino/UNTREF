package fizzBuzz;
import org.junit.Assert;
import org.junit.Ignore;

public class TestFizzBuzz {
	FizzBuzz juego = new FizzBuzz();

	@Ignore
	public void devolverPrimeros100Numeros() {
	Assert.assertEquals(100, juego.devolverPimerosCienEmpezandoEn(0));
	}
	
	@Ignore
	public void devolverPrimerosEmpezandoPor3() {
	Assert.assertEquals(103, juego.devolverPimerosCienEmpezandoEn(3));
	}

	@Ignore
	public void devolverPrimerosEmpezandoPorMenos3() {
	Assert.assertEquals(97, juego.devolverPimerosCienEmpezandoEn(-3));
	}
}
