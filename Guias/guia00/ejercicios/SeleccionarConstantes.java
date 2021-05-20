package ejercicios;
import java.util.Scanner;

public class SeleccionarConstantes {

//	Escribir una función consonantes que recibe una cadena de caracteres y devuelve 
//	la cadena que resulta de eliminar todas las vocales de la cadena recibida. Por ejemplo:
//		consonantes("hola como estas"); // devuelve "hl cm sts"
	
    public String consonantes(String palabra){
        return palabra.replaceAll("[a + e + o + u + i ]", "");
      }
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SeleccionarConstantes sc = new SeleccionarConstantes();
		System.out.println(sc.consonantes(new Scanner(System.in).nextLine()));
	}
}