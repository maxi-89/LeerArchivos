

package archivoPersonas;

import java.io.File;

public class Persona implements Comparable <Persona>{
	
	private int   edad;
	private Integer dni;
	private String apellido;
	
	
	

	
	public Persona(Integer dni,String apellido , int edad) {
		super();
		this.edad = edad;
		this.dni = dni;
		this.apellido = apellido;
	}

	
	@Override
	public int compareTo(Persona otraPersona) {
		
		return this.dni.compareTo(otraPersona.dni);
	}
	
	
	
	

}
