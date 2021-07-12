package asistencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author martin
 *
 */
class AsistenciaDiariaTest {

	private AsistenciaDiaria registro = new AsistenciaDiaria(Long.SIZE - 1, 50);

	/**
	 * Test method for
	 * {@link asistencia.AsistenciaDiaria#AsistenciaDiaria(int, int)}.
	 */
	@Test
	void testAsistenciaDiariaException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new AsistenciaDiaria(125, 200);
		});
		String expectedMessage = "La cantidad máxima de alumnos que se pueden gestionar es: " + (Long.SIZE - 1);
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

	}

	/**
	 * Test method for
	 * {@link asistencia.AsistenciaDiaria#AsistenciaDiaria(int, int)}.
	 */
	@Test
	void testAsistenciaDiaria() {

		for (int i = 1; i <= registro.getCantidadClases(); i++) {
			assertEquals(0, registro.contarAlumnos(i));
		}

	}

	/**
	 * Test method for
	 * {@link asistencia.AsistenciaDiaria#agregarPresente(int, int)}. Agrega
	 * asistencia del alumno en todas las clases y chequea que haya un solo alumno
	 * presente
	 */
	@Test
	void testAgregarPresente() {
		int alumno = 24;
		for (int i = 1; i <= registro.getCantidadClases(); i++) {
			registro.agregarPresente(alumno, i);
		}

		for (int i = 1; i <= registro.getCantidadClases(); i++) {
			assertEquals(1, registro.contarAlumnos(i));
			;
		}
	}

	/**
	 * Test method for {@link asistencia.AsistenciaDiaria#presente(int, int)}.
	 */
	@Test
	void testPresente() {
		int alumno = 24;
		for (int i = 1; i <= registro.getCantidadClases(); i++) {
			registro.agregarPresente(alumno, i);
		}

		for (int i = 1; i <= registro.getCantidadClases(); i++) {
			assertTrue(registro.presente(alumno, i));
		}
	}

	/**
	 * Test method for
	 * {@link asistencia.AsistenciaDiaria#agregarRegistroDiario(int, long)}.
	 */
	@Test
	void testAgregarRegistroDiario() {
		// 111111111111111111111111111111111111111111111111111111111111111
		registro.agregarRegistroDiario(1, 9223372036854775807L);
		assertEquals(registro.contarAlumnos(1), registro.getCantidadAlumnos());
	}

	/**
	 * Test method for {@link asistencia.AsistenciaDiaria#contar(int)}.
	 */
	@Test
	void testContar() {
		// 100111111101111111111111111111111111101000010111111011110110011
		registro.agregarRegistroDiario(1, 5760103923357317043L);

		assertEquals(registro.contarAlumnos(1), 50);
	}

	/**
	 * Agrega asistencia del alumno en todas las clases y chequea que haya un solo
	 * alumno presente, luego elimina de todas las clases la misma asistencia anteriormente agregada.
	 */
	@Test
	void testRemoverPresente() {
		int alumno = 24;
		for (int i = 1; i <= registro.getCantidadClases(); i++) {
			registro.agregarPresente(alumno, i);
		}

		for (int i = 1; i <= registro.getCantidadClases(); i++) {
			assertEquals(1, registro.contarAlumnos(i));
			;
		}

		for (int i = 1; i <= registro.getCantidadClases(); i++) {
			registro.removerPresente(alumno, i);
		}

		for (int i = 1; i <= registro.getCantidadClases(); i++) {
			assertEquals(0, registro.contarAlumnos(i));
			;
		}

	}
	
	@Test
	void testRemoverAlAlumno10UnPresenteEnLaClase2() {
		int alumno = 10;

		registro.agregarPresente(9, 2);
		registro.agregarPresente(alumno, 1);
		registro.agregarPresente(alumno, 2);
		registro.agregarPresente(11, 2);
		
		registro.removerPresente(alumno, 2);
		
		assertFalse(registro.presente(alumno, 2));
		assertTrue(registro.presente(alumno, 1));
		

	}
	
	@Test
	void agregarleAlAlumno12DosPresentesEnDistintasClasesYEliminarleUna() {
		int alumno = 10;

		registro.agregarPresente(alumno, 1);
		registro.agregarPresente(alumno, 2);
		
		registro.removerPresente(alumno, 2);
		
		assertEquals(registro.cantidadPresentes(alumno), 1);

	}

}
