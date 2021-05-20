import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ListaDeNumeros {

	public int[] arrayCon100NumerosAleatorios() {
		int[] array = new int[100];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*100);;
			System.out.println(array[i]);
		}
	return array;
	}
	
	public int[] mostarElementosSinRepetir(int[] array) {
		Set<Integer> conjunto = new HashSet<Integer>();
		
		for (int numero : array) {
			conjunto.add(numero);
		}
		
		int[] nuevoArreglo = new int[conjunto.size()];
		
		int indice = 0;
		
		for(Integer i : conjunto) { 
		    nuevoArreglo[indice++] = i;
		} 
		
		return nuevoArreglo;
	}
	
	public int[] mostarElementosSinRepetirOrdenados(int[] array) {
		Set<Integer> conjunto = new TreeSet<Integer>(Collections.reverseOrder());
		
		for (int numero : array) {
			conjunto.add(numero);
		}
		
		int[] nuevoArreglo = new int[conjunto.size()];
		
		int indice = 0;
		
		for(Integer i : conjunto) { 
		    nuevoArreglo[indice++] = i;
		} 
		
		return nuevoArreglo;
	}
	
	public static void main(String[] args) {
		ListaDeNumeros lista = new ListaDeNumeros();
		int[] arreglo = lista.arrayCon100NumerosAleatorios();
		arreglo = lista.mostarElementosSinRepetir(arreglo);
	
		for (int i = 0; i < arreglo.length; i++) {
			System.out.println(arreglo[i]);
		}
		
		System.out.println("Cantidad de numeros: " + arreglo.length);
	}
}
