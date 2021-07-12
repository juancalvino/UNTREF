package biPartito;

import org.junit.Assert;
import org.junit.Test;

public class GrafoTest {

	
	@Test
	public void grafoBipartitoEmpezandoPorV1() {
		Grafo grafo = new Grafo();
		grafo.agregarArista("V1", "V2", 1);
		grafo.agregarArista("V2", "V1", 1);

		grafo.agregarArista("V1", "V3", 1);
		grafo.agregarArista("V3", "V1", 1);

		grafo.agregarArista("V2", "V4", 1);
		grafo.agregarArista("V4", "V2", 1);

		grafo.agregarArista("V2", "V5", 1);
		grafo.agregarArista("V5", "V2", 1);

		grafo.agregarArista("V4", "V3", 1);
		grafo.agregarArista("V3", "V4", 1);

		grafo.agregarArista("V5", "V3", 1);
		grafo.agregarArista("V3", "V5", 1);
		
		Assert.assertTrue(grafo.verificarSiEsBipartito("V1"));
	}
	
	
	@Test
	public void grafoBipartitoEmpezandoPorV3() {
		Grafo grafo = new Grafo();
		grafo.agregarArista("V1", "V2", 1);
		grafo.agregarArista("V2", "V1", 1);

		grafo.agregarArista("V1", "V3", 1);
		grafo.agregarArista("V3", "V1", 1);

		grafo.agregarArista("V2", "V4", 1);
		grafo.agregarArista("V4", "V2", 1);

		grafo.agregarArista("V2", "V5", 1);
		grafo.agregarArista("V5", "V2", 1);

		grafo.agregarArista("V4", "V3", 1);
		grafo.agregarArista("V3", "V4", 1);

		grafo.agregarArista("V5", "V3", 1);
		grafo.agregarArista("V3", "V5", 1);
		
		Assert.assertTrue(grafo.verificarSiEsBipartito("V3"));
	}
	
	
	@Test
	public void grafoNOBipartitoEmpezandoPorV1() {
		Grafo grafo = new Grafo();
		grafo.agregarArista("V1", "V2", 1);
		grafo.agregarArista("V2", "V1", 1);

		grafo.agregarArista("V1", "V3", 1);
		grafo.agregarArista("V3", "V1", 1);

		grafo.agregarArista("V2", "V4", 1);
		grafo.agregarArista("V4", "V2", 1);

		grafo.agregarArista("V2", "V5", 1);
		grafo.agregarArista("V5", "V2", 1);

		grafo.agregarArista("V4", "V5", 1);
		grafo.agregarArista("V3", "V4", 1);

		grafo.agregarArista("V5", "V3", 1);
		grafo.agregarArista("V3", "V5", 1);
		
		Assert.assertFalse(grafo.verificarSiEsBipartito("V1"));
	}
	
	
	@Test
	public void grafoNOBipartitoEmpezandoPorV4() {
		Grafo grafo = new Grafo();
		grafo.agregarArista("V1", "V2", 1);
		grafo.agregarArista("V2", "V1", 1);

		grafo.agregarArista("V1", "V3", 1);
		grafo.agregarArista("V3", "V1", 1);

		grafo.agregarArista("V2", "V4", 1);
		grafo.agregarArista("V4", "V2", 1);

		grafo.agregarArista("V2", "V5", 1);
		grafo.agregarArista("V5", "V2", 1);

		grafo.agregarArista("V4", "V5", 1);
		grafo.agregarArista("V3", "V4", 1);

		grafo.agregarArista("V5", "V3", 1);
		grafo.agregarArista("V3", "V5", 1);
		
		Assert.assertFalse(grafo.verificarSiEsBipartito("V4"));
	}
	
	@Test
	public void grafoConUnVerticeAutoDireccionado() {
		Grafo grafo = new Grafo();
		grafo.agregarArista("V1", "V1", 1);

		
		Assert.assertFalse(grafo.verificarSiEsBipartito("V1"));
	}

}
