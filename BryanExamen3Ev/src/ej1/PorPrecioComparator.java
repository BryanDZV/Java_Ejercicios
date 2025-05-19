package ej1;

import java.util.Comparator;

public class PorPrecioComparator implements Comparator< Producto> {

	@Override
	public int compare(Producto o1, Producto o2) {
		return Double.compare(o1.getPrecio(), o2.getPrecio());
		
	}

}
