package ordenacion;

import java.util.Comparator;

public class OrdenacionPorPrecio implements Comparator<Articulo> {

	@Override
	public int compare(Articulo o1, Articulo o2) {
		if (o1.getPvp()<o2.getPvp())
			return -1;
		else {
			if (o1.getPvp()>o2.getPvp())
				return 1;
			else
				return 0;
		}
	}

}
