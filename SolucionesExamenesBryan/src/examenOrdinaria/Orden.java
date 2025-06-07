package examenOrdinaria;

import java.util.Comparator;
import java.util.Map;

public class Orden implements Comparator< String> {
private final Map<String, Integer>depTotalVentas;

	public Orden(Map<String, Integer> depTotalVentas) {
		this.depTotalVentas=depTotalVentas;
	}

	@Override
	public int compare(String o1, String o2) {
		int orden=-(depTotalVentas.get(o1)-depTotalVentas.get(o2));
		return orden;
	}

}
