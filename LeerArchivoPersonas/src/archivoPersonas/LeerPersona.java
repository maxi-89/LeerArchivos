package archivoPersonas;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
Implementar un método estático listarPersonas que reciba por parámetro un objeto 


LinkedList<Persona> y un String (que será el nombre del archivo de salida). 
 Usar este método para generar los archivos “personaOrdenadasPorDni.out” y “personasMayores.out”
  a partir los LinkedList<Persona> obtenidos en los  puntos 2 y 3. Tenga en cuenta que para ésto,
   deberá sobreescribir el método toString de Object para aplanar el objeto Persona a una cadena
    que contiene los colaboradores internos del objeto separado por “;”.

Resolver el problema “Descubriendo nombres repetidos" aplicando Maps.
 La solución implementada debe ser capaz de procesar el archivo “400000nombres.in”. 

En un supermercado se mantiene una cola A con diversos clientes de los que s
e conoce número de ubicación en la cola y cantidad de productos que lleva.
 Se abre una nueva cola B para clientes que llevan menos de 5 productos. 
 Usted debe dejar en la cola A los clientes que llevan más de 5 o hasta 5 
 productos en el orden en que estaban, y en la cola B los que compran menos
  de 5 artículos, respetando el orden que tenían en la cola A. En ambas colas 
  reasignar un nuevo número de ubicación.

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

public static  LinkedList<Persona> getPersonaOrdenadoPorDni(LinkedList<Persona> list) throws IOException {
	
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


public static  LinkedList<Persona> getPersonaOrdenadoPorEdad(LinkedList<Persona> list) throws IOException {
	
	LinkedList <Persona> ordenadasPorEdad=new LinkedList <Persona>();
	Collections.sort(list, new OrdenarPersonasPorEdad());
	

	for(Persona p : list) {
	ordenadasPorEdad.add(p);}
	
	PrintWriter salida=new PrintWriter(new FileWriter("personasOrdenadasPorEdad.out"));
	for(Persona p : ordenadasPorEdad) {
		salida.println(p);
	}
	
	salida.close();
	
	return ordenadasPorEdad;
	
}

public static  LinkedList<Persona> getPersonasMayoresAedad(LinkedList<Persona> list, int edad) throws IOException {
	
	LinkedList <Persona> mayoresAedad=new LinkedList <Persona>();
	
	

	for(Persona p : list) {
		if(p.getEdad()>edad) {
	mayoresAedad.add(p);}}
	
	PrintWriter salida=new PrintWriter(new FileWriter("mayoresAedad.out"));
	for(Persona p : mayoresAedad) {
		salida.println(p);
	}
	
	salida.close();
	
	return mayoresAedad;
	
}

public static void listarPersona(LinkedList<Persona> list, String nombreArchivo) throws IOException{
	//Metodo de escritura en un archivo
	PrintWriter salida=new PrintWriter(new FileWriter(nombreArchivo));
	Iterator<Persona> it1 = list.iterator();

    while (it1.hasNext()){

        Persona tmp = it1.next();
        salida.println(tmp);

    }
	
	salida.close();
	
	
}




}
