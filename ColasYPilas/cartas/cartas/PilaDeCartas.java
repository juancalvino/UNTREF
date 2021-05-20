package cartas;
import pilas.PilaSobreListaEnlazada;

public class PilaDeCartas {

	PilaSobreListaEnlazada<Carta> mazo = new PilaSobreListaEnlazada<Carta>();
	PilaSobreListaEnlazada<Carta> pila = new PilaSobreListaEnlazada<Carta>();
	

	public boolean apilar(Carta carta) {
		
		if(pila.estaVacia()) {
			pila.apilar(carta);
			return true;
		}
		
		Carta cartaTope = pila.obtenerTope();
		
		if (cartaTope.getPalo() == carta.getPalo()) {
			if(cartaTope.getValor() - carta.getValor() == 1) {
				pila.apilar(carta);
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		PilaDeCartas pdc = new PilaDeCartas();
		Carta c1 = new Carta(Valor.TRES, Palo.CORAZON);
		System.out.println(pdc.apilar(c1));
		Carta c2 = new Carta(Valor.DOS, Palo.CORAZON);
		Carta c3 = new Carta(Valor.J,Palo.CORAZON);
		System.out.println(pdc.apilar(c2));
		System.out.println(pdc.apilar(c3));
		
		
	}




}
