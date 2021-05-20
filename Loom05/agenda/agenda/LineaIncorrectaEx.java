package agenda;

public class LineaIncorrectaEx extends Exception {
	public static final long serialVersionUID = 701L;

	public LineaIncorrectaEx(String faltante) {
		super(faltante);
	}
}
