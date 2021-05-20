package fizzBuzz;

public class FizzBuzz {

	public int devolverPimerosCienEmpezandoEn(int numero) {

		int posicion = numero;
		
		for(int numerosMostrados=0; numerosMostrados<100; numerosMostrados++) {
		
			boolean imprimirNumero = true; 
				
			if(posicion%3 == 0 && posicion != 0) {
				System.out.print("Fizz");
				imprimirNumero = false;
			}
			if(posicion%5 == 0 && posicion != 0) {
				System.out.print("Buzz");
				imprimirNumero = false;
			}
			if(imprimirNumero)
				System.out.print(posicion);

			System.out.println();
			posicion++;	
		}
		
		return posicion;
	}

}
