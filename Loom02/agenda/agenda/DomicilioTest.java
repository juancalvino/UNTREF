package agenda;
import org.junit.Assert;
import org.junit.Test;

public class DomicilioTest {

	Domicilio domicilio;

//Constructor	
	
	@Test
	public void crearUnDomicilioConCalleNroLocalidadProvinciaYPais() {
		domicilio = new Domicilio("PedroLozano", 2546,"CABA","CABA","Argentina");
	}
	
	@Test(expected = Error.class)
	public void crearUnDomicilioConCalleNULL() {
		domicilio = new Domicilio(null, 2546,"CABA","CABA","Argentina");
	}
	
	@Test(expected = Error.class)
	public void crearUnDomicilioConLocalidadNULL() {
		domicilio = new Domicilio("PedroLozano", 2546,null,"CABA","Argentina");
	}
	
	@Test(expected = Error.class)
	public void crearUnDomicilioConProvinciaNULL() {
		domicilio = new Domicilio("PedroLozano", 2546,"CABA",null,"Argentina");
	}
	
	@Test(expected = Error.class)
	public void crearUnDomicilioConPaisNULL() {
		domicilio = new Domicilio("PedroLozano", 2546,"CABA","CABA",null);
	}

// Metodo para no cargar el domicilio
	
	public void cargarDomicilio() {
		domicilio = new Domicilio("PedroLozano", 2546,"CABA","CABA","Argentina");
	}
	
	
	@Test (expected = Error.class)
	public void cambiarCallePorNULL() {
		cargarDomicilio();
		domicilio.setCalle(null);
	}
	
	@Test (expected = Error.class)
	public void cambiarLocalidadPorNULL() {
		cargarDomicilio();
		domicilio.setLocalidad(null);
	}
	
	@Test (expected = Error.class)
	public void cambiarProvinciaPorNULL() {
		cargarDomicilio();
		domicilio.setProvincia(null);
	}
	
	@Test (expected = Error.class)
	public void cambiarPaisPorNULL() {
		cargarDomicilio();
		domicilio.setPais(null);
	}
	

//Atributos
	// Opcional
	
	
	@Test
	public void agreagarPiso3DeptoBPartidoLaMatanza() {
		cargarDomicilio();
		domicilio.setOpcional().setPiso("3");
		domicilio.setOpcional().setDepto("B");
		domicilio.setOpcional().setPartido("LaMatanza");

		Assert.assertEquals(domicilio.toString(), "Calle:PedroLozano\n"
												+ "Numero:2546\n"
												+ "Piso:3\n"
												+ "Depto:B\n"
												+ "Partido:LaMatanza\n"
												+ "Localidad:CABA\n"
												+ "Provincia:CABA\n"
												+ "Pais:Argentina"
							);
	}
	
	@Test
	public void agreagarYEliminarLaInformacionOpcional() {
		cargarDomicilio();
		domicilio.setOpcional().setPiso("3");
		domicilio.setOpcional().setDepto("B");
		domicilio.setOpcional().setPartido("LaMatanza");
		domicilio.setOpcional().setPiso(null);
		domicilio.setOpcional().setDepto(null);
		domicilio.setOpcional().setPartido(null);
		
		Assert.assertEquals(domicilio.toString(), "Calle:PedroLozano\n"
												+ "Numero:2546\n"
												+ "Localidad:CABA\n"
												+ "Provincia:CABA\n"
												+ "Pais:Argentina"
							);		
	}
	
// devolversInformacion()	
	
	@Test
	public void devolverInformacionSinInfoOpcional() {
		cargarDomicilio();
		Assert.assertEquals(domicilio.toString(), "Calle:PedroLozano\n"
												+ "Numero:2546\n"
												+ "Localidad:CABA\n"
												+ "Provincia:CABA\n"
												+ "Pais:Argentina"
							);
	}
	
	@Test
	public void devolverInformacionConInfoOpcional() {
		cargarDomicilio();
		domicilio.setOpcional().setPiso("3");
		domicilio.setOpcional().setDepto("B");
		domicilio.setOpcional().setPartido("LaMatanza");

		Assert.assertEquals(domicilio.toString(),"Calle:PedroLozano\n"
												+ "Numero:2546\n"
												+ "Piso:3\n"
												+ "Depto:B\n"
												+ "Partido:LaMatanza\n"
												+ "Localidad:CABA\n"
												+ "Provincia:CABA\n"
												+ "Pais:Argentina"
							);		
	}
	
	@Test
	public void devolverInformacionIngresandoDosIformacionOpcionalYEliminandoUnaDeEllas() {
		cargarDomicilio();
		domicilio.setOpcional().setPiso("3");
		domicilio.setOpcional().setDepto("B");
		domicilio.setOpcional().setPartido("LaMatanza");
		domicilio.setOpcional().setDepto(null);

		Assert.assertEquals(domicilio.toString(),"Calle:PedroLozano\n"
												+ "Numero:2546\n"
												+ "Piso:3\n"
												+ "Partido:LaMatanza\n"
												+ "Localidad:CABA\n"
												+ "Provincia:CABA\n"
												+ "Pais:Argentina"
							);		
	}
}

