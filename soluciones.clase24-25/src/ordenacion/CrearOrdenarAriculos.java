package ordenacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrearOrdenarAriculos {

	public static void main(String[] args) {
		List<Articulo> tienda=new ArrayList<Articulo>();
		
		tienda.add(new Articulo("PT1", 5, "Patatas", 1500, Categoria.ALIMENTACION));
		tienda.add(new Articulo("PT2", 16.3, "Patatas", 1000, Categoria.ALIMENTACION));
		tienda.add(new Articulo("CH", 7, "Chirimoyas", 800, Categoria.ALIMENTACION));
		tienda.add(new Articulo("AM", 25, "Alma", 21, Categoria.OTROS));
		tienda.add(new Articulo("BO", 7.5, "Boniato", 1000, Categoria.ALIMENTACION));
		tienda.add(new Articulo("TEC1", 8, "Ratón óptico", 130, Categoria.TECNOLOGIA));
		tienda.add(new Articulo("TEC2", 4, "Alfombrilla", 195, Categoria.TECNOLOGIA));
		tienda.add(new Articulo("TX1", 40, "Pantalón vaquero", 900, Categoria.TEXTIL));
		tienda.add(new Articulo("AG", 300, "Angulas", 500, Categoria.ALIMENTACION));
		tienda.add(new Articulo("OTR1", 5, "Karkamusa", 1500, Categoria.OTROS));
		tienda.add(new Articulo("TX5", 27, "Camisa", 300, Categoria.TEXTIL));
		
		//Mostramos artículos de la lista
		for(Articulo a:tienda)
			System.out.println(a);
		System.out.println("\n=== Orden por Categoría y denominación:Comparable");
		tienda.sort(null);
		for(Articulo a:tienda)
			System.out.println(a);
		System.out.println("\n=== Orden por precio:Comparator");
		tienda.sort(new OrdenacionPorPrecio());
		for(Articulo a:tienda)
			System.out.println(a);
		System.out.println("\n=== Orden por peso (descendente):Comparator");
		tienda.sort(new OrdenacionPorPesoDesc());
		for(Articulo a:tienda)
			System.out.println(a);
		System.out.println("\n=== Orden por denominacion y precio (descendente) :Comparator");
		tienda.sort(new OrdenacionPorDenominacionPrecioDesc());
		for(Articulo a:tienda)
			System.out.println(a);
		System.out.println("\n=== Orden por inicial del código, primero vovales después consonantes: Comparator");
		tienda.sort(new OrdenacionPorCodigoVocalConsonante());
		for(Articulo a:tienda)
			System.out.println(a);
	}

}
