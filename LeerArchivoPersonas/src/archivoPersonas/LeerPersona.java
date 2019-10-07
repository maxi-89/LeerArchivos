package archivoPersonas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class LeerPersona {
	
	
public static LinkedList <Persona> getPersona(String miArchivo) throws FileNotFoundException {
		LinkedList<Persona> list=new LinkedList<Persona>();
		File f=new File(miArchivo);
		Scanner sc = new Scanner(f);
		sc.useLocale(Locale.ENGLISH);
		
	while(sc.hasNext()) {
		
		list.add(new Persona(sc.nextInt(), sc.next(),sc.nextInt()));
	}
		
		sc.close();
		return list;
	}

}
