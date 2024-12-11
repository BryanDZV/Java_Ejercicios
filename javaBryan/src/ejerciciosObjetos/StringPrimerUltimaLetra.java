package ejerciciosObjetos;

import conceptosBasicosEjercicios.FuncionesConceptos;
import utilidades.Entrada;

public class StringPrimerUltimaLetra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("introduce un texto");

		String texto1 = Entrada.cadena();
		System.out.println("ultima letra  :" + FuncionesConceptos.ultimaLetra(texto1));

		System.out.println("---------------------------------------------------------");
		System.out.println("primer letra  :" + FuncionesConceptos.primeraLetra(texto1));

	}

}
