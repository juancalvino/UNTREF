package repaso;

public class Repaso {

	public boolean esPrimo(int numero) {
	
		boolean numeroEsPrimo = true;
		
		for(int i=2; i< Math.abs(numero) && numeroEsPrimo ; i++) {
				numeroEsPrimo = numero%i != 0;
		}
	
		return numeroEsPrimo;
	}
	
	public int sumarMultiplosDeTresYCinco(int hasta) {
		if(hasta < 0)
			throw new Error ("El valor ingresado debe ser mayor o igual que 0");
		
		int sumaTotal = 0;
		
		for(int i=3; i<hasta; i++) {
			
			if(i%3==0 || i%5==0)
				sumaTotal += i ;
		} 
		
		return sumaTotal;
	}

	public boolean estaOrdenado (int[] array) {
		
		boolean estaOrdenado = true;
		
		for(int i=1; i<array.length && estaOrdenado ;i++)
			estaOrdenado = (array[i-1]<array[i]);
		
		
		return estaOrdenado;
	}
	
	
	public int[][] devloverLaSumaDe(int[][] matrizUno, int[][] matrizDos){
		
		verificarSimilitudDeDimesionalidad(matrizUno, matrizDos);
		
		int[][] matrizResultante = new int[matrizUno.length][matrizUno[0].length];
		
		for(int i=0; i<matrizUno.length; i++) {
			for(int j=0; j<matrizUno[i].length; j++) {
				matrizResultante[i][j] = (matrizUno[i][j] + matrizDos[i][j]);
			}
		}
		
		return matrizResultante;
	}
	
	private void verificarRegularidad(int[][] matriz) {
		
		for(int i=1; i<matriz.length;i++) {
			if(matriz[0].length != matriz[i].length)
				throw new Error ("La matriz no es regular");
		}
	}
	
	private void verificarSimilitudDeDimesionalidad(int[][] matrizUno, int[][] matrizDos) {
		
		if(matrizUno.length != matrizDos.length ||
			matrizUno[0].length != matrizDos[0].length) {
			throw new Error("Las matrices tienen distintas dimensioner");
		}
		
		verificarRegularidad(matrizUno);
		verificarRegularidad(matrizDos);	
	}
	
	
	public int[] unirArraysOrdenados(int[] arrayUno, int[] arrayDos) {
	
		verificarSiEstaOrdenado(arrayUno);
		verificarSiEstaOrdenado(arrayDos);
		
		int[] arrayResultante = new int[(arrayUno.length + arrayDos.length)];
		
		int posicionInsercion = 0;
		int posicionArrayUno = 0;
		int posicionArrayDos = 0;
		
		while (posicionArrayUno < arrayUno.length 
				&&  posicionArrayDos < arrayDos.length) {
			
			if(arrayUno[posicionArrayUno] < arrayDos[posicionArrayDos]) {
				arrayResultante[posicionInsercion] = arrayUno[posicionArrayUno];
				posicionArrayUno++;
			}
			else{
				arrayResultante[posicionInsercion] = arrayDos[posicionArrayDos];
				posicionArrayDos++;
			}
			
			posicionInsercion++;
		}
		
		if(posicionArrayUno < arrayUno.length) {
			for(int i= posicionInsercion; i<arrayResultante.length;i++) {
			arrayResultante[posicionInsercion] = arrayUno[posicionArrayUno];
			posicionArrayUno++;
			}
		}
		else{
			for(int i= posicionInsercion; i<arrayResultante.length;i++) {
			arrayResultante[posicionInsercion] = arrayDos[posicionArrayDos];
			posicionArrayDos++;
			}
		}
		
		return arrayResultante;
		
	}
	
	private void verificarSiEstaOrdenado(int[] array) {
		
		for(int i=1; i<array.length;i++) {
			if(array[i-1] > array[i])
				throw new Error("El array no esta ordenado");
		}
	}


//	public int[] intercalarOrdenado(int[] a, int[] b) {
//		int[] resultado = new int[a.length + b.length];
//		int posicionA=0;
//		int posicionB=0;
//		int posicionR=0;
//		
//		while(posicionA < a.length && posicionB< b.length ) {
//			
//				if(a[posicionA] <= b[posicionB] && posicionA<a.length){
//					resultado[posicionR] = a[posicionA];
//					posicionA++;
//				}
//				else{
//					resultado[posicionR] = b[posicionB];
//					posicionB++;
//				}
//				posicionR++;
//			}
//		
//		
//			if(posicionA<a.length) {
//				while(posicionR<resultado.length) {
//				resultado[posicionR] = a[posicionA];
//				posicionA++;
//				posicionR++;
//				}
//			}
//			else {
//				while(posicionR<resultado.length) {
//				resultado[posicionR] = b[posicionB];
//				posicionB++;
//				posicionR++;
//				}			
//			}
//			
//		return resultado;
//	}	

	public int[] intercalarOrdenado(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
	
		int i = 0, j = 0;
	
		while (i + j < result.length) {
			
			if (i < a.length && (j == b.length || a[i] <= b[j])) {
				result[i + j] = a[i];
				i++;
			}
			if (j < b.length && (i == a.length || b[j] <= a[i])) {
				result[i + j] = b[j];
				j++;
			}
		}
		return result;
	}


}
