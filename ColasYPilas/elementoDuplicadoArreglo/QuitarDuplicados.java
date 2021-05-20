import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class QuitarDuplicados<E> {

	public Integer[] quitarRepetidos(Integer[] array) {
		Set<Integer> conjunto = new HashSet<Integer>();
		
		for (Integer elemento : array) {
			conjunto.add(elemento);
		}
		
		Integer[] nuevoArray = new Integer[conjunto.size()];

		return conjunto.toArray(nuevoArray);
	
	}
	
	public static void main(String[] args) {
		Integer [] arreglo = {1,1,1,2,3,4,5,2,3,5,6};
		QuitarDuplicados<Integer> nuevoConjunto = new QuitarDuplicados<>(); 
		arreglo = nuevoConjunto.quitarRepetidos(arreglo);

		for (int i = 0; i < arreglo.length; i++) {
			System.out.println(arreglo[i]);
		}
	
	}
}
