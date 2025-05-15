package ficheros;

import java.util.Comparator;

public class porAparicion implements Comparator<Palabras> {

	@Override
	public int compare(Palabras o1, Palabras o2) {
		int orden=-(o1.getApariciones()-o2.getApariciones());
		return orden;
	}

}
