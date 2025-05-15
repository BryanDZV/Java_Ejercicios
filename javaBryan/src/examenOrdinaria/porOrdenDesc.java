package examenOrdinaria;

import java.util.Comparator;

public class porOrdenDesc implements Comparator<Alturas> {

	@Override
	public int compare(Alturas o1, Alturas o2) {
		int orden = -(o1.getDistancia() - o2.getDistancia());
		return orden;
	}

}
