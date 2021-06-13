package caminosMinimos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import grafo.*;

import java.util.Queue;

// TODO esta mal implementado

public class Dijkstra {
     
	
	Map<String, LinkedList<Arista>> listaDeDestinos;
    Map<String, Double> listaDistanciaMinima = new HashMap<String, Double>();
    Map<String, String> listaAnterior = new HashMap<String, String>(); 
     
     public void calcularCaminoMinimo(Grafo grafo, Vertice origen) {
  
    	 Queue<Vertice> analizados = new LinkedList<Vertice>();
    	 
    	 listaDeDestinos = grafo.getColeccionDeAristas();
    	 iniciarDistancias(listaDeDestinos);
    	 
    	 listaDistanciaMinima.put(origen.getNombre(), 0.0);
    	 
    	 for(Arista vertice : listaDeDestinos.get(origen.getNombre())) {
    		if( vertice.getPeso() < listaDistanciaMinima.get(vertice.getDestino().getNombre())) {
    			listaDistanciaMinima.put(vertice.getDestino().getNombre(), vertice.getPeso());
    			listaAnterior.put(vertice.getDestino().getNombre(), origen.getNombre());
    			analizados.add(vertice.getDestino());
    		}
    	 }
    	 
    	 while(!analizados.isEmpty()) {
    		 
    		 Vertice verticeCola = analizados.poll();
    		  
    		 for(Arista arista: listaDeDestinos.get(verticeCola.getNombre())) {
    			 double peso = arista.getPeso();
    			 double acumulado = listaDistanciaMinima.get(verticeCola.getNombre()) + peso;
  
    			 if(acumulado < listaDistanciaMinima.get(arista.getDestino().getNombre())) {
    	    			listaDistanciaMinima.put(arista.getDestino().getNombre(), acumulado);
    	    			listaAnterior.put(arista.getDestino().getNombre(), verticeCola.getNombre());
    	    			analizados.add(arista.getDestino());
    			 }
    			 
    		 }
    	 }
	}
     
     public Map<String, String> devolverListaAnterior(){
    	 return listaAnterior;    	 
     }
     
     public Map<String, Double> devolverCostoMinimo(){
    	 return listaDistanciaMinima;    	 
     }
     
     private void  iniciarDistancias (Map<String, LinkedList<Arista>> listaDeDestinos ) {
    	 
    	 for (String elementos : listaDeDestinos.keySet()) {
			listaDistanciaMinima.put(elementos, Double.MAX_VALUE);
		}
     }    	 
	
}