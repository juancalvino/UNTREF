package agenda;
import org.junit.Test;
import org.junit.Assert;

public class AgendaTest {
	
	Agenda personal = new Agenda(5);;
	
	
	@Test(expected = Error.class)
	public void crearAgendaCon5ContactosYCargar6Contactos() {
		personal.newContacto("Lean", "Hernandez");
		personal.newContacto("Jose", "Manuel","Rosas");
		personal.newContacto("Juan", "Marteli");
		personal.newContacto("Maria", "Gonzales");
		personal.newContacto("Carolina", "Mendez");
		personal.newContacto("Javier", "Hector", "Sucutrule");
	}
	
	@Test
	public void crearAgendaCon5ContactosYCargar5Contactos() {
	
		personal.newContacto("Lean", "Hernandez");
		Assert.assertEquals(personal.toString(0), "Nombre:Lean\n"
												 + "Apellido:Hernandez"
							);
		
		personal.newContacto("Jose", "Manuel","Rosas");
		Assert.assertEquals(personal.toString(1), "Nombre:Jose Manuel\n"
												 + "Apellido:Rosas"
							);
		
		personal.newContacto("Juan", "Marteli");
		Assert.assertEquals(personal.toString(2), "Nombre:Juan\n"
				  								+ "Apellido:Marteli"
							);
		
		personal.newContacto("Maria", "Gonzales");
		Assert.assertEquals(personal.toString(3), "Nombre:Maria\n"
												+ "Apellido:Gonzales"
							);

		personal.newContacto("Carolina", "Mendez");
		Assert.assertEquals(personal.toString(4), "Nombre:Carolina\n"
												+ "Apellido:Mendez"
							);

	}
	
	@Test(expected = Error.class)
	public void mostarElIndice5DeUnContactoQueTieneHastaIndice4() {
		personal.toString(5);
	}
	
	@Test(expected = Error.class)
	public void mostrarUnContactoDeIndiceNegativo() {
		personal.toString(-1);
	}
	
	public void mostarContactoConIndiceValidoPeroVacio() {
		Assert.assertEquals(personal.toString(4), null);
	}
	
	@Test
	public void agregarYEliminarUnContacto() {
		personal.newContacto("Lean", "Hernandez");
		personal.deleteContacto(0);

		Assert.assertEquals(personal.toString(0), null);
	}
	
	@Test
	public void agregarTodosLosContactosDisponiblesEliminarElIndice3YAgregarOtroContacto() {
		personal.newContacto("Lean", "Hernandez");
		personal.newContacto("Jose", "Manuel","Rosas");
		personal.newContacto("Juan", "Marteli");
		personal.newContacto("Maria", "Gonzales");
		personal.newContacto("Carolina", "Mendez");
		personal.deleteContacto(3);
		personal.newContacto("Javier", "Hector", "Sucutrule");

		Assert.assertEquals(personal.toString(3),"Nombre:Javier Hector\n"
													  + "Apellido:Sucutrule");
	}
	
	@Test
	public void agregarUnContactoEIngresarleUnEmail() {
		personal.newContacto("Lean", "Hernandez");
		personal.setContacto(0).addEmail("lean@yahoo.com.ar", "Personal");

		Assert.assertEquals(personal.toString(0),  "Nombre:Lean\n"
														+ "Apellido:Hernandez\n"
														+ "Email:lean@yahoo.com.ar\n"
														+ "Tipo:Personal"
							);
	}
	
	@Test(expected = NullPointerException.class)
	public void agregarUnTelefonoAUnContactoVacio() {
		personal.setContacto(4).addTelefono("45784565", "Pinto");
	}
	
	@Test(expected = NullPointerException.class)
	public void cambiarElNombreDeUnContactoVacio() {
		personal.setContacto(0).setNombre("Fabian");
	}
	
	@Test 
	public void agregarTodosLosCamposAlContactoDeIndice2() {
		personal.newContacto("Lean", "Hernandez");
		personal.newContacto("Jose", "Manuel","Rosas");
		personal.newContacto("Juan","Martin", "Perez");
		personal.setContacto(2).addTelefono("1545852881", "Mobil");
		personal.setContacto(2).addEmail("tincho@gmail.com", "Vecino");
		personal.setContacto(2).addDomicilio("Tinogasta", 3047, "CABA", "CABA", "Arg");
		personal.setContacto(2).setDomicilio().setOpcional().setPiso("6");
		personal.setContacto(2).setDomicilio().setOpcional().setDepto("B");
		personal.setContacto(2).setDomicilio().setOpcional().setPartido("VillaDelParque");
		personal.setContacto(2).setCumpleanios("11-05-2001");
		personal.setContacto(2).setEmpresa("ExxonMobil");
		
		
		Assert.assertEquals(personal.toString(2), "Nombre:Juan Martin\n"
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
	
	@Test
	public void agregarUnContactoEIngresarDomicilioYLuegoEliminarlo() {
		personal.newContacto("Lean", "Hernandez");
		personal.setContacto(0).addDomicilio("Tinogasta", 3047, "CABA", "CABA", "Arg");
		personal.setContacto(0).deleteDomicilio();
		
		Assert.assertEquals(personal.toString(0), "Nombre:Lean\n"
												+ "Apellido:Hernandez"
							);
	}
	
}
