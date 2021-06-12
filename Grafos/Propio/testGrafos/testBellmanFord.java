package testGrafos;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import caminosMinimos.BellmanFord;
import grafo.Grafo;
import grafo.Vertice;

public class testBellmanFord {

	@Test
	public void conVerticesDeLaClase(){
		// PPT 12	    
		//https://docs.google.com/presentation/d/1i4zN2ZyPai-diMmu6C0y86l0KWEpxmLobIeHmeUjYDQ/edit#slide=id.g593a12d76f_0_0

		
		Grafo grafo = new Grafo();
		
		grafo.agregarArista(new Vertice("VA"), new Vertice("VC"), 1);
		grafo.agregarArista(new Vertice("VA"), new Vertice("VB"), 1);
		grafo.agregarArista(new Vertice("VC"), new Vertice("VB"), -2);
		grafo.agregarArista(new Vertice("VC"), new Vertice("VD"), 1);
		grafo.agregarArista(new Vertice("VD"), new Vertice("VE"), 1);
		grafo.agregarArista(new Vertice("VB"), new Vertice("VE"), 3);
		
		BellmanFord bellman = new BellmanFord();
		
		bellman.calcularCaminoMinimo(grafo, new Vertice("VA"));
		
		Assert.assertEquals("{VA=0.0, VB=-1.0, VC=1.0, VD=2.0, VE=2.0}" 
							, bellman.getListaDeDistanciaMinima().toString());

		Assert.assertEquals("{VA=null, VB=VC, VC=VA, VD=VC, VE=VB}" 
				, bellman.getListaPredecedores().toString());
	}	
	
	
	@Test(expected = RuntimeException.class)
	public void conUnCicloNegativo(){

		Grafo grafo = new Grafo();
		
		grafo.agregarArista(new Vertice("VA"), new Vertice("VC"), 1);
		grafo.agregarArista(new Vertice("VA"), new Vertice("VB"), 1);
		grafo.agregarArista(new Vertice("VC"), new Vertice("VB"), -2);
		grafo.agregarArista(new Vertice("VB"), new Vertice("VA"), -2);		
		grafo.agregarArista(new Vertice("VC"), new Vertice("VD"), 1);
		grafo.agregarArista(new Vertice("VD"), new Vertice("VE"), 1);
		grafo.agregarArista(new Vertice("VB"), new Vertice("VE"), 3);
		
		BellmanFord bellman = new BellmanFord();
		
		bellman.calcularCaminoMinimo(grafo, new Vertice("VA"));
		

	}

	@Test
	public void BellmanConUnVerticeDeGradoDeSalida3YUnaAristaNegativa(){
		
		Grafo grafo = new Grafo();
		
		grafo.agregarArista(new Vertice("VA"), new Vertice("VC"), 1);
		grafo.agregarArista(new Vertice("VA"), new Vertice("VB"), 1);
		grafo.agregarArista(new Vertice("VC"), new Vertice("VB"), -2);
		grafo.agregarArista(new Vertice("VC"), new Vertice("VE"), -1);
		grafo.agregarArista(new Vertice("VC"), new Vertice("VD"), 1);
		grafo.agregarArista(new Vertice("VD"), new Vertice("VE"), 1);
		grafo.agregarArista(new Vertice("VB"), new Vertice("VE"), 3);
		
		BellmanFord bellman = new BellmanFord();
		
		bellman.calcularCaminoMinimo(grafo, new Vertice("VA"));
		
		Assert.assertEquals("{VA=0.0, VB=-1.0, VC=1.0, VD=2.0, VE=0.0}" 
							, bellman.getListaDeDistanciaMinima().toString());

		Assert.assertEquals("{VA=null, VB=VC, VC=VA, VD=VC, VE=VC}" 
				, bellman.getListaPredecedores().toString());
	}	
	
	@Test(expected = RuntimeException.class)
	public void BellmanConUnVerticeDeGradoDeSalida3YUnaAristaNegativaYUnCicloNegativo(){

		Grafo grafo = new Grafo();
		
		grafo.agregarArista(new Vertice("VA"), new Vertice("VC"), 1);
		grafo.agregarArista(new Vertice("VA"), new Vertice("VB"), 1);
		grafo.agregarArista(new Vertice("VC"), new Vertice("VB"), -2);
		grafo.agregarArista(new Vertice("VC"), new Vertice("VE"), -1);
		grafo.agregarArista(new Vertice("VB"), new Vertice("VA"), -2);		
		grafo.agregarArista(new Vertice("VC"), new Vertice("VD"), 1);
		grafo.agregarArista(new Vertice("VD"), new Vertice("VE"), 1);
		grafo.agregarArista(new Vertice("VB"), new Vertice("VE"), 3);
		
		BellmanFord bellman = new BellmanFord();
		
		bellman.calcularCaminoMinimo(grafo, new Vertice("VA"));
		

	}
	
	
}
