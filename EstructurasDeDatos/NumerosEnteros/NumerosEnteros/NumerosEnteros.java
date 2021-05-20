package NumerosEnteros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NumerosEnteros {

		
	public List<Integer> devolverDeMayorAMenorSinRepetir(List<Integer> listaDeNumeros){
		Set<Integer> listaOrdenada = new TreeSet<Integer>(Collections.reverseOrder());
		listaOrdenada.addAll(listaDeNumeros);
		return new ArrayList<Integer>(listaOrdenada);
	}
	
	public static void main(String[] args) {
		List<Integer> listaDeNumeros = new ArrayList<Integer>(List.of(4,5,3,1,6,7,10,4,4,5,5,777,7,6,2));
		
		System.out.println(new NumerosEnteros().devolverDeMayorAMenorSinRepetir(listaDeNumeros));
		
	}
	
}
