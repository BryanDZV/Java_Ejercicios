package recorrer;

import utilidades.Entrada;

public class PrimeroYUltimo {

	public static void main(String[] args) {
		/*PATRON BUSQUEDA
		 * Leer 10 números enteros. Debemos mostrarlos en el siguiente orden: el
		 * primero, el último, el segundo, el penúltimo, el tercero, etc.
		 */
		int []arrayNumeros=new int[10];
		for (int i = 0; i < arrayNumeros.length; i++) {
			System.out.println("numero");
			int numero=Entrada.entero();
			arrayNumeros[i]=numero;
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println("numero   "+arrayNumeros[i]);
			System.out.println("numero   "+arrayNumeros[9-i]);
			System.out.println("----");
		}
		
		

	}

}
