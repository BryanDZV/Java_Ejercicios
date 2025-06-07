package aleatorios;

import java.util.Random;

public class ExtraccionDesdeArray {

	public static void main(String[] args) {
		String[] pal = { "ciruela", "karkamusa", "zolocotrón", "fresa", "árbol", "plato", "geranio" };
		String[] arrayString = new String[5];
		//int cnt=0;
		// Obtener 5 palabras al azar
		Random r = new Random();
		
		for (int i = 0; i < arrayString.length; i++) {
			int aleatorio=r.nextInt(0, pal.length);
			//System.out.println(aleatorio);
			//if() {};
			
			
			arrayString[i]=pal[aleatorio];
			//cnt++;
		}
		
for (String string : arrayString) {
	System.out.println(string);
}
	}

}
