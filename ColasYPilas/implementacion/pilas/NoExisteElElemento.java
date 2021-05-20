
package pilas;

public class NoExisteElElemento extends RuntimeException {

	private static final long serialVersionUID = 4352895925476767226L;

	public NoExisteElElemento() {

		super("No se puede hacer la operación porque no existe el elemento");
	}
}