package unidadContable;

import org.junit.Assert;
import org.junit.Test;


public class UnidadRetributivaTest {

	@Test(expected = IllegalArgumentException.class)
	public void setearElValorConMenos20() {
		UnidadRetributiva.setValorActual(-20);
	}
	
	public void setearElValorCon30() {
		UnidadRetributiva.setValorActual(30);
		Assert.assertEquals( 30, UnidadRetributiva.getValorActual(), 0.1);
	}
}
