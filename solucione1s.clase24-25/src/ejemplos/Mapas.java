package ejemplos;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Mapas {

	public static void main(String[] args) {
		Map<Integer,String> m=new HashMap<Integer, String>();
		m.put(5, "Rosa");//Añade 1 fila
		m.put(7, "Marrón");//Añade 1 fila
		m.put(31, "Lila");//Añade 1 fila
		m.put(7, "Brown");//Actualiza el valor asociado a la clave 7
		m.put(-11, "Rosa");
		System.out.println("En el mapa hay "+m.size()+" filas");
		
		String color=m.get(31);//valor asociado a una clave
		System.out.println(color);
		System.out.println(m.containsKey(31));
		color=m.get(55);//valor asociado a una clave que no existe
		System.out.println(color);
		System.out.println(m.containsKey(55));
		
		System.out.println("Lila? "+m.containsValue("Lila"));
		System.out.println("Naranja? "+m.containsValue("Naranja"));
		
		//Extraer conjunto de claves
		Set<Integer> claves=m.keySet();
		System.out.println(claves);
		for(Integer cl:claves) {
			System.out.println(cl);
		}
		//Extraer lista de valores
		Collection<String> valores=m.values();
		System.out.println(valores);
		for(String s:valores) {
			System.out.println(s);
		}
		
		//recorrido por todos los elementos del mapa
		for(Integer cl:m.keySet()) {
			System.out.print("Clave:"+cl+" ");
			System.out.println("Valor:"+m.get(cl));
		}
		
		

	}

}
