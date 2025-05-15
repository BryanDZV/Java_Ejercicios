package ordenacion;

import java.util.Comparator;

public class OrdenacionPorCodigoVocalConsonante implements Comparator<Articulo> {

	@Override
	public int compare(Articulo o1, Articulo o2) {
		String inicial1=o1.getCodigo().toUpperCase().substring(0, 1);
		String inicial2=o2.getCodigo().toUpperCase().substring(0, 1);
		
		boolean esVocal1=inicial1.matches("[AEIOU]");
		boolean esVocal2=inicial2.matches("[AEIOU]");
		
		if (esVocal1 && esVocal2)  //las 2 son vocales
			return inicial1.compareTo(inicial2);
		if (!esVocal1 && !esVocal2) //las 2 son consonantes
			return inicial1.compareTo(inicial2);
		if (esVocal1 && !esVocal2) 
			return -1;
		if (!esVocal1 && esVocal2) 
			return 1;
		
		return 0; //No es necesario, es para quitar error de compilación
	}

}
