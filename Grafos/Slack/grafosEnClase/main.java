package grafosEnClase;

import algoritmosEnClase.BellmanFord;
import algoritmosEnClase.Dijktra;
import algoritmosEnClase.OrdenamientoTopologico;

public class main {


	public static void main(String[] args) {

		Grafo grafoConAristaPositivas = new Grafo();
		Grafo grafoConAristaNegativas = new Grafo();
		
		grafoConAristaPositivas.agregarArista("V0", "V1", 1);
		grafoConAristaPositivas.agregarArista("V0", "V2", 2);
		grafoConAristaPositivas.agregarArista("V1", "V3", 3);
		grafoConAristaPositivas.agregarArista("V2", "V4", 3);
		grafoConAristaPositivas.agregarArista("V3", "V5", 4);
		grafoConAristaPositivas.agregarArista("V4", "V5", 4);
		
		System.out.println(grafoConAristaPositivas);
		System.out.println(new OrdenamientoTopologico(grafoConAristaPositivas.getGrafo()).ordenar());
		System.out.println(new Dijktra(grafoConAristaPositivas.getGrafo()).ordenar("V0"));
		
		System.out.println();
		
		grafoConAristaNegativas.agregarArista("VA", "VB", 1);
		grafoConAristaNegativas.agregarArista("VA", "VC", 1);
		grafoConAristaNegativas.agregarArista("VC", "VB", -2);
		grafoConAristaNegativas.agregarArista("VC", "VD", 1);
		grafoConAristaNegativas.agregarArista("VD", "VE", 1);
		grafoConAristaNegativas.agregarArista("VB", "VE", 3);

		System.out.println(grafoConAristaNegativas);
		System.out.println(new OrdenamientoTopologico(grafoConAristaNegativas.getGrafo()).ordenar());
		System.out.println(new BellmanFord(grafoConAristaNegativas.getGrafo()).ordenar("VA"));
	}
	
}
