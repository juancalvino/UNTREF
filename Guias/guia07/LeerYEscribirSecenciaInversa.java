import java.util.Stack;

public class LeerYEscribirSecenciaInversa {

	@SuppressWarnings("serial")
	Stack<String> pilaDeStrings = new Stack<String>();
	
	String[] datos = {"a","b","c","d"};

	
	public void devolverListaDadaVuelta() {
		
		for(String dato : this.datos) {
			pilaDeStrings.push(dato);
		}

		while(!pilaDeStrings.isEmpty())
		System.out.println(pilaDeStrings.pop());
	}
	
	public static void main(String[] args) {
		LeerYEscribirSecenciaInversa x = new LeerYEscribirSecenciaInversa();
		x.devolverListaDadaVuelta();
	}
	
}
