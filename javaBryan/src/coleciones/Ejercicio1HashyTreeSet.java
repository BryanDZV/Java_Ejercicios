package coleciones;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio1HashyTreeSet {

    public static void main(String[] args) {

        String[] pals = { "Zamora", "Zamora", "burGos", "manzana", "Avila", "Burgos", "Jaén", "zAmOrA" };

        String [] resultado=quitarPalabrasDuplicadas(pals);
        
        
        
       // System.out.println(Arrays.toString(resultado));
        for (String elemento : resultado) {
        	// Imprimir el resultado del HashSet (eliminación de duplicados sin orden)
            //System.out.println("Resultado con HashSet:");
           // System.out.println(elemento);
            
          
			
		}
        
    }

    private static String [] quitarPalabrasDuplicadas(String[] pals) {
        boolean ignorarMayMin = true;  // Si es true, ignoramos mayúsculas/minúsculas
        Set<String> set = new HashSet<String>();
        Set<String> setTree = new TreeSet<String>();
        
        for (String elemento : pals) {
            if (ignorarMayMin) {
                String min = elemento.toLowerCase();  // Convertir a minúsculas si ignoramos mayúsculas/minúsculas
                set.add(min);  // Añadir a HashSet (eliminando duplicados)
                setTree.add(min);  // Añadir a TreeSet (eliminando duplicados y ordenando)
            } else {
                set.add(elemento);  // Añadir a HashSet sin cambiar mayúsculas/minúsculas
                setTree.add(elemento);  // Añadir a TreeSet sin cambiar mayúsculas/minúsculas
            }
            
        }
     // Imprimir el resultado del HashSet (eliminación de duplicados sin orden)
        System.out.println("Resultado con HashSet:");
        System.out.println(set);
        
        System.out.println("*******************************");

        // Imprimir el resultado del TreeSet (eliminación de duplicados y orden)
        System.out.println("Resultado con TreeSet:");
        System.out.println(setTree);
        
        /*  
       
       Si buscas una forma más básica (sin usar toArray()), puedes hacer lo siguiente:
       String[] resultado = new String[set.size()];
		int i = 0;
		for (String palabra : set) {
    	resultado[i] = palabra;
    	i++;
}
return resultado;

       
       */
        return set.toArray(new String[0]);
    }
}
