package recursiva;
import java.util.ArrayList;
import java.util.List;

public class Recursiva {

	
	public int productoEscalar(ArrayList<Integer> listaUno, ArrayList<Integer> listaDos) {

		int contador = -1;
		int producto = 0;
		
		if(listaUno.size() != listaDos.size()) {
			throw new RuntimeException("No se puede hacer el producto");
 		} 		
		
		return productoEscalar(++contador,producto,listaUno, listaDos);
	}

	public int productoEscalar(int contador,int producto, ArrayList<Integer> listaUno, ArrayList<Integer> listaDos) {
		
		if(contador >= listaUno.size()) {
			return producto;
		}
		
		int numUno = listaUno.get(contador);
		int numDos = listaDos.get(contador);
		
		producto += numUno * numDos;
		
		return productoEscalar(++contador,producto,listaUno, listaDos);
		
	}
	
	public static void main(String[] args) {
		Recursiva recursiva = new Recursiva();
		ArrayList<Integer> listaUno = new ArrayList<Integer>(List.of(1,2,3));
		ArrayList<Integer> listaDos = new ArrayList<Integer>(List.of(4,5,6));
		System.out.println(recursiva.productoEscalar(listaUno,listaDos));
	}

}
