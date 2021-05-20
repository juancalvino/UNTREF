package casaInteligente;

import java.util.LinkedList;
import java.util.List;


public class SistemaCentral {
	/**
	 * Implemente un método que permita al sistema central cerrar toda la casa
	 * (cerrar el/los portones, apagar el/los televisores, apagar la/s luces
	 * interiores y exteriores secundarias) y otro para abrirla (abrir el/los
	 * portes, encender e/los televisores y encender la/s luces interiores y
	 * exteriores secundarias) cuando el usuario lo requiera.
	 */
	List<ObjetoInteligente> objetos = new LinkedList<ObjetoInteligente>();

	public void apagar(ObjetoInteligente objeto) {
		objeto.apagar();
	}

	public void encender(ObjetoInteligente objeto) {
		objeto.encender();
	}

	public void cerrarCasa() {
		for (ObjetoInteligente oI : objetos) {
			oI.apagarAutomatico();
		}
	}

	public void abrirCasa() {
		for (ObjetoInteligente oI : objetos) {
			oI.encender();
		}
	}

	public List<ObjetoInteligente> getObjeto() {
		return objetos;
	}

	public void agregarObjetoInteligente(ObjetoInteligente objeto) {
		this.objetos.add(objeto);
	}

	
	public static void main(String[] args) {
		SistemaCentral sc = new SistemaCentral();
		sc.agregarObjetoInteligente(new LuzExterior("Arboles", 25));
		sc.agregarObjetoInteligente(new LuzExteriorPrincipal("patio", 25));
		sc.cerrarCasa();
		sc.abrirCasa();
//		System.out.println(sc.getObjeto());
	}

}
