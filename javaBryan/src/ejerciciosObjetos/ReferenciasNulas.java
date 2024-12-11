package ejerciciosObjetos;

import conceptosBasicosEjercicios.FuncionesConceptos;

public class ReferenciasNulas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String texto1="casa";
		System.out.println(funcionNull(texto1));
		
		System.out.println(funcionNull(null));

	}

	private static String funcionNull(String texto1) {
		// TODO Auto-generated method stub
		
		String nulo=texto1.substring(texto1.length()-1);
		
		return nulo;
	}

}
