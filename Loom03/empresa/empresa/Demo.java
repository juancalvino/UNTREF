package empresa;

public class Demo {

	/**
	 * Crea una lista de 6 empleados, agrega a un Empleado de cada categoria existente y los lista.
	 */
	public static void main(String[] args) {
		InformacionEmpleados empresa =new InformacionEmpleados(6);
		empresa.addEmpleado(new PermanenteTiempoCompleto("Pedro", "Garcia"));
		empresa.addEmpleado(new PermanenteTiempoParcial("Marcos", "DiPalma"));
		empresa.addEmpleado(new SinCategoriaEspecial("Agustin", "Martinez"));
		empresa.addEmpleado(new Gerente("Carlos", "Saul"));
		empresa.addEmpleado(new TransitorioTiempoCompleto("Jose", "SanMartin"));
		empresa.addEmpleado(new TransitorioTiempoParcial("Zulma", "Lobato"));
		
		System.out.println(empresa.toString());
	}
	
}
