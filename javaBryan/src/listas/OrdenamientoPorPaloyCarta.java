package listas;

import java.util.Comparator;

public class OrdenamientoPorPaloyCarta implements Comparator<Ejercicio6Carta>{

	@Override
	public int compare(Ejercicio6Carta o1, Ejercicio6Carta o2) {
		//LOS ENUM INTERFIERENEN EL ORDEN SEGUN COMO ESTAN DEFINIDO SE ORDENA no alfabeticamente sino por su orden en enum 1 2 34 4....
		//PARA ORDENAR SIN MODIFICAR EL ENUM TRABJA EN COMPARETO con -puedes ivertir
		//POR DEFAULT EL ORDEN ES ASC 
		//sino e senum si se ordena alfabeticamente
		int orden=-(o1.getPalo().compareTo(o2.getPalo()));
		if (orden==0) {
			orden=o1.getCarta().compareTo(o2.getCarta());
			
		}
		return orden;
	}
	

}
