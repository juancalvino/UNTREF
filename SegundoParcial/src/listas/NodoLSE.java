package listas;

public class NodoLSE<CualquierTipo> {

	private CualquierTipo dato;
	private NodoLSE<CualquierTipo> sigte;

	public NodoLSE() {
		this.dato = null;
	}

	public NodoLSE(CualquierTipo miDato) {
		this.dato = miDato;
	}

	public CualquierTipo obtDato() {
		return dato;
	}

	

	public NodoLSE<CualquierTipo> obtSigte() {
		return sigte;
	}

	public void asigSigte(NodoLSE<CualquierTipo> otroNodo) {
		this.sigte = otroNodo;
	}

	

	public void enlazarLuegoDe(NodoLSE<CualquierTipo> nodoAnterior) {
		this.asigSigte(nodoAnterior.obtSigte());
		nodoAnterior.asigSigte(this);
	}

	public void desenlazarElSiguienteNodo() {
		this.asigSigte(this.obtSigte().obtSigte());
	}

}
