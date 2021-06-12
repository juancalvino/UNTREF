package propio.OrdenamientoTopologico;

import ordenTopologico1.Grafo;
import ordenTopologico1.Vertice;

public class main {
	
	public static void main(String[] args) {
			
			Grafo grafo = new Grafo();
			
			grafo.agregarArista(new Vertice("V0"),new Vertice("V1"));
			grafo.agregarArista(new Vertice("V0"),new Vertice("V2"));
			grafo.agregarArista(new Vertice("V1"),new Vertice("V3"));
			grafo.agregarArista(new Vertice("V2"),new Vertice("V4"));
			grafo.agregarArista(new Vertice("V3"),new Vertice("V5"));
			grafo.agregarArista(new Vertice("V4"),new Vertice("V5"));
		
			System.out.println(grafo.getColeccionDeVectores());
			System.out.println(grafo);
			System.out.println(grafo.calcularGradosDeEntrada());
	
			OrdenamientoTopologico ordenamiento = new OrdenamientoTopologico();
			
			System.out.println(ordenamiento.ordenarGrafo(grafo));
		}
}
