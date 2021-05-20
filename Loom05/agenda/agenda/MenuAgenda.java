package agenda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAgenda {

	public void ejecutar() {
		Scanner scanner = null;
		boolean salir = false;
		int opcion;
		Agenda agendaMain;

		try {
			scanner = new Scanner(System.in);
			agendaMain = new Agenda();

			while (!salir) {
				System.out.println("/////////////////////////////////////////////////"
						+ "\n----Ingrese la accion que desea realizar----\n" + "\n1- Cargar archivo"
						+ "\n2- Guardar Agenda" + "\n3- Agregar Contacto" + "\n4- Borrar Contacto"
						+ "\n5- Mostrar Agenda (muestra todos los contactos)" + "\n6- Salir\n"
						+ "\n/////////////////////////////////////////////////\n");

				opcion = scanner.nextInt();

				switch (opcion) {
				case 1:
					cargarArchivo(agendaMain, scanner);
					break;
				case 2:
					guardarEnAgenda(agendaMain, scanner);
					break;
				case 3:
					agregarContacto(agendaMain, scanner);
					break;
				case 4:
					borrarContacto(agendaMain, scanner);
					break;
				case 5:
					salir = mostrarContactos(agendaMain, scanner);
					break;
				case 6:
					salir = salirDelPrograma(scanner);
					break;
				default:
					System.out.println("La opcion ingresada no es valida");
					break;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Se debe introducir un numero dentro de las opciones");
			scanner.next();
		} catch (LineaIncorrectaEx e) {
			System.err.println(e + "durante la carga manual");
			e.printStackTrace();
		}

	}

	private static void cargarArchivo(Agenda agendaMain, Scanner scanner) {
		System.out.println("Ingresar la ruta del archivo\n");
		int contactosCargados = agendaMain.cargarArchivo(scanner.next());
		if (contactosCargados != 0) {
			System.out.println("Se cargaron con exito " + contactosCargados + " contactos");
		} else {
			System.err.println("No se pudo cargar ningun contacto");
		}
	}

	private static void guardarEnAgenda(Agenda agendaMain, Scanner scanner) {
		System.out.println("Ingresar la ruta del archivo donde quiere que se guarde la agenda");
		agendaMain.guardarAgenda(scanner.next());
		System.out.println("El archivo txt ya fue generado con exito");
	}

	private static void agregarContacto(Agenda agendaMain, Scanner scanner) throws LineaIncorrectaEx {
		Validacion validador = new Validacion();

		System.out.println("Ingrese el nombre del contacto");
		validador.setNombre(scanner.next());

		System.out.println("Ingrese el apellido del contacto");
		validador.setApellido(scanner.next());

		System.out.println("Ingrese el email del contacto\n");
		validador.setEmail(scanner.next());

		if (validador.contactoCompleto()) {
			agendaMain.agregarContacto(validador.getNombre(), validador.getApellido(), validador.getEmail());
			System.out.println(
					validador.getNombre() + " " + validador.getApellido() + " se a agregado a la agenda con exito");
		}
	}

	private static void borrarContacto(Agenda agendaMain, Scanner scanner) {

		System.out.println("Ingrese el nombre del contacto que quiere borrar");
		String dato = scanner.next();
		while (!dato.equals("n")) {
			try {
				agendaMain.borrarContacto(dato);
			} catch (ContactoInexistenteEx e) {
				System.err.println(e + " intente nuevamente o presione 'n' para volver al menu");
				dato = scanner.next();
			}
		}
	}

	private static boolean mostrarContactos(Agenda agendaMain, Scanner scanner) {

		agendaMain.mostrarTodosLosContactos();
		System.out.println("Desea volver al menu?\n"
				+ "presione 'y' para volver al menu o cualquier otra letra para salir del menu");
		return (scanner.next() == "y");

	}

	private static boolean salirDelPrograma(Scanner sc) {
		System.out.println("Saliste del programa");
		sc.close();
		return true;
	}

}
