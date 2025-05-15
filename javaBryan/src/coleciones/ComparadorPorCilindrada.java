package coleciones;

import java.util.Comparator;

public class ComparadorPorCilindrada implements Comparator< Vehiculo> {

	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {
		/*para aplciar el compareTo o resto o compare mirar los atributos de la calse principal en funciond de eso*/
		int comparador=o1.getCilindrada()-(o2.getCilindrada());
		
		return comparador;
	}

}
