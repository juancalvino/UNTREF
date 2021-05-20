import java.security.KeyStore.Entry;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 Se tiene una agenda cuyas claves son nombres y cuyos datos son numeros de telefono.
Se necesita escribir un metodo que reciba una cadena e imprima todos los nombres y telefonos de la gente cuyos nombres empiezan con la cadena dada. Por ejemplo si la agenda es la siguiente:

Jose 	 45667788
Ana	 45332211
Abu	 33227788
Anabela  55664433
Anacleto 66778899
Adri	 99008866
Azucena  44880099

y la cadena es "An" debe imprimir:

Ana	 45332211
Anabela  55664433
Anacleto 66778899

 Elegir una implementacion adecuada para la agenda de modo, implementar el metodo pedido e indicar cual es su eficiencia. (Java posse un metodo public boolean strarWith(String prefix)). 
 */

public class Agenda {

	Map<String, Integer> agenda = new TreeMap<String, Integer>();
	
	public Map<String, Integer> contactosQueEmpiezanCon(String prefijoDelNombre) {
		Map<String, Integer> agendaFiltrada = new TreeMap<String, Integer>();
		for (Map.Entry<String, Integer> contacto: agenda.entrySet()) {
			if(contacto.getKey().toLowerCase().startsWith(prefijoDelNombre.toLowerCase())) {
				agendaFiltrada.put(contacto.getKey(), contacto.getValue());
			}
		}
		return agendaFiltrada;
	}
	
	public void agregarContacto(String nombre, Integer telefono) {
		agenda.put(nombre, telefono);
	}
	
	public Map<String, Integer> getAgenda(){
		return agenda;
	}

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		agenda.agregarContacto("Jose", 45667788);
		agenda.agregarContacto("Ana", 45332211);
		agenda.agregarContacto("Abu", 33227788);
		agenda.agregarContacto("Anabela", 55664433);
		agenda.agregarContacto("Anacleto", 66778899);
		agenda.agregarContacto("Adri", 99008866);
		agenda.agregarContacto("Azucena", 44880099);
		
		System.out.println(agenda.getAgenda());
		
		System.out.println(agenda.contactosQueEmpiezanCon("an"));
	}

}




