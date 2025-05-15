package excepciones;

import utilidades.Entrada;

public class ErrorEnLecturaDeNumero2 {


	public static void main(String[] args) {
			int n;
			try {
				System.out.print("Introduzca un número:");
				n = 0;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				n = Entrada.entero();
				System.out.println("El doble es: "+ 2*n);
			} catch (NumberFormatException e) {
				System.out.println("Número erróneo"); //Manejador
			}
			
			
	}

}
