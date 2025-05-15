package examenOrdinaria;

import java.util.Comparator;

public class ordenDescendete implements Comparator< Tramos> {

	@Override
	public int compare(Tramos o1, Tramos o2) {
		int orden=-(o1.getDistancia().compareTo(o2.getDistancia()));
		return orden;
	}

}
