package unidadContable;

import org.junit.Assert;
import org.junit.Test;

public class IndicesSalarialesTest {
	
// IndicesSalariales
	
	@Test(expected = IllegalArgumentException.class)
	public void setearSueldoBasicoMenos1() {
		IndicesSalariales.setSueldoBasicoUR(-1);
	}
	
	@Test
	public void setearSueldoBasico1000() {
		IndicesSalariales.setSueldoBasicoUR(1000);
		Assert.assertEquals(1000.0, IndicesSalariales.getSueldoBasicoUR(),0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setearAdicionalCoyugueMenos30() {
		IndicesSalariales.setAdicionalConyugueUR(-30);
	}
	
	@Test
	public void setearAdicionalCoyugue100() {
		IndicesSalariales.setAdicionalConyugueUR(100);
		Assert.assertEquals(100.0, IndicesSalariales.getAdicionalConyugueUR(),0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setearAdicionalPorHijoMenos2() {
		IndicesSalariales.setAdicionalPorHijoUR(-2);
	}
	
	@Test
	public void setearAdicionalPorHijo200() {
		IndicesSalariales.setAdicionalPorHijoUR(200);
		Assert.assertEquals(200.0, IndicesSalariales.getAdicionalPorHijoUR(),0.01);
	}
	
	
// IndiceSalarialPermanente	
	
	@Test(expected = IllegalArgumentException.class)
	public void setearAntiguedadPorAnioMenos20() {
		IndicesSalarialesPermanente.setAdicionalPorHijoUR(-20);
	}
	
	@Test
	public void setearAntiguedadPorAnio100() {
		IndicesSalarialesPermanente.setAdicionalPorHijoUR(100);
		Assert.assertEquals(100.0, IndicesSalarialesPermanente.getAdicionalPorHijoUR(),0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setearTopeAntiguedadMenos2000() {
		IndicesSalarialesPermanente.setAdicionalPorHijoUR(-2000);
	}
	
	@Test
	public void setearTopeAntiguedad2000() {
		IndicesSalarialesPermanente.setAdicionalPorHijoUR(2000);
		Assert.assertEquals(2000.0, IndicesSalarialesPermanente.getAdicionalPorHijoUR(),0.01);
	}
	
	
// IndicesSalarialGerente
	
	@Test(expected = IllegalArgumentException.class)
	public void setearAdicionalPorEmpleadoACargoMenos2000() {
		IndicesSalarialesGerente.setAdicionalPersonalACargo(-2000);
	}
	
	@Test
	public void setearAdicionalPorEmpleadoACargo2000() {
		IndicesSalarialesGerente.setAdicionalPersonalACargo(2000);
		Assert.assertEquals(2000.0, IndicesSalarialesGerente.getAdicionalPersonalACargo(),0.01);
	}
	
	
 //IndiceSalarialParcial 	

	@Test(expected = IllegalArgumentException.class)
	public void setearHoraDeTrabajoMenos10() {
		IndicesSalarialesParciales.setHoraTrabajoParcial(-10);
	}
	
	@Test
	public void setearHoraDeTrabajo10() {
		IndicesSalarialesParciales.setHoraTrabajoParcial(10);
		Assert.assertEquals(10.0, IndicesSalarialesParciales.getHoraTrabajoParcial(),0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setearTopeDeTrabajoMenos1000() {
		IndicesSalarialesParciales.setTopeTrabajoParcial(-1000);
	}
	
	@Test
	public void setearTopeDeTrabajo1000() {
		IndicesSalarialesParciales.setTopeTrabajoParcial(1000);
		Assert.assertEquals(1000.0, IndicesSalarialesParciales.getTopeTrabajoParcial(),0.01);
	}

}
