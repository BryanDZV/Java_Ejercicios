package examenOrdinaria;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class MainRutas {

	public static void main(String[] args) {
		System.out.println("introduce calles/fin para salir");
		
		List<String> lsimple = new ArrayList<String>();
		List<Ruta> lCalles = new ArrayList<Ruta>();
		boolean aux = false;
		while (true) {
			String calle = Entrada.cadena();
			if (calle.equalsIgnoreCase("fin")) {
				break;
			}
			lsimple.add(calle);
			System.out.println("introduce calles/fin para salir");
		

		}

		for (int i = 0; i < lsimple.size() - 1; i++) {
			System.out.println("introduce la distancia entre la calle:" + lsimple.get(i) + " y la calle: "
					+ lsimple.get(i + 1) + " ::");
			int distancia = Entrada.entero();
			lCalles.add(new Ruta(lsimple.get(i), lsimple.get(i + 1), distancia));
		}

		lCalles.sort(null);
		for (Ruta ruta : lCalles) {
			System.out.println(ruta);
		}

	}// main

}// clse
