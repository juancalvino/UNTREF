package agenda;
import org.junit.Test;
import org.junit.Assert;

public class InformacionOpcionalTest {

	InformacionOpcional infoOpcional =  new InformacionOpcional();
	
// Piso 

	@Test
	public void noSeCargoNingunPisoDeveulveNull() {
		Assert.assertEquals("", infoOpcional.toString());
	}

	@Test
	public void agregarYDevloverElPiso1() {
		infoOpcional.setPiso("1");
		Assert.assertEquals("Piso:1\n", infoOpcional.toString());
	}

	@Test
	public void agregarYDevloverElPisoPB() {
		infoOpcional.setPiso("PB");	
		Assert.assertEquals("Piso:PB\n", infoOpcional.toString());
	}
	
	@Test
	public void agregarUnPisoYEliminarlo() {
		infoOpcional.setPiso("PB");
		infoOpcional.setPiso(null);
		
		Assert.assertEquals("", infoOpcional.toString());
	}
	

//Depto 
	
	@Test
	public void noSeCargoNingunDeptoDeveulveNull() {
		Assert.assertEquals("", infoOpcional.toString());
	}
	
	@Test
	public void agregarYDevloverElDepto4() {
		infoOpcional.setDepto("4");
		Assert.assertEquals("Depto:4\n", infoOpcional.toString());
	}
	
	@Test
	public void agregarYDevloverElDeptoA() {
		infoOpcional.setDepto("A");
		Assert.assertEquals("Depto:A\n", infoOpcional.toString());
	}
	
	@Test
	public void agregarUnDeptoYEliminarlo() {
		infoOpcional.setDepto("PB");
		infoOpcional.setDepto(null);
		Assert.assertEquals("", infoOpcional.toString());
	}
	
// Partido 
		
	@Test
	public void agregarYDevloverElDepartamentoLaMatanza() {
		infoOpcional.setPartido("La Matanza");
		Assert.assertEquals("Partido:La Matanza\n", infoOpcional.toString());
	}

	@Test
	public void agregarYDevloverElDepartamento123456(){
		infoOpcional.setPartido("123456");
		Assert.assertEquals("Partido:123456\n", infoOpcional.toString());
	}
	
	@Test
	public void agregarUnPartidoYEliminarlo() {
		infoOpcional.setPartido("Los pajaros");
		infoOpcional.setPartido(null);
		
		Assert.assertEquals("", infoOpcional.toString());
	}
	
// Cargar asignarle valor a diferentes atributos y que no esten cruzados
	
	@Test
	public void agregarYCorroborarPiso2DeptoAPartidoP3F() {
		infoOpcional.setPiso("2");
		infoOpcional.setDepto("A");
		infoOpcional.setPartido("P3F");

		Assert.assertEquals(infoOpcional.toString(), "Piso:2\n"
												   + "Depto:A\n"
												   + "Partido:P3F\n"
							);
	}	
	
}
