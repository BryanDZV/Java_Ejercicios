package mapas;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class mapas {

	public static void main(String[] args) {

		Map<Integer, String> mapa1 = new HashMap<Integer, String>();
		Map<Integer, String> mapa2 = new TreeMap<Integer, String>(mapa1);//copiando

		mapa1.put(5, "Rosa");
		mapa1.put(7, "Marrón");
		mapa1.put(31, "Lila");
		mapa1.put(5, "Pedro");//actualiza no añade porque teine hasMap
		mapa1.put(null, null);//es posible almacenar null
		
		System.out.println("******mapa1****");
		System.out.println(mapa1);

		System.out.println("******recorriendo VALORES con clave en for each**********");
		for (Integer elementoClave : mapa1.keySet()) {	/*extraer conjunto de claves  mapa1.keySet()*/
			System.out.println(mapa1.get(elementoClave));//objeto pra cada clave
			

		}
		System.out.println("tamaño: "+ mapa1.size());
		
		System.out.println("*****MAPA2******");
		for (Integer elementoClave : mapa2.keySet()) {
			System.out.println(mapa2.get(elementoClave));

		}
		
		System.out.println(mapa2.size());
		
		System.out.println("*****EXTRACION DE CLAVES CONJUNTO******");
		/*extraer conjunto de claves*/
		
		Set<Integer>claves=mapa1.keySet();
		System.out.println(claves);//con treeSet saldrain ordenadas por propiedad del tresset
		for (Integer elementoClave : claves) {
			System.out.println(elementoClave);
			
		}
		System.out.println("*****EXTRACION DE Valores LISTA******");
		/*extraer lista de valores es una clase interna hashvalues pero lo tomamos como lista USAMOS COLLECTION*/
		
		Collection<String>valores=mapa1.values();
		System.out.println(valores);//con treeSet saldrain ordenadas por propiedad
		
		for (String elementoValor : valores) {
			System.out.println(elementoValor);
			
		}
		
		System.out.println("*****CONTIENE?¿******");
		
		String color=mapa1.get(31); //valor asociado a la clave 31
		System.out.println(color);
		System.out.println(mapa1.containsKey(31));
		System.out.println("*****/valor asociado a una clave que no existe?¿******");
		color=mapa1.get(55);//valor asociado a una clave que no existe
		System.out.println(color);
		System.out.println(mapa1.containsKey(55));
		System.out.println(mapa1.containsValue("Lila"));//intentan ignrar mayusculas practica
		
		
		
		
		
		
	}///fin main

}
