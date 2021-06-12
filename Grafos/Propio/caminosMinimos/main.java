package caminosMinimos;

import grafo.Grafo;
import grafo.Vertice;

public class main {
	
	public static void main(String[] args) {
			
			Grafo grafo = new Grafo();
			
			grafo.agregarArista(new Vertice("A"),new Vertice("F"),7);
			grafo.agregarArista(new Vertice("A"),new Vertice("G"),1);
			grafo.agregarArista(new Vertice("A"),new Vertice("D"),2);

			grafo.agregarArista(new Vertice("F"),new Vertice("A"),7);
			grafo.agregarArista(new Vertice("F"),new Vertice("B"),2);

			grafo.agregarArista(new Vertice("G"),new Vertice("A"),1);
			grafo.agregarArista(new Vertice("G"),new Vertice("B"),5);
			grafo.agregarArista(new Vertice("G"),new Vertice("E"),9);

			grafo.agregarArista(new Vertice("B"),new Vertice("G"),5);
			grafo.agregarArista(new Vertice("B"),new Vertice("E"),1);
			grafo.agregarArista(new Vertice("B"),new Vertice("D"),4);
			grafo.agregarArista(new Vertice("B"),new Vertice("F"),2);
			
			grafo.agregarArista(new Vertice("E"),new Vertice("B"),1);
			grafo.agregarArista(new Vertice("E"),new Vertice("G"),9);
			grafo.agregarArista(new Vertice("E"),new Vertice("D"),2);
			grafo.agregarArista(new Vertice("E"),new Vertice("C"),5);

			
			grafo.agregarArista(new Vertice("D"),new Vertice("A"),2);
			grafo.agregarArista(new Vertice("D"),new Vertice("B"),4);
			grafo.agregarArista(new Vertice("D"),new Vertice("E"),2);
			grafo.agregarArista(new Vertice("D"),new Vertice("C"),8);

			grafo.agregarArista(new Vertice("C"),new Vertice("D"),8);
			grafo.agregarArista(new Vertice("C"),new Vertice("E"),5);

			
			
			System.out.println(grafo.getColeccionDeAristas());
			System.out.println(grafo);
			System.out.println(grafo.calcularGradosDeEntrada());
			
			Dijkstra orden =  new Dijkstra();
			orden.calcularCaminoMinimo(grafo, new Vertice("A"));  
	
			System.out.println(orden.devolverCostoMinimo());
			System.out.println(orden.devolverListaAnterior());
			
			
			
		}
}
