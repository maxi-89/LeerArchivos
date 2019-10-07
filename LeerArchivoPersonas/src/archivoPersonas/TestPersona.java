package archivoPersonas;

import java.io.FileNotFoundException;
import java.nio.file.*;
import java.util.*;

public class TestPersona {
	public static void main(String[] args) throws FileNotFoundException {
		LeerPersona.getPersona("personas.in");
	}


}