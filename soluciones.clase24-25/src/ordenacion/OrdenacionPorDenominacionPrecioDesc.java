package ordenacion;

import java.util.Comparator;

public class OrdenacionPorDenominacionPrecioDesc implements Comparator<Articulo> {

	@Override
	public int compare(Articulo o1, Articulo o2) {
		int compDen=o1.getDenominacion().compareTo(o2.getDenominacion());
		if (compDen==0) {//Igual denominación
			if (o1.getPvp()<o2.getPvp())
				return 1;
			else {
				if (o1.getPvp()>o2.getPvp())
					return -1;
				else
					return 0;
			}
		}
		else {
			return compDen;
		}
	}

}
