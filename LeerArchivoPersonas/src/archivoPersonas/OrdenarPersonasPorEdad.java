package archivoPersonas;

import java.util.Comparator;

public class OrdenarPersonasPorEdad implements Comparator <Persona>{

	@Override
	public int compare(Persona p1, Persona p2) {
		// TODO Auto-generated method stub
		return p2.getEdad()-p1.getEdad();
	}


}
