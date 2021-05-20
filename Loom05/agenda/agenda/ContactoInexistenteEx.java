package agenda;

public class ContactoInexistenteEx extends Exception {

	public static final long serialVersionUID = 700L;

	public ContactoInexistenteEx(String contacto) {
		super("No se ha encontrado el contacto " + contacto);
	}
}
