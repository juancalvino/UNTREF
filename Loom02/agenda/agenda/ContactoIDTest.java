package agenda;
import org.junit.Test;
import org.junit.Assert;

public class ContactoIDTest {

// Contacto con dos constructores.
	ContactoID contactoSimple = new ContactoID("Juan", "Perez"); 
	
// Contacto con tres constructores.
	ContactoID contactoCompuesto = new ContactoID("Juan","Manuel", "Perez"); 	

	@Test(expected = Error.class)
	public void instanciarNombreNULL() {
		contactoSimple = new ContactoID(null, "Perez");
	}

	@Test(expected = Error.class)
	public void instanciarApellidoNULL() {
		contactoSimple = new ContactoID("Juan", null);
	}
	
	public void instanciarSegundoNombreNULL() {
		contactoSimple = new ContactoID("Juan", "Hernandez", null);
	}
	
	@Test
	public void devolverInformacionDeContactoSimple() {
		Assert.assertEquals(contactoSimple.toString(), "Nombre:Juan\n"
													+ "Apellido:Perez"
							);
	}

	@Test
	public void devolverInformacionDeContactoCompuesto() {
		Assert.assertEquals(contactoCompuesto.toString(), "Nombre:Juan Manuel\n"
														+ "Apellido:Perez"
							);
	}
	
	@Test 
	public void cambiarNombreARoberto() {
		contactoSimple.setNombre("Roberto");
		Assert.assertEquals(contactoSimple.toString(), "Nombre:Roberto\n"
														+ "Apellido:Perez"
							);
	}

	@Test 
	public void cambiarNombreARobertoConSegundoNombre() {
		contactoCompuesto.setNombre("Roberto");
		Assert.assertEquals(contactoCompuesto.toString(), "Nombre:Roberto Manuel\n"
														+ "Apellido:Perez"
							);
	}
	
	@Test(expected = Error.class) 
	public void cambiarNombreANULL() {
		contactoSimple.setNombre(null);
	}
	
	@Test 
	public void cambiarApellidoAOrtega() {
		contactoCompuesto.setApellido("Ortega");
		Assert.assertEquals(contactoCompuesto.toString(), "Nombre:Juan Manuel\n"
														+ "Apellido:Ortega"
							);
	}
	
	@Test(expected = Error.class) 
	public void cambiarApellidoANULL() {
		contactoSimple.setApellido(null);
	}

	@Test 
	public void agregarSegundoNombreAMartin() {
		contactoSimple.setSegundoNombre("Martin");
		Assert.assertEquals(contactoSimple.toString(), "Nombre:Juan Martin\n"
														+ "Apellido:Perez"
							);
	}
	
	@Test 
	public void cambiarSegundoNombreAMartin() {
		contactoCompuesto.setSegundoNombre("Martin");
		Assert.assertEquals(contactoCompuesto.toString(), "Nombre:Juan Martin\n"
														+ "Apellido:Perez"
							);
	}
	
	@Test 
	public void borrarSegundoNombre() {
		contactoCompuesto.setSegundoNombre(null);
		Assert.assertEquals(contactoCompuesto.toString(), "Nombre:Juan\n"
														+ "Apellido:Perez"
							);
	}
	
	@Test 
	public void agregarTelefono() {
		contactoSimple.addTelefono("4557 5648 int 22", "oficina");
		Assert.assertEquals(contactoSimple.toString(), "Nombre:Juan\n"
													 + "Apellido:Perez\n"
													 + "Telefono:4557 5648 int 22\n"
													 + "Tipo:oficina"
							);
	}
	
	@Test 
	public void cambiarTelefonoA45048485() {
		contactoSimple.addTelefono("4557 5648 int 22", "oficina");
		contactoSimple.setTelefono().setContacto("45048485");
	
		Assert.assertEquals(contactoSimple.toString(), "Nombre:Juan\n"
													 + "Apellido:Perez\n"
													 + "Telefono:45048485\n"
													 + "Tipo:oficina"
							);
	}
	
	public void cambiarTelefonoA45048485YVerLaInformacionDeTelefono() {
		contactoSimple.addTelefono("4557 5648 int 22", "oficina");
		contactoSimple.setTelefono().setContacto("45048485");
	
		Assert.assertEquals(contactoSimple.setTelefono().toString(), "Telefono:45048485\n"
													 				+ "Tipo:oficina"
							);
	}
	
