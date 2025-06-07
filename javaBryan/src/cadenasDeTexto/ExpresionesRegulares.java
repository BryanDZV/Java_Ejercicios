package cadenasDeTexto;

import utilidades.Entrada;

public class ExpresionesRegulares {

	public static void main(String[] args) {
		for(;;) {
			System.out.print("Introduzca texto: ");
			String t=Entrada.cadena();
			t=t.toUpperCase();
			
			if (t.matches("[-]?[0-9]+")) //signo menos opcional
				System.out.println("Es un número entero");
			else
				System.out.println("NO es un número entero");
			
			if (t.matches("\\+[0-9]{1,3}[ -][0-9]{9}")) 
				System.out.println("Es un teléfono internacional");
			else
				System.out.println("NO es un teléfono internacional");
			
			if (t.matches("[0-9]{4}[ -]?[B-DF-HJ-NPR-TV-Z]{3}")) 
				System.out.println("Es una matrícula de coche");
			else
				System.out.println("NO es una matrícula de coche");
			
			
		}

	}

}
