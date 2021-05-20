package ejercicios;
import java.util.Scanner;

public class ElegirUnNumero {

	private static int numeroAleatorio; 
	private static String valorIngresado;
	private static int numeroIngresado;
	
	private static Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) {
		
		boolean acerto = false;
		numeroAleatorio = generarNumeroAleatorio();	


		System.out.println("Elija un numero del 0 al 1000");
		
		valorIngresado = sc.next();
		
		while(!valorIngresado.contains("*") && !acerto ) {
		
			verificarSiElValorIngresadoEsUnInt();
			
			if(numeroAleatorio == numeroIngresado) {
				System.out.print("Correcto el numero era" + numeroAleatorio);
			}
			else {
				System.out.println("vuelva a intentar");				
				valorIngresado = sc.next();			
			}	
		}	
			
			System.out.print("Se ha terminado la ejecucion");
	}
	
	
	private static int generarNumeroAleatorio() {
		return (int)(Math.random()*1000);
	}
	
	
    private static void verificarSiElValorIngresadoEsUnInt() {        
        try {
            numeroIngresado = Integer.parseInt(valorIngresado);
			verificarRango(); 
        } 
        catch (NumberFormatException excepcion) {
            if(valorIngresado != "*")
            	throw new Error("Debe ingresar numeros o * para salir");
        }
    }
    
		
	private static void verificarRango() {
		if(numeroIngresado<0 || numeroIngresado>1000)
			System.out.print("El numero ingresado debe estar en el rango 0 a 1000");
	}	
}
