package ficheros;

import java.util.Comparator;

public class porOrdenAlfabetico implements Comparator< String> {

	@Override
	public int compare(String o1, String o2) {
		int orden=o1.compareTo(o2);
		
		return orden;
	}

}
