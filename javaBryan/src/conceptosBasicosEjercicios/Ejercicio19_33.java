package conceptosBasicosEjercicios;


import java.security.PublicKey;

import utilidades.Entrada;

public class Ejercicio19_33 {
	
	//SUMA DIGITOS DE NUMERO DADO DESDE EL TECLADO

	public static void main(String[] args) {
		System.out.println("INTRDUCE UN NUMERO");
		int numero=Entrada.entero();
		
		int valorDigitosSumados=FuncionesConceptos.valorCaracter(numero);
		
		System.out.println("suma de digitos igual a ;"+ valorDigitosSumados);
		
		System.out.println("pon numero");
		
		int b=Entrada.entero();
		int sumas=0;
		
		while (b!=0) {
			
			//para ir sumando digitos
			
			int n=b%10;//el modulo me da el ultimo digito
			
			sumas=sumas+n;//añado el ultimo digito a contador
			b=b/10;//como es int al hacer division elimina el decimal
			
			
			//proceso repetido con el nuevo b
		}
		
		System.out.println("suma de digitos igual a ;"+ sumas);
		
	}
	
	
	

}
