package repaso;

import java.util.Objects;

public class Persona {
	String nombre;
	String apellido;
	public Persona(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

 @Override
public boolean equals(Object obj) {
	 
	 if(this == obj) 
		 return true;
	 
	 if(obj == null)
		 return false;
	 
	 Persona nuevaPersona = (Persona) obj;
	
	 return Objects.equals(nuevaPersona.apellido, this.apellido);
		 
	 }
}

