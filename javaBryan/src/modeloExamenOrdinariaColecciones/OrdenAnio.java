package modeloExamenOrdinariaColecciones;

import java.util.Comparator;

public class OrdenAnio implements Comparator< Libro> {

	@Override
	public int compare(Libro o1, Libro o2) {
		int orden=(o1.getAñoPublicacion())-(o2.getAñoPublicacion());
		return orden;
	}
	

}
