package ejerciciosObjetos;

import conceptosBasicosEjercicios.FuncionesConceptos;
import utilidades.Entrada;

public class Telefono {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("introduce un telefono");
		String telefono = Entrada.cadena();

		if (FuncionesConceptos.esTelefono(telefono)) {
			System.out.println("es un telefono internacional");
		} else {
			System.out.println("no es un telefono internacional");
		}

	}

}