	@Test(expected = Error.class)
	public void agregarTelefonoYaExistiendoOtro() {
		contactoSimple.addTelefono("4557 5648 int 22", "oficina");
		contactoSimple.addTelefono("44521234", "Casa");
	}
	
	@Test(expected = Error.class)
	public void cambiarTelefonoSinHaberloAgregado() {
		contactoSimple.setTelefono().setContacto("4545 6666");
	}
	
	@Test 
	public void agregarEmail() {
		contactoSimple.addEmail("jjlopez@gmail.com", "facu");
		Assert.assertEquals(contactoSimple.toString(), "Nombre:Juan\n"
													 + "Apellido:Perez\n"
													 + "Email:jjlopez@gmail.com\n"
													 + "Tipo:facu"
							);
	}
	
	@Test(expected = Error.class)
	public void agregarEmailYaExistiendoOtro() {
		contactoSimple.addEmail("jjlopez@gmail.com", "facu");
		contactoSimple.addEmail("lolitolopez@altavista.com", "casa");
	}
	
	@Test(expected = Error.class)
	public void cambiarEmailSinHaberloAgregado() {
		contactoSimple.setEmail().setContacto("jjlopez@gmail.com");
	}

	@Test 
	public void cambiarEmailAlolitolopezAaltavistaPcom() {
		contactoSimple.addEmail("jjlopez@gmail.com", "facu");
		contactoSimple.setEmail().setContacto("lolitolopez@altavista.com");
		
		Assert.assertEquals(contactoSimple.toString(), "Nombre:Juan\n"
													 + "Apellido:Perez\n"
													 + "Email:lolitolopez@altavista.com\n"
													 + "Tipo:facu"
							);
	}
	
	public void cambiarEmailAlolitolopezAaltavistaPcomYVerLaInformacionDeEmail() {
		contactoSimple.addEmail("jjlopez@gmail.com", "facu");
		contactoSimple.setEmail().setContacto("lolitolopez@altavista.com");
		
		Assert.assertEquals(contactoSimple.setEmail().toString(),   "Email:lolitolopez@altavista.com\n"
																  + "Tipo:facu"

							);
	}
	
	@Test 
	public void agregarEmailYTelefono() {
		contactoSimple.addEmail("jjlopez@gmail.com", "facu");
		contactoSimple.addTelefono("4557 5648 int 22", "oficina");

		Assert.assertEquals(contactoSimple.toString(), "Nombre:Juan\n"
													 + "Apellido:Perez\n"
													 + "Telefono:4557 5648 int 22\n"
													 + "Tipo:oficina\n"
													 + "Email:jjlopez@gmail.com\n"
													 + "Tipo:facu"
							);
	}

	@Test 
	public void agregarTelefonoEmailYEliminarlos() {
		contactoSimple.addTelefono("4557 5648 int 22", "oficina");
		contactoSimple.deleteTelefono();
		contactoSimple.addEmail("jjlopez@gmail.com", "facu");
		contactoSimple.deleteEmail();
		
		Assert.assertEquals(contactoSimple.toString(), "Nombre:Juan\n"
													 + "Apellido:Perez"
							);
	}
	
	@Test
	public void agregarUnDomicilio() {
		contactoCompuesto.addDomicilio("MauelSola",4751,"CABA","CABA","Argentina");
		Assert.assertEquals(contactoCompuesto.toString(), "Nombre:Juan Manuel\n"
														+ "Apellido:Perez"
														+"\nDomicilio\n"
														+ "Calle:MauelSola\n"
														+ "Numero:4751\n"
														+ "Localidad:CABA\n"
														+ "Provincia:CABA\n"
														+ "Pais:Argentina"
							);
		}
	
	@Test(expected = Error.class)
	public void agregarDomicilioYaExistiendoOtro() {
		contactoCompuesto.addDomicilio("MauelSola",4751,"CABA","CABA","Argentina");
		contactoCompuesto.addDomicilio("Cuenca",3355,"CABA","CABA","Argentina");
	}
	
	@Test(expected = Error.class)
	public void cambiarCalleSinHaberAgregadoADomicilio() {
		contactoCompuesto.setDomicilio().setCalle("Cuenca");
	}
		
