import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ImprimirCantidadDeNumeros {

	// Implemente un método que dado un archivo, que puede contener números y
	// palabras separados por espacios, calcule la cantidad de números encontrados
	// en el archivo. El método debe tratar las excepciones que puedan producirse,
	// mostrando mensajes de error apropiados en cada caso.


	public int cantidadDeNumeros(String pArchivo) {

		FileReader archivo = null;
		BufferedReader lector = null;
		int cantidadDeNumeros = 0;

		try {
			archivo = new FileReader(pArchivo);
			lector = new BufferedReader(archivo);
			String linea;

			while ((linea = lector.readLine()) != null) {
					cantidadDeNumeros += contarNumeros(linea);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (archivo != null)
				try {
					archivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return cantidadDeNumeros;
	}

	private int contarNumeros(String linea) {
		int numerosEnLaLinea = 0;
		String[] elementos = linea.split(" ");
		for (String elemento : elementos) {
			elemento = elemento.trim();
			try {
				 Integer.parseInt(elemento);
				 ++numerosEnLaLinea;
			} 
			catch (NumberFormatException e) {}
		}
		return numerosEnLaLinea;
	}

	
	public static void main(String[] args) {
		ImprimirCantidadDeNumeros x = new ImprimirCantidadDeNumeros();
		String texto = "/home/juan/Escritorio/ejercicio3";
		
		System.out.println(x.cantidadDeNumeros(texto));
	}

}
