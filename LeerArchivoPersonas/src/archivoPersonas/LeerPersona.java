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
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class LeerPersona {
/*@method: obtener personas
 * @param: string miarchivo
 * el metodo recibe una cadena con el nombre de un archivo, lo lee y obtiene la lista de objetos persona en 
 * el orden de dni, apellido, edad y los pone dentro de un linkedlist de tipo persona
 * 
 * */
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

/*@method: obtener persona ordenada por dni
 * @param: Linkedlist de tipo persona
 * el metodo recibe una lista de tipo persona, la lee la ordena y luego las pone en una listaordenadas por dni
 * esta misma lista es usada para generar el archivo, personasordenadas.out
 * 
 * */
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

//metodo que ordena las personas por edad atravez de la clase ordearpersonasporedad que implementa comparator
//recibe linkedlist, la ordena por edad, la pone en una nueva lista y la imprime en un archivo 
//personasordenadasporedad
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

//metodo que recibe una lista y un entero que corresponde a la edad. la recorre y si es mayor a la edad pasada
//por parametro pone al objeto persona en una nueva lista mayores a edad.
//luego imprime la nueva lista en un archivo mayoresaedad.out

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

//metodo listarpersona. el mismo recibe una linkedlist previamente creada y un string con el nombre q
//queremos que tenga el archivo de texto plano de salida.

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

//recibe un archivo y atravez de dos map los recorre busca la cantidad de repetidos solicitada y despues
//los mete en un archivo de salida llamado repetidos.out
public static void descubrirNombresRepetidos(String miArchivo) throws IOException {
	int cantNombres;
	int cantRepetidos;
	Map<String, Integer> nombres = new TreeMap<String, Integer>();
	TreeMap< Integer,String> repetidos = new TreeMap<Integer,String>();

	Scanner sc = new Scanner(new File(miArchivo));
	cantNombres=sc.nextInt();
	cantRepetidos=sc.nextInt();
	for(int i=0;i<cantNombres;i++){
		String nom = sc.next();
		int cantidad=0;
		if(nombres.containsKey(nom)){
			cantidad = nombres.get(nom);
			nombres.put(nom, cantidad+1);	
		}				
		else
			nombres.put(nom, 1);	
		
	}

	sc.close();

	for (Entry<String, Integer> nombre : nombres.entrySet())
		repetidos.put(nombre.getValue(), nombre.getKey());

	PrintWriter s = new PrintWriter(new FileWriter("repetidos.out")); 

	for(int k=1; k<=cantRepetidos;k++){
		Entry<Integer,String> salida=repetidos.pollLastEntry();
		s.println(salida.getValue()+" "+salida.getKey());
	}
	s.close();
	
}}




