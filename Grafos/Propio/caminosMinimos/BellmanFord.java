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
//		boolean hayCambios = true;
//		int contador = 0;
		
		inicializarListaDeDistanciaMinima(grafo.getColeccionDeAristas().keySet(), origen);
		
		for(Arista arista : grafo.getArestasDeSalidaDel(origen)) {
			Vertice destino = arista.getDestino();
			
			if( arista.getPeso() < listaDeDistanciaMinima.get(destino.getNombre())) {
				listaDeDistanciaMinima.put(destino.getNombre(), arista.getPeso());
				listaPredecedores.put(destino.getNombre(), origen.getNombre());
				adyacentes.add(destino);
			}
		}
		
//		
//		while(hayCambios) {
//			hayCambios = false;



//Para i desde 1 hasta |V|-1:
//Para toda arista (v, w) de A:
//si D[v] + peso (v, w) < D[w] ent
//D[w] = D[v] + peso (v,w) y P[w]=v
//
	
//		while(!adyacentes.isEmpty() && contador < grafo.getColeccionDeAristas().size() + 1) {
			for(int i=1; i < grafo.getColeccionDeAristas().size(); i++) {
//				contador++;		
				Vertice analizado = adyacentes.poll();	
				
				for(Arista arista : grafo.getArestasDeSalidaDel(analizado)) {
				
					Vertice destino = arista.getDestino();
					double nuevaDistancia  = arista.getPeso() + listaDeDistanciaMinima.get(analizado.getNombre());
					
					if(nuevaDistancia < listaDeDistanciaMinima.get(destino.getNombre())) {
						
						listaDeDistanciaMinima.put(destino.getNombre(), nuevaDistancia);
						listaPredecedores.put(destino.getNombre(), analizado.getNombre());
						adyacentes.add(destino);
		
//						hayCambios = true;
					}
				}
			}	
//		}
			
			Vertice analizado = adyacentes.peek();
			for(Arista arista : grafo.getArestasDeSalidaDel(analizado)) {
				
				Vertice destino = arista.getDestino();
				double nuevaDistancia  = arista.getPeso() + listaDeDistanciaMinima.get(analizado.getNombre());
				
				if(nuevaDistancia < listaDeDistanciaMinima.get(destino.getNombre())) {
					throw new RuntimeException();
				}
			}
	}
			
			
//		if(contador > grafo.getColeccionDeAristas().size()) {
//			throw new RuntimeException("El grafo tiene ciclos");
//		}
//	}	
	
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
