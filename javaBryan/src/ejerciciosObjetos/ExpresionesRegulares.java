package ejerciciosObjetos;

import conceptosBasicosEjercicios.FuncionesConceptos;
import utilidades.Entrada;

public class ExpresionesRegulares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("introduzca un numero");
		String texto1 = Entrada.cadena();

		if (FuncionesConceptos.esDigitoExpresionRegular(texto1)) {
			System.out.println("si es un digito");

		} else {
			System.out.println("no es digito");

		}
	}
	
	
	
	



}
