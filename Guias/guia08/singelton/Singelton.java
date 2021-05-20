package singelton;

public class Singelton {

	private static Singelton singelton;
	private int numero;
	
	private Singelton() {
	}

	public static Singelton getSingelton() {
	
		if(singelton == null)
			singelton = new Singelton();
		
		return singelton;
	}
	
	public int sumarUno() {
		return ++numero;
	}


}

