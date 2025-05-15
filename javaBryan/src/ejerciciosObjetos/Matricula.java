package ejerciciosObjetos;

import conceptosBasicosEjercicios.FuncionesConceptos;
import utilidades.Entrada;

public class Matricula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("introduzca un texto");
		String matricula = Entrada.cadena();

		if (FuncionesConceptos.esMatricula(matricula)) {
			System.out.println("es un matricula internacional");
		} else {
			System.out.println("no es un matricula internacional");
		}
	}

}
