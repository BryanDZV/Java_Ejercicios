package ej2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utilidades.Entrada;

public class VentasDepartamentoPoblacion {
	static Map<String,List<PoblacionImporte>> mapaVentas=new HashMap<String, List<PoblacionImporte>>();

	public static void main(String[] args) throws IOException {
		//Cargamos mapa con el contenido de los tres archivos
		introducirVentasDesdeArchivo("Villalba");
		introducirVentasDesdeArchivo("Majadahonda");
		introducirVentasDesdeArchivo("Mostoles");
		//System.out.println(ventasDep);
		
		//Menú
		String opcion;
		do {
			mostrarMenu();
			opcion=Entrada.cadena().trim();
			switch (opcion) {
			case "1":
				listadoVentasPorDepartamentos();
				break;
			case "2":
				listadoPoblacionesPorDepartamento();
				break;
			case "0":
				break;
			default:
				System.out.println("¡ Opción incorrecta !");
			}
		} while (!opcion.equals("0"));

	}

	private static void listadoPoblacionesPorDepartamento() {
		System.out.print("Departamento? ");
		String dep=Entrada.cadena().trim();
		if (mapaVentas.containsKey(dep)) {
			List<PoblacionImporte> l=mapaVentas.get(dep);
			l.sort(null);
			for (PoblacionImporte pi : l) {
				System.out.printf("%-12s %d\n",pi.getPoblacion(),pi.getImporte());
			}
		}
		else
			System.out.println("No existen ventas para este departamento");
	}

	private static void listadoVentasPorDepartamentos() {
		//Creamos lista de departamento-venta para ordenar
		List<DepartamentoVentas> listaDeps=new ArrayList<DepartamentoVentas>();
		
		for (String dep : mapaVentas.keySet()) {
			int total=0;
			for (PoblacionImporte p : mapaVentas.get(dep)) {
				total = total + p.getImporte();
			}
			listaDeps.add(new DepartamentoVentas(dep, total));
		}
		//Ordenamos de mayor a menor total
		listaDeps.sort(null);
		//Mostramos listado
		for (DepartamentoVentas dv : listaDeps) {
			System.out.printf("%-12s %d\n",dv.getDep(),dv.getTotalVentas());
		}
	}

	private static void introducirVentasDesdeArchivo(String poblacion) throws IOException {
		// Introduce en el mapa de ventas por departamento las ventas que haya en el archivo de esta población
		BufferedReader bfr=new BufferedReader(new FileReader(new File(poblacion)));
		String linea;
		while ((linea=bfr.readLine())!=null) {
			String [] parte=linea.split(";"); //CSV: dep;importe
			String dep=parte[0];
			int importe=Integer.valueOf(parte[1]);
			
			if (!mapaVentas.containsKey(dep)) {
				//añade fila al mapa con una nueva lista vacía
				mapaVentas.put(dep, new ArrayList<PoblacionImporte>());
			}
			//Añade poblacion-importe a la lista asociada al departamento
			mapaVentas.get(dep).add(new PoblacionImporte(poblacion, importe));
			
		}
		
		bfr.close();
	}

	private static void mostrarMenu() {
		System.out.println();
		System.out.println("1-Listado de ventas por departamentos");
		System.out.println("2-Listado de poblaciones por departamento");
		System.out.println("0-Salir del programa");
	}

}
