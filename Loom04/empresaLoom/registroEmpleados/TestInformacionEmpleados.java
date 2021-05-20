package registroEmpleados;
import org.junit.Test;

import org.junit.Assert;

public class TestInformacionEmpleados {
	
	InformacionEmpleados empresa =new InformacionEmpleados(6);
	
	@Test(expected = IllegalArgumentException.class)
	public void crearInformacionDeEmpleadosConMenos2Empleados() {
		new InformacionEmpleados(-2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void crearInformacionDeEmpleadosCon0Empleados() {
		new InformacionEmpleados(0);
	}
	
	public void crearInformacionDeEmpleadosCon1Empleados() {
		new InformacionEmpleados(1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void agregar7EmpleadosAInformacionDeEmpleadosQueSoporta6() {
		
		empresa.addEmpleado(new PlantaPermanente("Petro", "Garcia",true,2));
		empresa.addEmpleado(new PermanenteTiempoParcial("Marcos", "DiPalma",false,1,60));
		empresa.addEmpleado(new Gerente("Carlos", "Saul",true,3));
		empresa.addEmpleado(new PlantaTemporaria ("Jose", "SanMartin",false,0));
		empresa.addEmpleado(new PlantaTemporariaTiempoParcial("Zulma", "Lobato",true,0,70));
		empresa.addEmpleado(new PlantaTemporaria ("Jose", "SanMartin",false,0));
		empresa.addEmpleado(new PlantaTemporariaTiempoParcial("Zulma", "Lobato",true,0,70));
	}
	
	@Test(expected = NullPointerException.class)
	public void agregarUnEmpleadoNULL() {
		empresa.addEmpleado(null);
	}
	

//Verificar informacion individual
	
	
	@Test(expected = IllegalArgumentException.class) 
	public void agregarEmpleadoPlantaPermanenteConHijoMenos3() {
		empresa.addEmpleado(new PlantaPermanente("Pedro", "Garcia",true,-2));
	}
	
	
	@Test(expected = IllegalArgumentException.class) 
	public void agregarEmpleadoPermanenteTiempoParcialConHorasDeTrabajoMenos1() {
		empresa.addEmpleado(new PermanenteTiempoParcial("Marcos", "DiPalma",false,1,-1));
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void agregarEmpleadoPlantaTemporariaTiempoParcialConHorasDeTrabajoMenos20() {
		empresa.addEmpleado(new PlantaTemporariaTiempoParcial("Marcos", "DiPalma",false,1,-20));
	}
	
	@Test 
	public void agregarTodosLosTiposDeEmpleadosAInformacionDeEmpleados() {
		empresa.addEmpleado(new PlantaPermanente("Pedro", "Garcia",true,2));
		empresa.addEmpleado(new PermanenteTiempoParcial("Marcos", "DiPalma",false,1,60));
		empresa.addEmpleado(new Gerente("Carlos", "Saul",true,3));
		empresa.addEmpleado(new PlantaTemporaria("Jose", "SanMartin", true,2));
		empresa.addEmpleado(new PlantaTemporariaTiempoParcial("Zulma", "Lobato",true,0,70));
		Assert.assertEquals("Pedro Garcia:\n"
							+ "  Sueldo: $15.000\n"
							+ "  Planta permanente, empleado/a a tiempo completo.\n"
							+ "Marcos DiPalma:\n"
							+ "  Sueldo: $11.333,33\n"
							+ "  Planta permanente, empleado/a a tiempo parcial.\n"
							+ "  Horas trabajadas: 60\n"
							+ "Carlos Saul:\n"
							+ "  Sueldo: $37.000\n"
							+ "  Planta permanente, Gerente.\n"
							+ "Jose SanMartin:\n"
							+ "  Sueldo: $15.000\n"
							+ "  Planta transitoria, empleado/a a tiempo completo.\n"
							+ "Zulma Lobato:\n"
							+ "  Sueldo: $11.000\n"
							+ "  Planta transitoria, empleado/a a tiempo parcial.\n"
							+ "  Horas trabajadas: 70\n"
							,empresa.toString());
	}
	
	@Test 
	public void agregarTodosLosTiposDeEmpleadosConConyugue2Hijos2AniosAntiguedad() {
		empresa.addEmpleado(new PlantaPermanente("Pedro", "Garcia",true,2));
		empresa.addEmpleado(new PermanenteTiempoParcial("Marcos", "DiPalma",true,2,40));
		empresa.addEmpleado(new Gerente("Carlos", "Saul",true,2));
		empresa.addEmpleado(new PlantaTemporaria ("Jose", "SanMartin",true,2));
		empresa.addEmpleado(new PlantaTemporariaTiempoParcial("Zulma", "Lobato",true,2,40));

		Assert.assertEquals("Pedro Garcia:\n"
							+ "  Sueldo: $15.000\n"
							+ "  Planta permanente, empleado/a a tiempo completo.\n"
							+ "Marcos DiPalma:\n"
							+ "  Sueldo: $12.333,33\n"
							+ "  Planta permanente, empleado/a a tiempo parcial.\n"
							+ "  Horas trabajadas: 40\n"
							+ "Carlos Saul:\n"
							+ "  Sueldo: $35.000\n"
							+ "  Planta permanente, Gerente.\n"
							+ "Jose SanMartin:\n"
							+ "  Sueldo: $15.000\n"
							+ "  Planta transitoria, empleado/a a tiempo completo.\n"
							+ "Zulma Lobato:\n"
							+ "  Sueldo: $12.333,33\n"
							+ "  Planta transitoria, empleado/a a tiempo parcial.\n"
							+ "  Horas trabajadas: 40\n"
							,empresa.toString());
	}
	
	@Test 
	public void agregarTodosLosTiposDeEmpleadosSinAdicionalFamilarNiAntiguedad() {
		empresa.addEmpleado(new PlantaPermanente("Pedro", "Garcia",false,0));
		empresa.addEmpleado(new PermanenteTiempoParcial("Marcos", "DiPalma",false,0,0));
		empresa.addEmpleado(new Gerente("Carlos", "Saul",false,0));
		empresa.addEmpleado(new PlantaTemporaria ("Jose", "SanMartin",false,0));
		empresa.addEmpleado(new PlantaTemporariaTiempoParcial("Zulma", "Lobato",false,0,0));

		Assert.assertEquals("Pedro Garcia:\n"
							+ "  Sueldo: $10.000\n"
							+ "  Planta permanente, empleado/a a tiempo completo.\n"
							+ "Marcos DiPalma:\n"
							+ "  Sueldo: $3.333,33\n"
							+ "  Planta permanente, empleado/a a tiempo parcial.\n"
							+ "  Horas trabajadas: 0\n"
							+ "Carlos Saul:\n"
							+ "  Sueldo: $30.000\n"
							+ "  Planta permanente, Gerente.\n"
							+ "Jose SanMartin:\n"
							+ "  Sueldo: $10.000\n"
							+ "  Planta transitoria, empleado/a a tiempo completo.\n"
							+ "Zulma Lobato:\n"
							+ "  Sueldo: $3.333,33\n"
							+ "  Planta transitoria, empleado/a a tiempo parcial.\n"
							+ "  Horas trabajadas: 0\n"
							,empresa.toString());
	}
	
	@Test 
	public void agregarTodosLosTiposDeEmpleadosTiempoParcialSinFamiliaNiAntiguedadSinHorasTrabajadas() {
		empresa.addEmpleado(new PermanenteTiempoParcial("Marcos", "DiPalma",false,0,0));
		empresa.addEmpleado(new PlantaTemporariaTiempoParcial("Zulma", "Lobato",false,0,0));

		empresa.toString();
		
		Assert.assertEquals("Marcos DiPalma:\n"
							+ "  Sueldo: $3.333,33\n"
							+ "  Planta permanente, empleado/a a tiempo parcial.\n"
							+ "  Horas trabajadas: 0\n"
							+ "Zulma Lobato:\n"
							+ "  Sueldo: $3.333,33\n"
							+ "  Planta transitoria, empleado/a a tiempo parcial.\n"
							+ "  Horas trabajadas: 0\n"
							,empresa.toString());
	}
	
	@Test 
	public void agregarTodosLosTiposDeEmpleadosTiempoParcialSinFamiliaNiAntiguedadCon9000HorasTrabajadas() {
		empresa.addEmpleado(new PermanenteTiempoParcial("Marcos", "DiPalma",false,0,9000));
		empresa.addEmpleado(new PlantaTemporariaTiempoParcial("Zulma", "Lobato",false,0,9000));

		empresa.toString();
		
		Assert.assertEquals("Marcos DiPalma:\n"
							+ "  Sueldo: $10.000\n"
							+ "  Planta permanente, empleado/a a tiempo parcial.\n"
							+ "  Horas trabajadas: 9000\n"
							+ "Zulma Lobato:\n"
							+ "  Sueldo: $10.000\n"
							+ "  Planta transitoria, empleado/a a tiempo parcial.\n"
							+ "  Horas trabajadas: 9000\n"
							,empresa.toString());
	}
	
	@Test 
	public void agregarTodosLosTiposDeEmpleadosTiempoParcialSinFamiliaCon60HorasTrabajadas() {
		empresa.addEmpleado(new PermanenteTiempoParcial("Marcos", "DiPalma",false,0,60));
		empresa.addEmpleado(new PlantaTemporariaTiempoParcial("Zulma", "Lobato",false,0,60));

		empresa.toString();
		
		Assert.assertEquals("Marcos DiPalma:\n"
							+ "  Sueldo: $9.333,33\n"
							+ "  Planta permanente, empleado/a a tiempo parcial.\n"
							+ "  Horas trabajadas: 60\n"
							+ "Zulma Lobato:\n"
							+ "  Sueldo: $9.333,33\n"
							+ "  Planta transitoria, empleado/a a tiempo parcial.\n"
							+ "  Horas trabajadas: 60\n"
							,empresa.toString());
				}	

}
