package empresa;
import org.junit.Test;
import org.junit.Assert;

public class InformacionEmpleadosTest {

	InformacionEmpleados empresa =new InformacionEmpleados(6);
	@Test 
	public void agregarTodosLosTiposDeEmpleadosAInformacionDeEmpleados() {
		empresa.addEmpleado(new PermanenteTiempoCompleto("Petro", "Garcia"));
		empresa.addEmpleado(new PermanenteTiempoParcial("Marcos", "DiPalma"));
		empresa.addEmpleado(new SinCategoriaEspecial("Agustin", "Martinez"));
		empresa.addEmpleado(new Gerente("Carlos", "Saul"));
		empresa.addEmpleado(new TransitorioTiempoCompleto("Jose", "SanMartin"));
		empresa.addEmpleado(new TransitorioTiempoParcial("Zulma", "Lobato"));

		Assert.assertEquals("Petro Garcia:empleado/a a tiempo completo. Planta permanente\n"
						  + "Marcos DiPalma:empleado/a a tiempo parcial. Planta permanente\n"
						  + "Agustin Martinez:empleado/a. Planta permanente\n"
						  + "Carlos Saul:Gerente. Planta permanente\n"
						  + "Jose SanMartin:empleado/a a tiempo completo. Planta transitoria\n"
						  + "Zulma Lobato:empleado/a a tiempo parcial. Planta transitoria\n"
		
						,empresa.toString());
	}
	
	
	@Test(expected = Error.class)
	public void crearInformacionDeEmpleadosConMenos2Empleados() {
		empresa = new InformacionEmpleados(-2);
	}
	
	@Test(expected = Error.class)
	public void crearInformacionDeEmpleadosCon0Empleados() {
		empresa = new InformacionEmpleados(0);
	}
	
	public void crearInformacionDeEmpleadosCon1Empleados() {
		empresa = new InformacionEmpleados(1);
	}
	
	@Test(expected = Error.class)
	public void agregar7EmpleadosAInformacionDeEmpleadosQueSoporta6() {
		
		empresa.addEmpleado(new PermanenteTiempoCompleto("Petro", "Garcia"));
		empresa.addEmpleado(new PermanenteTiempoParcial("Marcos", "DiPalma"));
		empresa.addEmpleado(new Gerente("Carlos", "Saul"));
		empresa.addEmpleado(new TransitorioTiempoCompleto("Jose", "SanMartin"));
		empresa.addEmpleado(new TransitorioTiempoParcial("Zulma", "Lobato"));
		empresa.addEmpleado(new TransitorioTiempoParcial("Zulma", "Lobato"));
		empresa.addEmpleado(new TransitorioTiempoCompleto("Jose", "SanMartin"));
	}
	
	@Test(expected = Error.class)
	public void agregarUnEmpleadoNULL() {
		empresa.addEmpleado(null);
	}
}
