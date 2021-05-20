package agenda;

import org.junit.Test;

public class TestAgendaCargarYMostrarTxt {
	Agenda agendaDemo;

	public void cargar(String txt) {
		agendaDemo = new Agenda();
		agendaDemo.cargarArchivo(txt);
	}

	@Test
	public void TxtConContactosY5LineasEnBlanco() {
		cargar("txtTest/TxtConContactosY5LineasEnBlanco");
	}

	@Test
	public void TreceContactosBienFormateados() {
		cargar("txtTest/TreceContactosBienFormateados");
	}

	@Test
	public void TxtConContactoFormatoNombreEmailApellido() throws ContactoInexistenteEx {
		cargar("txtTest/TxtConContactoFormatoNombreEmailApellido");
		agendaDemo.borrarContacto("lagorio");
	}

	@Test
	public void TxtConContactoFormatoApellidoNombreEmail() throws ContactoInexistenteEx {
		cargar("txtTest/TxtConContactoFormatoApellidoNombreEmail");
		agendaDemo.borrarContacto("lagorio");
	}

	@Test
	public void TxtConContactoFormatoApellidoEmailNombre() throws ContactoInexistenteEx {
		cargar("txtTest/TxtConContactoFormatoApellidoEmailNombre");
		agendaDemo.borrarContacto("albarracin");
	}

	@Test
	public void TxtConContactoFormatoEmailNombreApellido() throws ContactoInexistenteEx {
		cargar("txtTest/TxtConContactoFormatoEmailNombreApellido");
		agendaDemo.borrarContacto("albarracin");

	}

	@Test
	public void TxtConFormatoEmailApellidoNombre() throws ContactoInexistenteEx {
		cargar("txtTest/TxtConFormatoEmailApellidoNombre");
		agendaDemo.borrarContacto("alfonzo");
	}

	@Test
	public void TxtUnContactoNombreDosPuntosVacio() {
		cargar("txtTest/TxtUnContactoNombreDosPuntosVacio");
	}

	@Test
	public void TxtUnContactoApellidoDosPuntosVacio() {
		cargar("txtTest/TxtUnContactoApellidoDosPuntosVacio");
	}

	@Test
	public void TxtUnContactoEmailDosPuntosVacio() {
		cargar("txtTest/TxtUnContactoEmailDosPuntosVacio");
	}

	@Test
	public void TxtUnContactoConFormatoVacioDosPuntosElNombre() {
		cargar("txtTest/TxtUnContactoConFormatoVacioDosPuntosElNombre");
	}

	@Test
	public void TxtUnContactoConFormatoVacioDosPuntosElApellido() {
		cargar("txtTest/TxtUnContactoConFormatoVacioDosPuntosElApellido");
	}

	@Test
	public void TxtUnContactoConFormatoVacioDosPuntosElEmail() {
		cargar("txtTest/TxtUnContactoConFormatoVacioDosPuntosElEmail");
	}

	@Test
	public void TxtUnContactoSinNombre() {
		cargar("txtTest/TxtUnContactoSinNombre");
	}

	@Test
	public void TxtUnContactoSinApellido() {
		cargar("txtTest/TxtUnContactoSinApellido");
	}

	@Test
	public void TxtUnContactoSinEmail() {
		cargar("txtTest/TxtUnContactoSinEmail");
	}

	@Test
	public void TxtUnContactoConDosArrobasEnElEmail() {
		cargar("txtTest/TxtUnContactoConDosArrobasEnElEmail");
	}

	@Test
	public void TxtUnContactoSinArrobaEnElEmail() {
		cargar("txtTest/TxtUnContactoSinArrobaEnElEmail");
	}

	@Test
	public void TxtTresComasSeguidas() {
		cargar("txtTest/TxtTresComasSeguidas");
	}

	@Test
	public void TxtUnContactoConNombreCompuesto() {
		cargar("txtTest/TxtUnContactoConNombreCompuesto");
	}

	@Test
	public void TxtUnContactoConApellidoCompuesto() {
		cargar("txtTest/TxtUnContactoConApellidoCompuesto");
	}

	@Test
	public void TxtUnContactoConNombreApellidoEmailYOficio() {
		cargar("txtTest/TxtUnContactoConNombreApellidoEmailYOficio");
	}

	@Test
	public void TxtUnContactoConNombreApellidoTelefonoEmail() {
		cargar("txtTest/TxtUnContactoConNombreApellidoTelefonoEmail");
	}

	@Test
	public void TxtUnContactoConFormatoIncorrectoAusenciaDeComas() {
		cargar("txtTest/TxtUnContactoConFormatoIncorrectoAusenciaDeComas");
	}

	@Test
	public void TxtUnContactoConFormatoIncorrectoAusenciaDelSeparadorDosPuntos() {
		cargar("txtTest/TxtUnContactoConFormatoIncorrectoAusenciaDelSeparadorDosPuntos");
	}

}
