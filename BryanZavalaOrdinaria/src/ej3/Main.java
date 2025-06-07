package ej3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		Departamentos dp = new Departamentos();

		Map<String, Integer> mostolesDep = new TreeMap<String, Integer>();
		String ruta="Mostoles";
		File ciudad=new File(ruta);
		BufferedReader bfr = new BufferedReader(new FileReader(ciudad));
		mostolesDep = lecturaArchivo(ciudad);
		//System.out.println("mosto");
		for (String string : mostolesDep.keySet()) {
			//System.out.println(string + "\t" + mostolesDep.get(string));
		}
		bfr.close();
		
		
		
		
		
		//System.out.println("villa");
		Map<String, Integer> villalba = new TreeMap<String, Integer>();
		 ruta="Villalba";
		 ciudad=new File(ruta);
		 bfr = new BufferedReader(new FileReader(ciudad));
		villalba = lecturaArchivo(ciudad);
		for (String string : villalba.keySet()) {
			//System.out.println(string + "\t" + villalba.get(string));
		}
		bfr.close();
		
		//System.out.println("majada");
		Map<String, Integer> majadahonda = new TreeMap<String, Integer>();
		 ruta="Majadahonda";
		 ciudad=new File(ruta);
		 bfr = new BufferedReader(new FileReader(ciudad));
		majadahonda = lecturaArchivo(ciudad);
		for (String string : majadahonda.keySet()) {
			//System.out.println(string + "\t" + majadahonda.get(string));
		}
		
		bfr.close();
		//agregar 
		dp.agregarM1(mostolesDep);
		dp.agregarV1(villalba);
		dp.agregarMj1(majadahonda);
		
		
		//listado
		TreeMap<String, Integer>l=new TreeMap<String, Integer>();
		
		l=dp.listado();
		for (String dep : l.keySet()) {
			System.out.println(dep+"---"+l.get(dep));
		}
		
		

	}// main

	private static Map<String, Integer> lecturaArchivo(File ciudad) throws IOException {
		BufferedReader bfr = new BufferedReader(new FileReader(ciudad));
		String linea = bfr.readLine();
		Map<String, Integer> m = new TreeMap<String, Integer>();
		while (linea != null) {
			// System.out.println(linea);
			String[] tmp = linea.split(";");
			m.put(tmp[0], Integer.parseInt(tmp[1]));
			linea = bfr.readLine();

		}
		return m;
	}

}
