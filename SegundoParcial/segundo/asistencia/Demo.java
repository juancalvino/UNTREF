package asistencia;

public class Demo {
	
	
	
public static void main(String[] args) {
	int cantidadAlumnos = 30;
	int cantidadClases = 15;
	int clase;
	int alumno;
	AsistenciaDiaria registro = new AsistenciaDiaria(cantidadAlumnos, cantidadClases);
	
	registro.agregarRegistroDiario(1,  1068219887L); //111111101010111011110111101111
	registro.agregarRegistroDiario(2,  787961693L);  //101110111101110101011101011101
	registro.agregarRegistroDiario(3,  922419055L);  //110110111110101111111101101111
	registro.agregarRegistroDiario(4,  698816943L);  //101001101001110001100110101111
	registro.agregarRegistroDiario(5,  66943903L);   //000011111111010111101110011111
	registro.agregarRegistroDiario(6,  498527598L);  //011101101101101110110101101110
	registro.agregarRegistroDiario(7,  854396630L);  //110010111011010000111011010110
	registro.agregarRegistroDiario(8,  779777246L);  //101110011110100111010011011110
	registro.agregarRegistroDiario(9,  534828399L);  //011111111000001101010101101111
	registro.agregarRegistroDiario(10, 903837280L);  //110101110111110111011001100000
	registro.agregarRegistroDiario(11, 292774891L);  //010001011100110110001111101011
	registro.agregarRegistroDiario(12, 120425717L);  //000111001011011000110011110101
	registro.agregarRegistroDiario(13, 792456146L);  //101111001110111110101111010010
	registro.agregarRegistroDiario(14, 1066069196L); //111111100010101110110011001100
	registro.agregarRegistroDiario(15, 704075974L);  //101001111101110101100011000110	
	
	clase = 1;
	alumno = 4;
	
	System.out.println("Asistencia total en la clase "+clase+" :"+registro.contarAlumnos(clase) );
	System.out.println("El alumno "+alumno+" asistió a "+ registro.cantidadPresentes(alumno)+" clases");
	System.out.println("El alumno "+alumno+" asistió a la clase "+clase+": "+registro.presente(alumno, clase));
	registro.agregarPresente(alumno, clase); //registramos el presente de un alumno
	System.out.println("El alumno "+alumno+" asistió a la clase "+clase+": "+registro.presente(alumno, clase));
	System.out.println("El alumno "+alumno+" asistió a "+ registro.cantidadPresentes(alumno)+" clases");

	int masAusente = -1;
	for (int i = 1; i < cantidadAlumnos; i++) {
		if (registro.cantidadPresentes(i) < registro.cantidadPresentes(i-1)) {
			masAusente = i;
		}
	}
	System.out.println("El alumno " + masAusente + " es el mas ausente");
	
	long bits = registro.getRegistroDiario(7) & registro.getRegistroDiario(11) & registro.getRegistroDiario(13);
	
	System.out.println("Los alumnos que asistenron a las clases 7,11 y 13 fueron los alumnos " ) ;

	long cuenta = (bits & 1);
	for(int i=0; i<cantidadAlumnos; i++) {
		if(cuenta == 1) {
			System.out.print( " " + i);
		}
		bits = bits>>1;
		cuenta = (bits & 1);
	}
	
	}
}
