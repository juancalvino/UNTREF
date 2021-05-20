package conjuntosDiccionariosYColasDePrioridad;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CargaDeArchivos {

	public boolean agregarEmpleados(String pArchivo) {

		FileReader archivo = null;
		BufferedReader lector = null;

		try {
			archivo = new FileReader(pArchivo);
			lector = new BufferedReader(archivo);
			String linea;

			while ((linea = lector.readLine()) != null) {
				linea.trim();
				String[] datosSeparados = linea.split(",");
				for (String datos : datosSeparados) {
					String[] info = datos.trim().split("-");
					String nombre = info[0].trim();
					int edad = Integer.parseInt(info[1]);
//					listaDeEmpleados.add(new Empleado(nombre, edad));
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
		return false;
	}
	
}
