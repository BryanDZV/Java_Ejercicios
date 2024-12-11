package ejerciciosObjetos;

import utilidades.Entrada;

public class ExpresionesRegulares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("introduzca un numero");
		String texto1 = Entrada.cadena();

		if (esDigito(texto1)) {
			System.out.println("si es un digito");

		} else {
			System.out.println("no es digito");

		}
	}
	
	
	
	

	public static boolean esDigito(String texto1) {
		// TODO Auto-generated method stub
		boolean resultado = false;
		for (int i = 0; i < texto1.length(); i++) {
			char caracter = texto1.charAt(i);
			
			

			if (Character.isDigit(caracter) & texto1.matches("[0-9]+") ) {
				resultado = true;

			}else {
				resultado=false;
			}

		}

		return resultado;
	}

}
