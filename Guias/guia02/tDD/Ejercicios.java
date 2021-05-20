package tDD;

public class Ejercicios {

	public int sumarMultiplosTresYCinco(int hasta) {
		verificarPositividad(hasta);
		
		int total = 0;
		
		for(int i=3; i<hasta; i++) {
			if(i%3==0 || i%5==0)
				total+=i;
		}
		
		return total;
	}
	
	private void verificarPositividad(int numero) {
		if (numero<0)
			throw new Error("el numero indicado debe ser igual o mayor a 0");
	}
}
