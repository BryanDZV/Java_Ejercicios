package ficherosPractica;

import java.util.Comparator;

public class ordenamientoAparicion implements Comparator<Pareja> {

	@Override
	public int compare(Pareja o1, Pareja o2) {
		int orden=-(o1.getAparicion().compareTo(o2.getAparicion()));
		return orden;
	}

}
