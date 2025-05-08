package ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utilidades.Entrada;

public class CargarNumerosEnListaDesdeTeclado {

	public static void main(String[] args) {
		
		List<Integer> al= new ArrayList<Integer>();
		int n;
		do {
			System.out.print("Número (-1 para salir):");
			n = Entrada.entero();
			if (n!=-1) {
				al.add(n);
			}
		} while (n!=-1);
		//Contenido de la lista
		System.out.println(al);
		//Recorrer la lista de derecha a izquierda
		for (int i = al.size()-1; i>=0 ; i--) {
			System.out.print(al.get(i)+" ");
		}
		System.out.println();
		//Ordenar la lista
		al.sort(null);
		System.out.println(al);

	}

	
	
}
