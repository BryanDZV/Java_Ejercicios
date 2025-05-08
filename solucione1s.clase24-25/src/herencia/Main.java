package herencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	Persona p=new Persona("Luisa", 28);
        Estudiante est = new Estudiante("Laura", 20, "1º DAW");
        EstudianteDAW1 daw = new EstudianteDAW1("Manuel", 55,"DAW1");
        
        System.out.println(p.getClass());
        System.out.println(est.getClass());
        System.out.println(daw.getClass());
        
        p.presentarse();
        est.presentarse();
        daw.presentarse();
        
        List<Object> l=new ArrayList<Object>();
        l.add(p);
        l.add("Zapato");
        l.add(est);
        l.add(daw);
        
        for (Object o : l) {
			System.out.println(o);
		}
    }
}
