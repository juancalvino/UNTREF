package caminosMinimos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import grafo.Arista;
import grafo.Grafo;
import grafo.Vertice;

public class BellmanFord {

	Map<String,Double> listaDeDistanciaMinima;
	Map<String, String> listaPredecedores;
	
	public void calcularCaminoMinimo(Grafo grafo, Vertice origen) {
		
		Queue<Vertice> adyacentes = new LinkedList<Vertice>();
		
		inicializarListaDeDistanciaMinima(grafo.getColeccionDeVectoresConSusAristas().keySet(), origen);
		
		for(Arista arista : grafo.getArestasDeSalidaDel(origen)) {
			Vertice destino = arista.getDestino();
			
			if( arista.getPeso() < listaDeDistanciaMinima.get(destino.getNombre())) {
				listaDeDistanciaMinima.put(destino.getNombre(), arista.getPeso());
				listaPredecedores.put(destino.getNombre(), origen.getNombre());
				adyacentes.add(destino);
			}
		}

			for(int i=1; i < grafo.getColeccionDeVectoresConSusAristas().size(); i++) {
				Vertice analizado = adyacentes.poll();	
				
				for(Arista arista : grafo.getArestasDeSalidaDel(analizado)) {
				
					Vertice destino = arista.getDestino();
					double nuevaDistancia  = arista.getPeso() + listaDeDistanciaMinima.get(analizado.getNombre());
					
					if(nuevaDistancia < listaDeDistanciaMinima.get(destino.getNombre())) {
						
						listaDeDistanciaMinima.put(destino.getNombre(), nuevaDistancia);
						listaPredecedores.put(destino.getNombre(), analizado.getNombre());
						adyacentes.add(destino);
		
					}
				}
			}	
			
			for(String vertice : grafo.getColeccionDeVectoresConSusAristas().keySet()) {
			
				for(Arista arista : grafo.getArestasDeSalidaDel(vertice)) {
					
					Vertice destino = arista.getDestino();
					double nuevaDistancia  = arista.getPeso() + listaDeDistanciaMinima.get(vertice);
					
					if(nuevaDistancia < listaDeDistanciaMinima.get(destino.getNombre())) {
						throw new RuntimeException();
					}
				}
			}
	}
			
			
	private void inicializarListaDeDistanciaMinima(Set<String> setVertices, Vertice origen){
		
		listaDeDistanciaMinima = new HashMap<String, Double>();
		listaPredecedores = new HashMap<String, String>();
		
		for(String vertice : setVertices) {
			listaDeDistanciaMinima.put(vertice, Double.MAX_VALUE);
			listaPredecedores.put(vertice, null);
		}
		
		listaDeDistanciaMinima.put(origen.getNombre(), 0.0);
			
	}
	
	public Map<String, Double> getListaDeDistanciaMinima() {
		return listaDeDistanciaMinima;
	}

	public Map<String, String> getListaPredecedores() {
		return listaPredecedores;
	}

	
}
