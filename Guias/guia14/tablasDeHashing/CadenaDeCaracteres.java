package tablasDeHashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Escribir una función que reciba una cadena de caracteres muestre por pantalla
 * la frecuencia de aparición de cada letra. Por ejemplo:
 * 
 * frecuencias("hola como estas..."); // debe mostrar por pantalla:
 * 
 * > a: 2 c: 1 e: 1 h: 1 l: 1 m: 1 o: 3 s: 2 t: 1
 * 
 */

public class CadenaDeCaracteres {
	
	private int[] cantidad; 
	private char[] letras; 

	
	public CadenaDeCaracteres() {
		cantidad = new int[31];
		letras = new char[31];

	}

	public String frecuenciaDeLetrasEn(String frase) {

		String frecuencia = "";
		
		for(int i=0; i<frase.length(); i++) {
			int posicion = hash(frase.charAt(i));
			cantidad[posicion]++;
			letras[posicion] = frase.charAt(i);
		}

		for(int i=0; i<cantidad.length; i++) {
			if(cantidad[i] >0) {
				frecuencia += letras[i] + ": " + cantidad[i] + "\n";
				cantidad[i] = 0;
			}
		}

		return frecuencia;
	}

	private int hash(char x) {
		return x % cantidad.length;
	}

	public String frecuenciaConMapa(String frase) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<frase.length(); i++) {
			char letra = frase.charAt(i);
			if(!map.containsKey(frase.charAt(i))) {
				map.put(letra, 1);
			}
			else {
				map.put(letra, map.get(letra)+1);
			}
		}
		
		
		
		return map.toString();
	}
	
	public static void main(String[] args) {
		CadenaDeCaracteres cadena = new CadenaDeCaracteres();
		System.out.println(cadena.frecuenciaDeLetrasEn("hola como estas"));
		System.out.println(cadena.frecuenciaConMapa("hola como estas"));
		
	}
}
