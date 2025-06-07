package colecionesTipoExamenOrdinaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetListMain {

	public static void main(String[] args) {
		Set<Producto> p = new TreeSet<>();

		p.add(new Producto("P001", "Portátil", 999.99));
		p.add(new Producto("P002", "Teléfono", 599.50));
		p.add(new Producto("P003", "Monitor", 199.00));
		p.add(new Producto("P004", "Teclado", 49.90));
		p.add(new Producto("P005", "Ratón", 19.99));
		p.add(new Producto("P006", "Tablet", 329.00));
		p.add(new Producto("P007", "Auriculares", 89.95));
		p.add(new Producto("P008", "Altavoz", 75.00));
		p.add(new Producto("P009", "Cámara", 450.00));
		p.add(new Producto("P010", "Disco Duro", 120.00));
		p.add(new Producto("P010", "tu duro", 180.25));
		p.add(new Producto("P011", "Disco Duro", 121.00));
		
		List<Producto>l=new ArrayList<Producto>(p);
		
		for (Producto e : l) {
			System.out.println(e);
		}

	}// main

}// clase
