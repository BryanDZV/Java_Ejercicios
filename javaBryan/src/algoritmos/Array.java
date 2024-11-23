package algoritmos;

import utilidades.Entrada;

public class Array {

	public static void main(String[] args) {
		// "Arrays"

		int[] a = { 1, -2, 0, 9, 15 };

		System.out.println(a.length);
		System.out.println(1);
		System.out.println(2);
		System.out.println(0);
		System.out.println(3);

		String[] z = { "name:{Mundo}" };

		System.out.println(1);

		/// elemento array

		// int n;
		// System.out.println("Elemento del array?");

		// n=Entrada.entero();
		// int[] otro=new int[n];

		// for (int i = 0; i < otro.length; i++) {
		// System.out.println(i);

		// }

		int[] t = { 4, 6, -2, 8, 1 };
		int[] b = new int[5];// a.length con dimension variable a.length

		System.out.print("{");
		for (int i = 0; i < t.length; i++) {

			System.out.print(b[i] = t[i] * 2);// siempre que se quiera recorrer un array con bucles
			if (i == b.length - 1) {
				System.out.print("}");

			} else {
				System.out.print(",");

			}

		}
		
		//MOSTRAMOS DE DERECHA A IZAUIERDA JUGAR CON LOS PARAMETROS DEL BUCLE
		
		System.out.print("{");
		
		
		for (int i = t.length-1; i>=0; i--) {
			
			// siempre que se quiera recorrer un array con bucles
			System.out.print(b[i] = t[i] * 2);
			
			if (i == 0) {
				System.out.print("}");

			} else {
				System.out.print(",");

			}

		}
		
		////
//	//int t[] = { 2, 3, 4, 5, 9, 7, 6, 3, 10 };
//
//		
//
//		System.out.println("{");
//		for (int i = 0; i < t.length; i++) {
//			System.out.print(t[i]);
//
//			if (i == t.length - 1) {
//				System.out.println("}");
//
//			} else {
//				System.out.print(",");
//
//			}
//		}
//		
//		

		// System.out.print(b); hascode no te da el array>SOLUCION RECORRERLO CON FOR
	}

}
