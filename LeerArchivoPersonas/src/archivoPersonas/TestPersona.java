package archivoPersonas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class TestPersona {
	public static void main(String[] args) throws IOException {
		
		LinkedList <Persona> list1=new LinkedList <Persona>();
		LinkedList <Persona> list1ordenada=new LinkedList <Persona>();
		
		list1=LeerPersona.getPersona("personas.in");
		
		
		LeerPersona.getPersonaOrdenado(list1);
		
		System.out.println(LeerPersona.getPersonaOrdenado(list1));
		
	}


}