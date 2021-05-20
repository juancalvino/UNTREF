package cartas;
// No hacia falta insertarle valores pero lo dejo como material de consulta

public enum Valor {

	AS(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8), NUEVE(9), DIEZ(10), J(11), Q(12), K(13);

	int valor;

	private Valor(int numero) {
		this.valor = numero;
	}

}
