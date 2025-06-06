package ExamenOrdinaria;

import java.util.Comparator;

public class OrdenDesc implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
	//orden 
		int orden=-(o1-o2);
		return orden;
	}

}
