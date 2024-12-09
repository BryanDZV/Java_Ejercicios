package ejerciciosObjetos;

import utilidades.Entrada;

public class StringPrimerUltimaLetra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("introduce un texto");

		String texto1 = Entrada.cadena();

		String primeraLetra = texto1.substring(0, 1);
		System.out.println("primera letra " + primeraLetra);

		String ultimaLetra = texto1.substring(texto1.length() - 1);
		System.out.println("ultima letra " + ultimaLetra);

	}

}
