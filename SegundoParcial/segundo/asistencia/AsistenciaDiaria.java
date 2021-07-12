package asistencia;

/**
 * Clase que permite llevar el registro de la asistencia de alumnos a todas las clases
 * planificadas en un curso.
 * Los alumnos se numeran de 0 a cantidadAlumnos -1 y las clases de 1 a cantidadClases
 * 
 * Se utiliza el tipo Long para los mapa de bits de cada día, lo que permite actualmente usar 63 bits
 * ya que se usa el bit 64 para el signo, por lo tanto la cantidad máxima de alumnos que se pueden
 * registrar en un curso es de 63
 * 
 * @author martin
 *
 */

public class AsistenciaDiaria {
	private Long [] asistencia;   //registro de asistencia diaria
	private int cantidadAlumnos; //cantidad de alumnos del curso 
	private int cantidadClases;  //cantidad de clases para las que se lleva asistencia
	
	/**
	 * @post registro de asistencia creado.
	 * @param cantidadAlumnos: cantidad de alumnos que asisten al curso
	 * @param cantidadClases: cantidad de clases en las que se registrará la asistencia de los alumnos
	 */
	public AsistenciaDiaria(int cantidadAlumnos, int cantidadClases) {
		this.cantidadClases = cantidadClases;
		this.asistencia = new Long[cantidadClases];
		if (cantidadAlumnos>Long.SIZE-1) {
			throw new IllegalArgumentException("La cantidad máxima de alumnos que se pueden gestionar es: " + (Long.SIZE-1));
		}
		this.cantidadAlumnos = cantidadAlumnos;
		for(int i=0; i<cantidadClases; i++) {
			asistencia[i] = 0L;
		}
	}
	
	/**
	 * 
	 * @return la cantidad de alumnos en el curso
	 */
	public int getCantidadAlumnos() {
		return cantidadAlumnos;
	}

	/**
	 * 
	 * @return la cantidad de clases del curso
	 */
	public int getCantidadClases() {
		return cantidadClases;
	}
	
	/**
	 * @pre 'alumno' está en el rango [0-cantidadAlumnos-1]
	 * @pre 'clase' está en el rango [1-cantidadClases]
	 * @post registra la asistencia del alumno a un día de clase
	 * @param alumno: número de alumno.
	 * @param clase : número de clase.
	 */
	public void agregarPresente(int alumno, int clase) {
		
		validarClase(clase);
		validarAlumno(alumno);
		
		int bit = (1 << (alumno));
		long asistenciadiaria = asistencia[clase-1];
		asistenciadiaria = (asistenciadiaria | bit);
		asistencia[clase-1] = asistenciadiaria;
	}
	
	/**
	 * @pre 'alumno' está en el rango [0-cantidadAlumnos-1]
	 * @pre 'clase' está en el rango [1-cantidadClases]
	 * @param alumno: número de alumno.
	 * @param clase : número de clase.
	 * @return si el alumno estuvo presente en una clase.
	 */
	public boolean presente(int alumno, int clase) {
		
		validarClase(clase);
		validarAlumno(alumno);
		
		int bit = (1 << (alumno));
		return ((asistencia[clase-1] & bit) != 0);
	}

	/**
	 * @return cantidad de alumnos que asistieron a una clase dada.
	 */
	public int contarAlumnos(int clase) {

		return contar(asistencia[clase-1]);
	}
	
	private int contar(long bits) {
		
		int cuenta = 0;
		if (bits != 0) {
			cuenta = (int) (bits & 1) + contar(bits >> 1);
		} 
		return cuenta;
	}

	/**
	 * @post agrega el registro de asistencia de todos los alumnos a una clase dada
	 * @param clase: número de clase
	 * @param registroDiario: entero que representa la asistencia a una clase dada
	 */
	public void agregarRegistroDiario(int clase, long registroDiario) {
		
		validarClase(clase);
		validarRegistroDiario(registroDiario);
		asistencia[clase-1] = registroDiario;
	}

	/**
	 * 
	 * @param clase: número de clase
	 * @return número entero (long), mapa de bits, que representa los alumnos
	 *  presentes y ausentes en la clase dada
	 */
	public long getRegistroDiario(int clase) {
		validarClase(clase);
		return asistencia[clase-1];
	}

	private void validarClase(int clase) {
		if ((clase < 1) || (clase > cantidadClases)) {
			throw new IllegalArgumentException("No es una clase válida: " + clase);
		}
	}
	
	private void validarAlumno(int alumno) {
		if ((alumno < 0) || (alumno > cantidadAlumnos - 1)) {
			throw new IllegalArgumentException("No es valor de alumno válido: " + alumno);
		}
	}
	
	private void validarRegistroDiario(long registro) {
		if ((registro < 0) || (registro > Math.pow(2, cantidadAlumnos))) {
			throw new IllegalArgumentException("No es un registro válido: " + registro);
		}
		
	}
	
	/**
	 * @pre 'alumno' está en el rango [0-cantidadAlumnos-1]
	 * @param alumno: número de alumno
	 * @return La cantidad de clases en las que estuvo presente el alumno
	 */
	public int cantidadPresentes(int alumno) {
		int bit = 0;
		for(int i = 1; i<=cantidadClases; i++) {
			if (presente(alumno,i)){
				bit = bit | (1<<i);
			}
		}
		return contar(bit);
	}
	
	
	/**
	 * @pre 'alumno' está en el rango [0-cantidadAlumnos-1]
	 * @pre 'clase' está en el rango [1-cantidadClases]
	 * @post remueve la asistencia del alumno a un día de clase
	 * @param alumno: número de alumno.
	 * @param clase : número de clase.
	 */
	
	public void removerPresente(int alumno, int clase) {
		
		validarClase(clase);
		validarAlumno(alumno);
		
		int bit = ~(1 << (alumno));
		
		long asistenciaDiaria = asistencia[clase-1];
		asistenciaDiaria = (asistenciaDiaria & bit);
		asistencia[clase-1] = asistenciaDiaria;
		
	}
}



