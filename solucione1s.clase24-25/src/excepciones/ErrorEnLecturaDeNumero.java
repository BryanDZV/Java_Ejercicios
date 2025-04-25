package excepciones;

import utilidades.Entrada;

public class ErrorEnLecturaDeNumero {


	public static void main(String[] args) {
		boolean repetir;
		do {
			try {
				System.out.print("Introduzca número:");
				repetir=false;
				int n=Entrada.entero();
				int res=100/n;
				System.out.println("El número leído es:"+n);
				System.out.println("100 dividido entre "+n+" es:"+res);
			} catch (NumberFormatException e) {
				//Manejador
				System.out.println("Número erróneo");
				repetir=true;
			}catch (ArithmeticException e) {
				System.out.println("No se puede dividir por 0");
				repetir=true;
			}
		}while (repetir);
		
		
		System.out.println("Adiós");

	}

}
