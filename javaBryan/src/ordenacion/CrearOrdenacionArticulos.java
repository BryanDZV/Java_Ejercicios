package ordenacion;

import java.util.ArrayList;
import java.util.List;

public class CrearOrdenacionArticulos {

	public static void main(String[] args) {
		List<Articulo> tienda = new ArrayList<Articulo>();

		tienda.add(new Articulo("PT", 5, "Patatas", 1500, Categoria.ALIMENTACION));
		tienda.add(new Articulo("CH", 7, "Chirimoyas", 800, Categoria.ALIMENTACION));
		tienda.add(new Articulo("AM", 25, "Alma", 21, Categoria.OTROS));
		tienda.add(new Articulo("BO", 7.5, "Boniato", 1000, Categoria.ALIMENTACION));
		tienda.add(new Articulo("TEC1", 8, "Ratón óptico", 130, Categoria.TECNOLOGIA));
		tienda.add(new Articulo("TEC2", 4, "Alfombrilla", 195, Categoria.TECNOLOGIA));
		tienda.add(new Articulo("TX1", 40, "Pantalón vaquero", 900, Categoria.TEXTIL));
		tienda.add(new Articulo("AG", 300, "Angulas", 500, Categoria.ALIMENTACION));
		tienda.add(new Articulo("OTR1", 5, "Karkamusa", 1500, Categoria.OTROS));
		tienda.add(new Articulo("TX5", 27, "Camisa", 300, Categoria.TEXTIL));

		// primera ordenacion
		tienda.sort(null);// busca comparable en la clase

		for (Articulo a : tienda) {
			/** ordenacion con comparable */
			System.out.println(a);
			System.out.println("\n------ordenacion por cagetoria y comparable");

		}
		/**
		 * CRITERIOS ADICIONALES INVENTAMOS UN CLASE QUE TENGA COMPARATOR
		 * ordenacion por comparator no debe estar a null creas instacnias una clase q
		 * debes crear que tendra dentro un comparator
		 * 
		 */
		for (Articulo a : tienda) {
			System.out.println("-----\n ORDEN POR PRECIO: COMPARATOR CRITERIOS ADICONALES");
			System.out.println(a);
			tienda.sort(new OrdenacionPorPrecio());//criterio adicional
		
		}
		
		for (Articulo a : tienda) {
			System.out.println("-----\n ORDEN POR PESO: DESCENDENTE :COMPARATOR OTRO CRITERIO ADICONAL");
			tienda.sort(new OrdenacionPorPesoDesc());//criterio adicional
		}

	}

	/**
	 * ORDENAR POR DENOMINACION Y POR PRECIO DESC
	 * DENTRO DE LA DENOMINACION PRIMERO LOS MAS CAROS Y BAJANDO
	 * 
	 * 
	 * */
}
