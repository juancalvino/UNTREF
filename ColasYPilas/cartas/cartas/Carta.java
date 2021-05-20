package cartas;

public class Carta {

	Valor valor;
	Palo palo;
	
	public Carta(Valor valor, Palo palo) {
		this.valor = valor;
		this.palo = palo;
	}

	public Palo getPalo() {
		return this.palo;
	}

	public int getValor() {
		return this.valor.ordinal();
	}
	
	
	
}
