

package archivoPersonas;

import java.io.File;

public class Persona implements Comparable <Persona>{
	
	private int  edad;
	private Integer dni;
	private String apellido;

	public Persona(Integer dni,String apellido , int edad) {
		super();
		this.edad = edad;
		this.dni = dni;
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + edad;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (edad != other.edad)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return apellido +"; " + dni +"; "+ edad + "\n";
	}


	@Override
	public int compareTo(Persona otraPersona) {
		
		return this.dni.compareTo(otraPersona.dni);
	}
	
	
	
	

}
