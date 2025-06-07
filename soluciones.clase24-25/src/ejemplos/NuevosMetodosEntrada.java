package ejemplos;

import utilidades.Entrada;

public class NuevosMetodosEntrada {

	public static void main(String[] args) {
//		System.out.print("Temperatura:");
//		int grados=Entrada.entero();
		
				int grados = Entrada.entero("Temperatura:","Temperatura incorrecta!!");
				System.out.println("Grados leidos: "+grados);
	}
}
