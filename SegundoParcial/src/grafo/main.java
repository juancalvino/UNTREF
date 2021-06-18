package grafo;

public class main {
	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		
		
		grafo.agregarArista("A","B",3);
		grafo.agregarArista("A","D",3);

		grafo.agregarArista("B","C",2);
		
		grafo.agregarArista("D","E",1);
		grafo.agregarArista("E","C",1);
		
		System.out.println(grafo.dijkstra("A"));

	}
}