	@Test
	public void agregarUnDomicilioYAgregarPiso2() {
		contactoCompuesto.addDomicilio("MauelSola",4751,"CABA","CABA","Argentina");
		contactoCompuesto.setDomicilio().setOpcional().setPiso("2");
		
		Assert.assertEquals(contactoCompuesto.toString(), "Nombre:Juan Manuel\n"
														+ "Apellido:Perez"
														+"\nDomicilio\n"
														+ "Calle:MauelSola\n"
														+ "Numero:4751\n"
														+ "Piso:2\n"
														+ "Localidad:CABA\n"
														+ "Provincia:CABA\n"
														+ "Pais:Argentina"
							);
	}

	@Test
	public void agregarUnDomicilioCambiarlePaisYVerLaInfoDeDomicilio() {
		contactoCompuesto.addDomicilio("MauelSola",4751,"CABA","CABA","Argentina");
		contactoCompuesto.setDomicilio().setPais("Francia");
		
		Assert.assertEquals(contactoCompuesto.setDomicilio().toString(),  "Calle:MauelSola\n"
																		+ "Numero:4751\n"
																		+ "Localidad:CABA\n"
																		+ "Provincia:CABA\n"
																		+ "Pais:Francia"
						 );
	}

	
	@Test
	public void agregarUnDomicilioEInfoOpcionalYVerLaInfoDeDomicilio() {
		contactoCompuesto.addDomicilio("MauelSola",4751,"CABA","CABA","Argentina");
		contactoCompuesto.setDomicilio().setOpcional().setDepto("2A");
		
		Assert.assertEquals(contactoCompuesto.setDomicilio().toString(),  "Calle:MauelSola\n"
																		+ "Numero:4751\n"
																		+ "Depto:2A\n"
																		+ "Localidad:CABA\n"
																		+ "Provincia:CABA\n"
																		+ "Pais:Argentina"
						 );
	}
	
	
	@Test 
	public void agregarCumpleaniosYEmpresa() {
		contactoSimple.setCumpleanios("11-05-2001");
		contactoSimple.setEmpresa("ExxonMobil");
		
		Assert.assertEquals(contactoSimple.toString(), "Nombre:Juan\n"
													 + "Apellido:Perez\n"
													 + "Cumpleaños:11-05-2001\n"
													 + "Empresa:ExxonMobil"
							);
	}
	
	@Test 
	public void agregarCumpleaniosEmpresaYEliminarlos() {
		contactoSimple.setCumpleanios("11-05-2001");
		contactoSimple.setEmpresa("ExxonMobil");
		
		contactoSimple.setCumpleanios(null);
		contactoSimple.setEmpresa(null);
		
		Assert.assertEquals(contactoSimple.toString(), "Nombre:Juan\n"
													 + "Apellido:Perez"
							);
	}
	
	@Test 
	public void agregarTodosLosCampos() {
		contactoSimple.setSegundoNombre("Martin");
		contactoSimple.addTelefono("1545852881", "Mobil");
		contactoSimple.addEmail("tincho@gmail.com", "Vecino");
		contactoSimple.addDomicilio("Tinogasta", 3047, "CABA", "CABA", "Arg");
		contactoSimple.setDomicilio().setOpcional().setPiso("6");
		contactoSimple.setDomicilio().setOpcional().setDepto("B");
		contactoSimple.setDomicilio().setOpcional().setPartido("VillaDelParque");
		contactoSimple.setCumpleanios("11-05-2001");
		contactoSimple.setEmpresa("ExxonMobil");
		
		
		Assert.assertEquals(contactoSimple.toString(), "Nombre:Juan Martin\n"
													 + "Apellido:Perez\n"
													 + "Telefono:1545852881\n"
													 + "Tipo:Mobil\n"
													 + "Email:tincho@gmail.com\n"
													 + "Tipo:Vecino\n"
													 + "Domicilio\n"
													 + "Calle:Tinogasta\n"
													 + "Numero:3047\n"
													 + "Piso:6\n"
													 + "Depto:B\n"
													 + "Partido:VillaDelParque\n"
													 + "Localidad:CABA\n"
													 + "Provincia:CABA\n"
													 + "Pais:Arg\n"
													 + "Cumpleaños:11-05-2001\n"
													 + "Empresa:ExxonMobil"
							);
	}
	
	

}
