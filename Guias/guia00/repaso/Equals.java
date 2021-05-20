package repaso;

public class Equals {

	public static void main(String[] args) {
		Persona uno = new Persona("juan", "calvino");
		Persona dos = new Persona("juan", "calvino");
		

		if(uno.equals(dos)) {
			System.out.print("Son iguales");
		}
		else {System.out.println("No son iguales");}
	}
	
	
}

