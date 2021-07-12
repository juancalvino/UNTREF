package ejercicio1;

public class Prueba {

	public static void main(String[] args) {
		Lector.cargarArchivo("/home/juan/Escritorio/dados.csv");
		System.out.println(Juego.getJuego().listarPodio());
	}
}
