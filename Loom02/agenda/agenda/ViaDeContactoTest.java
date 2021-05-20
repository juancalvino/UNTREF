package agenda;
import org.junit.Test;
import org.junit.Assert;


public class ViaDeContactoTest {
		
	//Email
	ViaDeContacto email = new ViaDeContacto("victor@gmail.com", "Trabajo");
	//Telefono
	ViaDeContacto telefono = new ViaDeContacto("45788457", "Casa");
			
	@Test(expected = Error.class)
	public void crearUnaViaDeContactoConTipoNULL() {
		email= new ViaDeContacto("15-0015-4567", null);
	}

	@Test(expected = Error.class)
	public void crearUnaViaDeContactoConContactoNULL()   {
		email = new ViaDeContacto(null, "Personal");
	}

	
	@Test
	public void devloverTipoDeContactoInstanciadoDosParametros() {
		Assert.assertEquals(email.toString(), "victor@gmail.com\n"
											+ "Tipo:Trabajo");
	}
	
	@Test
	public void cambiarYdevloverInfoContacto() {
		telefono.setContacto("1500154567");
		Assert.assertEquals(telefono.toString(),"1500154567\n"
											  + "Tipo:Casa" 
							);
	}
	
	@Test
	public void cambiarYdevloverTipoDeContacto() {
		email.setTipoDeContacto("home");
		Assert.assertEquals(email.toString(), "victor@gmail.com\n"
											+ "Tipo:home"
							);
	}
	
	@Test
	public void cambiarYdevloverContactoYTipoDeContacto() {
		email.setContactoYTipo("juan@hotmail.com", "personal");
		Assert.assertEquals(email.toString(), "juan@hotmail.com\n"
											+ "Tipo:personal"
							);
	}
	
	@Test(expected = Error.class)
	public void cambiarElContactoANULLYdevloverInfoContacto() {
		email.setContacto(null);
	}

	@Test(expected = Error.class)
	public void cambiarYdevloverTipoDeContactoNULL() {
		email.setTipoDeContacto(null);
	}
	
	

}
