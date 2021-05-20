package registroEmpleados;

import unidadContable.UnidadRetributiva;

public class DemoInformacionEmpleados {

	/**
	 * Crea una lista de 6 empleados, agrega a un Empleado de cada categoria existente y los lista.
	 */
	public static void main(String[] args) {
		
		UnidadRetributiva.setValorActual(10);
		
		InformacionEmpleados empresa =new InformacionEmpleados(6);
		empresa.addEmpleado(new PlantaPermanente("Pedro", "Garcia",true,2));
		empresa.addEmpleado(new PermanenteTiempoParcial("Marcos", "DiPalma",false,1,60));
		empresa.addEmpleado(new Gerente("Lenna", "Franccini",true,2));
		empresa.addEmpleado(new PlantaTemporaria ("Jose", "SanMartin",false,0));
		empresa.addEmpleado(new PlantaTemporariaTiempoParcial("Zulma", "Lobato",true,0,70));
		System.out.println(empresa.toString());
		
		UnidadRetributiva.setValorActual(30);
		System.out.println(empresa.toString());
	}
	
}
