package ficheros;

import java.util.Comparator;

public class ordenarPorAparicion implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		int orden=-(o1.getAparicionLetra().compareTo(o2.getAparicionLetra()));
		return orden;
	}

}
