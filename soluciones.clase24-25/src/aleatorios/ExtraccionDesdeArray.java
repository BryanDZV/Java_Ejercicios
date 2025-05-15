package aleatorios;

import java.util.Random;

public class ExtraccionDesdeArray {

	public static void main(String[] args) {
		String [] pal= {"ciruela","karkamusa","zolocotrón","fresa","árbol","plato","geranio"};
		
		//Obtener 5 palabras al azar
		Random r=new Random();
		for (int i = 1; i <=5; i++) {
			int indice=r.nextInt(0, pal.length);
			System.out.println(pal[indice]);
			pal[indice]=null;
		}
		
		
		

	}

}
