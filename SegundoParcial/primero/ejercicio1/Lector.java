package ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Lector {

	
	public static void cargarArchivo(String pArchivo) {

		FileReader archivo = null;
		BufferedReader lector = null;
		int lineaNumero = 0;

		try {
			archivo = new FileReader(pArchivo);
			lector = new BufferedReader(archivo);
			String linea;

			while ((linea = lector.readLine()) != null) {
				++lineaNumero;
				
				try {
					cargarLinea(linea);
				}
				catch (NumberFormatException e) {
					System.err.println("Linea:"+ lineaNumero +" el valor " + e + " no es un numero");
				}
				catch (ValorDeDadosEx e) {
					System.err.println("Linea:" + lineaNumero + " " +e);
				}
				catch (ArrayIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
			}
		} 
		catch (FileNotFoundException e) {
			System.err.println("linea:"+ lineaNumero + " no se encontro el archivo" + e);
		} 
		catch (IOException e) {
			System.err.println("linea:"+ lineaNumero + " IO exception" + e);
		} 
		finally {
			if (archivo != null)
				try {
					archivo.close();
				} 
				catch (IOException e) {
					System.err.println("linea:"+ lineaNumero + " IO exception" + e);			
				}
			System.out.println("Ultima linea leida " + lineaNumero);
		}
	}
	
	
	private static void cargarLinea(String linea) throws NumberFormatException, ValorDeDadosEx{
		
		linea.trim();

		String[] datosSegmentados = linea.split(",");
		
			String jugador = datosSegmentados[0];
			int dado1 = Integer.parseInt(datosSegmentados[1]);
			int dado2 = Integer.parseInt(datosSegmentados[2]);
			int dado3 = Integer.parseInt(datosSegmentados[3]);
			
			Juego.getJuego().ingresarJugada(jugador, new int[]{dado1,dado2,dado3});
		
		
		
		
	}
	
}
