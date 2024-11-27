package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio32_42 {

	public static void main(String[] args) {
		//Escriba un programa en Java
		//para ingresar y mostrar su contraseña.

		System.out.println("ingrese una contraseña");
		String texto=Entrada.cadena();
		System.out.println(FuncionesConceptos.mostrarContraseña(texto));
		
		
		
	}

	

}
