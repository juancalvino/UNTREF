package empresa;
import org.junit.Test;
import org.junit.Assert;

public class EmpleadosTest {

	
// SinCategoriaTiempoCompleto	
	@Test
	public void crearUnEmpleadoPermanenteDeTiempoCompletoYSolicitarInformacion() {
		Empleado nuevoEmpleado = new PermanenteTiempoCompleto ("Fernando","Hernandez");
		
		Assert.assertEquals("Fernando Hernandez:empleado/a a tiempo completo. Planta permanente",
									nuevoEmpleado.toString());	
	}

// SinCategoriaTiempoParcial
	@Test
	public void crearUnEmpleadoSinCategoriaDeTiempoCompletoYSolicitarInformacion() {
		Empleado nuevoEmpleado = new PermanenteTiempoParcial ("Maria","Gomez");
		
		Assert.assertEquals("Maria Gomez:empleado/a a tiempo parcial. Planta permanente",
									nuevoEmpleado.toString());
	}

// SinCategoriaEspecial
	@Test
	public void crearUnEmpleadoSinCategoriaEspecialYSolicitarInformacion() {
		Empleado nuevoEmpleado = new SinCategoriaEspecial ("Esteban","Ramirez");
		
		Assert.assertEquals("Esteban Ramirez:empleado/a. Planta permanente",
									nuevoEmpleado.toString());
	}	
	
// Gerente
	@Test
	public void crearUnEmpleadoGerenteYSolicitarInformacion() {
		Empleado nuevoEmpleado = new Gerente ("Esteban","Ramirez");
		
		Assert.assertEquals("Esteban Ramirez:Gerente. Planta permanente",
									nuevoEmpleado.toString());
	}

// TransitorioTiempoCompleto
	@Test
	public void crearUnEmpleadoTransitorioTiempoCompletoYSolicitarInformacion() {
		Empleado nuevoEmpleado = new TransitorioTiempoCompleto ("Pedro","Perez");
		
		Assert.assertEquals("Pedro Perez:empleado/a a tiempo completo. Planta transitoria",
									nuevoEmpleado.toString());
	}		

// TransitorioTiempoParcial
	@Test
	public void crearUnEmpleadoTransitorioTiempoParcialYSolicitarInformacion() {
		Empleado nuevoEmpleado = new TransitorioTiempoParcial ("Agustina","Nieves");
		
		Assert.assertEquals("Agustina Nieves:empleado/a a tiempo parcial. Planta transitoria",
									nuevoEmpleado.toString());
	}	
	@Test(expected = Error.class)
	public void crearUnEmpleadoConElParametroNombreNULL() {
		new PermanenteTiempoCompleto (null,"Hernandez");	
	}

	@Test(expected = Error.class)
	public void crearUnEmpleadoConElParametroApellidoNULL() {
		new PermanenteTiempoCompleto ("Fernando",null);	
	}
}
