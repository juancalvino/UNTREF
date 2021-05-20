package registroEmpleados;
import org.junit.Test;
import org.junit.Assert;

public class TestCrearEmpleados {

	
// PlantaPermanente	
	@Test
	public void crearUnEmpleadoPermanenteDeTiempoCompletoYSolicitarInformacion() {	
		Assert.assertEquals("Fernando Hernandez:\n"
							+ "  Sueldo: $15.000\n"
							+ "  Planta permanente, empleado/a a tiempo completo."
							,new PlantaPermanente ("Fernando","Hernandez",true,2).toString());	
	}

	
// PermanenteTiempoParcial
	@Test
	public void crearUnEmpleadoSinCategoriaDeTiempoCompletoYSolicitarInformacion() {
		Assert.assertEquals("Maria Gomez:\n"
							+ "  Sueldo: $18.000\n"
							+ "  Planta permanente, empleado/a a tiempo parcial.\n"
							+ "  Horas trabajadas: 80"
							,new PermanenteTiempoParcial ("Maria","Gomez",false,4,80).toString());
	}

	
// Gerente
	@Test
	public void crearUnEmpleadoGerenteYSolicitarInformacion() {
		
		Assert.assertEquals("Esteban Ramirez:\n"
							+ "  Sueldo: $30.000\n"
							+ "  Planta permanente, Gerente."
							,new Gerente ("Esteban","Ramirez",false,0).toString());
	}

	
// TransitorioTiempoCompleto
	@Test
	public void crearUnEmpleadoTransitorioTiempoCompletoYSolicitarInformacion() {
		Assert.assertEquals("Pedro Perez:\n"
							+ "  Sueldo: $17.000\n"
							+ "  Planta transitoria, empleado/a a tiempo completo."
							,new PlantaTemporaria ("Pedro","Perez",true,3).toString());
	}		

	
// TransitorioTiempoParcial
	@Test
	public void crearUnEmpleadoTransitorioTiempoParcialYSolicitarInformacion() {
		Assert.assertEquals("Agustina Nieves:\n"
							+ "  Sueldo: $12.333,33\n"
							+ "  Planta transitoria, empleado/a a tiempo parcial.\n"
							+ "  Horas trabajadas: 60"
							,new PlantaTemporariaTiempoParcial ("Agustina","Nieves",true,1,60).toString());
	}	
	
	@Test(expected = NullPointerException.class)
	public void crearUnEmpleadoConElParametroNombreNULL() {
		new PlantaPermanente(null,"Hernandez",true,0);	
	}

	@Test(expected = NullPointerException.class)
	public void crearUnEmpleadoConElParametroApellidoNULL() {
		new PlantaPermanente("Fernando",null,false,1);	
	}
	
}
