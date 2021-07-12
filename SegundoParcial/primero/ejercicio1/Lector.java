package ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Lector {

	Juego juego = new Juego();
	
	public void cargarArchivo(String pArchivo) {

		FileReader archivo = null;
		BufferedReader lector = null;

		try {
			archivo = new FileReader(pArchivo);
			lector = new BufferedReader(archivo);
			String linea;

			while ((linea = lector.readLine()) != null) {
				try {
					cargarLinea(linea);
				}
				catch (ArrayIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
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
	}
	
	
	private void cargarLinea(String linea) {
		linea.trim();

		String[] datosSegmentados = linea.split(",");
		
		try {
			int jugador = Integer.parseInt(datosSegmentados[0]);
			int dado1 = Integer.parseInt(datosSegmentados[1]);
			int dado2 = Integer.parseInt(datosSegmentados[2]);
			int dado3 = Integer.parseInt(datosSegmentados[3]);
		
			int[] jugada = {dado1,dado2,dado3};

			juego.ingresarJugada(jugador, jugada);
		}
		catch (NumberFormatException e) {
			e.getStackTrace();
		}
		
		
		
	}
	
}
