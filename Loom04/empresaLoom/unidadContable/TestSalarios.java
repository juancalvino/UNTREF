package unidadContable;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;


public class TestSalarios {

	/**
	 * 
	 * @param antiguedad debe ser mayor que 0
	 * @return
	 */
	
	public Date cerateAntiguedad(int antiguedad) {
		if(antiguedad<0)
			throw new IllegalArgumentException("La antiguedad ingresada debe ser mayor que 0");
			
		long unAnioEnMs = 31556900000L;
		
		return new Date(System.currentTimeMillis()-(unAnioEnMs*antiguedad));
	}
	
//SalarioBasico	
	
	@Test
	public void calcularSalarioBasicoSinFamilia() {
		SalarioBasico salario = new SalarioBasico(false, 0);
		
		double esperado = IndicesSalariales.getSueldoBasicoUR()
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	@Test
	public void calcularSalarioBasicoConConyugue() {
		SalarioBasico salario = new SalarioBasico(true, 0);
		
		double esperado = (IndicesSalariales.getSueldoBasicoUR()
						  +IndicesSalariales.getAdicionalConyugueUR())
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	@Test
	public void calcularSalarioBasicoConConyugueY2Hijos() {
		SalarioBasico salario = new SalarioBasico(true, 2);
		
		double esperado = (IndicesSalarialesPermanente.getSueldoBasicoUR()
						  +IndicesSalarialesPermanente.getAdicionalConyugueUR()
						  +IndicesSalarialesPermanente.getAdicionalPorHijoUR()*2)
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calcularSalarioPermanenteConConyugueYMenos2Hijos() {
		new SalarioBasico(false, -2);		
	}

	
//SalarioPermanente 	
	
	@Test
	public void calcularSalarioPermanenteSinFamiliaSinAntiguedad() {
		SalarioPermanente salario = new SalarioPermanente(false, 0, cerateAntiguedad(0));
		
		double esperado = IndicesSalarialesPermanente.getSueldoBasicoUR()
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
			
	@Test
	public void calcularSalarioPermanenteConConyugueSinAntiguedad() {
		SalarioPermanente salario = new SalarioPermanente(true, 0, cerateAntiguedad(0));
		
		double esperado = (IndicesSalarialesPermanente.getSueldoBasicoUR()
						  +IndicesSalarialesPermanente.getAdicionalConyugueUR())
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	@Test
	public void calcularSalarioPermanenteConConyugueY2HijosSinAntiguedad() {
		SalarioPermanente salario = new SalarioPermanente(true, 2, cerateAntiguedad(0));
		
		double esperado = (IndicesSalarialesPermanente.getSueldoBasicoUR()
						  +IndicesSalarialesPermanente.getAdicionalConyugueUR()
						  +IndicesSalarialesPermanente.getAdicionalPorHijoUR()*2)
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calcularSalarioPermanenteConConyugueYMenos2HijosSinAntiguedad() {
		new SalarioPermanente(false, -2, new Date(System.currentTimeMillis()));		
	}

	@Test
	public void calcularSalarioPermanenteSinConyugue1HijoSinAntiguedad() {
		SalarioPermanente salario = new SalarioPermanente(false, 1,cerateAntiguedad(0));
				
		double esperado = (IndicesSalarialesPermanente.getSueldoBasicoUR()
						  +IndicesSalarialesPermanente.getAdicionalPorHijoUR()*1)
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	@Test
	public void calcularSalarioPermanenteSinConyugue1HijoCon100AniosAntiguedad() {
		SalarioPermanente salario = new SalarioPermanente(false, 1, cerateAntiguedad(100));
		
		double esperado = (IndicesSalarialesPermanente.getSueldoBasicoUR()
						  +IndicesSalarialesPermanente.getAdicionalPorHijoUR()*1
						  +IndicesSalarialesPermanente.getTopeDeAntiguedadUR())
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	@Test
	public void calcularSalarioPermanenteSinConyugue3Hijo3AniosAntiguedad() {
		SalarioPermanente salario = new SalarioPermanente(false, 3, cerateAntiguedad(3));
		
		double esperado = (IndicesSalarialesPermanente.getSueldoBasicoUR()
						  +IndicesSalarialesPermanente.getAdicionalPorHijoUR()*3
						  +IndicesSalarialesPermanente.getAdicionalAntiguedadXAnioUR()*3)
				
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}

	
//SalarioPermanenteParcial	
	
	@Test
	public void calcularSalarioPermanenteParcialSinConyugue1HijoSinAntiguedad60HorasTrabajadas() {
		SalarioParcialPermanente salario = new SalarioParcialPermanente(false, 1, cerateAntiguedad(0),60);
		
		double esperado = (IndicesSalarialesParciales.getSueldoBasicoUR()
						  +IndicesSalarialesParciales.getAdicionalPorHijoUR()*1
						  +IndicesSalarialesParciales.getHoraTrabajoParcial()*60)
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	@Test
	public void calcularSalarioPermanenteParcialConConyugue3HijosCon100AniosAntiguedad20HorasTrabajadas() {
		SalarioParcialPermanente salario = new SalarioParcialPermanente(true, 3, cerateAntiguedad(100),20);
		
		double esperado = (IndicesSalarialesParciales.getSueldoBasicoUR()
						  +IndicesSalarialesParciales.getAdicionalConyugueUR()
						  +IndicesSalarialesParciales.getAdicionalPorHijoUR()*3
						  +IndicesSalarialesPermanente.getTopeDeAntiguedadUR()
						  +IndicesSalarialesParciales.getHoraTrabajoParcial()*20)
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	public void calcularSalarioPermanenteParcialSinFamiliaCon10AniosAntiguedadMenos30HorasTrabajadas() {
		new SalarioParcialPermanente(false, 0,cerateAntiguedad(10),-30);		
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void calcularSalarioPermanenteParcialSinFamiliaConMenos10AniosAntiguedad30HorasTrabajadas() {
		new SalarioParcialPermanente(false, 0,cerateAntiguedad(-10),30);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calcularSalarioPermanenteParcialConConyugueYMenos2HijosSinAntiguedad20HorasTrabajadas() {
		new SalarioParcialPermanente(false, -2, cerateAntiguedad(0), 20);		
	}
	
	@Test
	public void calcularSalarioPermanenteParcialConConyugue3HijosCon3AniosAntiguedad1000HorasTrabajadas() {
		SalarioParcialPermanente salario = new SalarioParcialPermanente(true,3,cerateAntiguedad(3),1000);
		
		double esperado = (IndicesSalarialesParciales.getTopeTrabajoParcial()
						  +IndicesSalarialesParciales.getAdicionalConyugueUR()
						  +IndicesSalarialesParciales.getAdicionalPorHijoUR()*3
						  +IndicesSalarialesPermanente.getAdicionalAntiguedadXAnioUR()*3)
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}

	
//SalarioParcial	
	
	public void calcularSalarioParcialSinConyugue1Hijo60HorasTrabajadas() {
		SalarioParcial salario = new SalarioParcial(false,1 ,60);
		
		double esperado = (IndicesSalarialesParciales.getSueldoBasicoUR()
						  +IndicesSalarialesParciales.getAdicionalPorHijoUR()*1
						  +IndicesSalarialesParciales.getHoraTrabajoParcial()*60)
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	@Test
	public void calcularSalarioParcialConConyugue3Hijos20HorasTrabajadas() {
		SalarioParcial salario = new SalarioParcial(true,3,20);
		
		double esperado = (IndicesSalarialesParciales.getSueldoBasicoUR()
						  +IndicesSalarialesParciales.getAdicionalConyugueUR()
						  +IndicesSalarialesParciales.getAdicionalPorHijoUR()*3
						  +IndicesSalarialesParciales.getHoraTrabajoParcial()*20)
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	public void calcularSalarioParcialSinFamiliaMenos30HorasTrabajadas() {
		new SalarioParcial(false,0,-30);		
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void calcularSalarioParcialConConyugueYMenos2Hijos20HorasTrabajadas() {
		new SalarioParcial(false, -2, 20);		
	}
	
	@Test
	public void calcularSalarioParcialConConyugue3Hijos1000HorasTrabajadas() {
		SalarioParcial salario = new SalarioParcial(true,3,1000);
		
		double esperado = (IndicesSalarialesParciales.getTopeTrabajoParcial()
						  +IndicesSalarialesParciales.getAdicionalConyugueUR()
						  +IndicesSalarialesParciales.getAdicionalPorHijoUR()*3)
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	
//SalarioGerente
	
	@Test
	public void calcularSalarioGerenteSinFamiliaSinAntiguedad() {
		SalarioGerente salario = new SalarioGerente(false, 0, cerateAntiguedad(0));
		
		double esperado =(IndicesSalarialesGerente.getSueldoBasicoUR()
						 +IndicesSalarialesGerente.getAdicionalPersonalACargo())
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calcularSalarioGerenseSinFamiliaConAntiguedadMenos10() {
		new SalarioGerente(false, 0, cerateAntiguedad(-10));		
	}
			
	@Test
	public void calcularSalarioGerenteConConyugueSinAntiguedad() {
		SalarioGerente salario = new SalarioGerente(true, 0, cerateAntiguedad(0));
		
		double esperado = (IndicesSalarialesGerente.getSueldoBasicoUR()
						  +IndicesSalarialesGerente.getAdicionalPersonalACargo()
						  +IndicesSalarialesGerente.getAdicionalConyugueUR())
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	@Test
	public void calcularSalarioGerenteConConyugueY2HijosSinAntiguedad() {
		SalarioGerente salario = new SalarioGerente(true, 2, cerateAntiguedad(0));
		
		double esperado = (IndicesSalarialesGerente.getSueldoBasicoUR()
						  +IndicesSalarialesGerente.getAdicionalPersonalACargo()
						  +IndicesSalarialesGerente.getAdicionalConyugueUR()
						  +IndicesSalarialesGerente.getAdicionalPorHijoUR()*2)
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calcularSalarioGerenteConConyugueYMenos2HijosSinAntiguedad() {
		new SalarioGerente(false, -2, cerateAntiguedad(0));		
	}

	@Test
	public void calcularSalarioGerenteSinConyugue1HijoSinAntiguedad() {
		SalarioGerente salario = new SalarioGerente(false, 1, cerateAntiguedad(0));
		
		double esperado = (IndicesSalarialesGerente.getSueldoBasicoUR()
						  +IndicesSalarialesGerente.getAdicionalPersonalACargo()
						  +IndicesSalarialesGerente.getAdicionalPorHijoUR()*1)
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	@Test
	public void calcularSalarioGerenteSinConyugue1HijoCon100AniosAntiguedad() {
		SalarioGerente salario = new SalarioGerente(false, 1, cerateAntiguedad(100));
		
		double esperado = (IndicesSalarialesGerente.getSueldoBasicoUR()
						 +IndicesSalarialesGerente.getAdicionalPersonalACargo() 
						 +IndicesSalarialesGerente.getAdicionalPorHijoUR()*1
						  +IndicesSalarialesGerente.getTopeDeAntiguedadUR())
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}
	
	@Test
	public void calcularSalarioGerenteSinConyugue3Hijo3AniosAntiguedad() {
		SalarioGerente salario = new SalarioGerente(false, 3, cerateAntiguedad(3));
		
		double esperado = (IndicesSalarialesGerente.getSueldoBasicoUR()
						  +IndicesSalarialesGerente.getAdicionalPersonalACargo()
						  +IndicesSalarialesGerente.getAdicionalPorHijoUR()*3
						  +IndicesSalarialesGerente.getAdicionalAntiguedadXAnioUR()*3)
				
						  *UnidadRetributiva.getValorActual();
		
		Assert.assertEquals(esperado, salario.liquidarSalario(),0.01);
	}

}
