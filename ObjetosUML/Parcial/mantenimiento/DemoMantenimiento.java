package mantenimiento;

public class DemoMantenimiento {
	public static void main(String[] args) {
		Sistema sistema = new Sistema();

		sistema.agregarInstrumento(new PianoCola("Piano Principal"));
		sistema.agregarInstrumento(new Timbal("Timbales 1"));
		sistema.agregarInstrumento(new GuitarraClasica("Guitarra Criolla 1"));
		sistema.agregarInstrumento(new Flauta("Flauta Traversa"));

		sistema.afinarTodos("13/05/2021");
		sistema.recambiarTodos("10/02/2021");

		((Afinable) sistema.getInstrumento(0)).afinar("13/05/2021");

		sistema.listarEventos();

	}

}
