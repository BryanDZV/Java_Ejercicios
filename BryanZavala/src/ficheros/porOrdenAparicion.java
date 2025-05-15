package ficheros;

import java.util.Comparator;

public class porOrdenAparicion implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		int orden=-(o1.getAparicion().compareTo(o2.getAparicion()));  
		return orden;
	}

}
