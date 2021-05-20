package Alumnos;

import java.security.KeyStore.Entry;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DepartamentoDeAlumnos {

	Map<String, List<String>> salida = new TreeMap<String, List<String>>();

	public Map<String, List<String>> ordenarInformacioPorAlumno(Map<String, List<String>> entrada) {

		for (Map.Entry<String, List<String>> elemento : entrada.entrySet()) {
			for (String alumno : elemento.getValue()) {
				if (!salida.containsKey(alumno)) {
					salida.put(alumno, new LinkedList<String>(List.of(elemento.getKey())));
				} else {
					salida.get(alumno).add(elemento.getKey());
					salida.get(alumno).sort(new ordenamientoDeFechas());
				}
			}
		}
		return salida; 
	}
	
	public String enlistarSalida() {
		return salida.toString();
	}

	public static void main(String[] args) {
		DepartamentoDeAlumnos dep = new DepartamentoDeAlumnos();
		Map<String, List<String>> entrada = new HashMap<String, List<String>>();
		entrada.put("Mie 17", new LinkedList<String>(List.of("Luz", "Pedro", "Manuel")));
		entrada.put("Vie 12", new LinkedList<String>(List.of("Ana", "Luz")));
		entrada.put("Mie 10", new LinkedList<String>(List.of("Ana", "Pedro")));

		System.out.println(dep.ordenarInformacioPorAlumno(entrada));

	}
}
