package ficherosPractica;

import java.util.Comparator;

public class letrasAparicion implements Comparator<Pareja> {

	@Override
	public int compare(Pareja o1, Pareja o2) {
		int orden=-(o1.getAparicionLetra().compareTo(o2.getAparicionLetra()));
		return orden;
	}

}
