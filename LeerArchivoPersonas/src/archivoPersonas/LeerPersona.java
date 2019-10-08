package archivoPersonas;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class LeerPersona {
	
	/**
	 * Actividad Obligatoria para el portafolio 2019 (ambos turnos)
Colecciones - Archivos - Entrada/Salida - Excepciones.

Implementar un método estático getPersonas que reciba el nombre de un archivo “personas.in” y 
devuelva un objeto LinkedList<Persona> con personas que fueron leídas del archivo de texto con
 formato: dni apellido edad (tres campos separados por un espacio en blanco). 
Implementar un método estático getPersonasOrdenadasPorDni que reciba un objeto LinkedList<Persona>
 y devuelva otro objeto LinkedList<Persona> con las personas ordenadas por DNI. Generar el archivo
  “personaOrdenadas.out” con el contenido del resultado obtenido. 
Implementar un método estático getPersonasMayoresAEdad que reciba un objeto LinkedList<Persona> y 
una edad y devuelva otro objeto LinkedList<Persona> con las personas cuyas edades son mayores a esa edad. 
Generar el archivo “personaMayores.out” con el contenido del resultado obtenido. 
Sobreescribir los métodos:
equals de Object para determinar que dos objetos personas son iguales si sus dni´s son iguales.
toString de Object para aplanar el objeto a una cadena que contiene los colaboradores internos 
del objeto separado por “;”.


	 * 
	 * **/
	
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
//habria que cambiar nombre de metodo por getPersonaOrdenadoPorDni
public static  LinkedList<Persona> getPersonaOrdenado(LinkedList<Persona> list) throws IOException {
	
	LinkedList <Persona> ordenadasPorDni=new LinkedList <Persona>();
	Collections.sort(list);
	for(Persona p : list) {
	ordenadasPorDni.add(p);}
	
	PrintWriter salida=new PrintWriter(new FileWriter("personasOrdenadas.out"));
	for(Persona p : ordenadasPorDni) {
		salida.println(p);
	}
	
	salida.close();
	
	return ordenadasPorDni;
	
}

}
