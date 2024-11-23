package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio18_sumarDigitos {

	public static void main(String[] args) {
		
		//SUMAR DIGITOS
		
		//System.out.println("INTRDUCE UN NUMEOR DE 2 CIFRAS O MAS PARA SUMAR SUS DIGITOS");
		
		int num=25;
		int suma=0;
		//CONVIERTO EN STRING CON MI FUNCION
		String numString=FuncionesConceptos.charaToString(num);
		
				//lectura del string por indice
		for (int i = 0; i < numString.length(); i++) {
			
			//VALOR DE CARACTER
			int valorCaracter=Character.getNumericValue(numString.charAt(i));
			
			//System.out.println("soy Valor---"+valorCaracter+"----"+ "en posicion"+i);
			//SUMO SUS VALOR O DIGITOS
			
			//System.out.println("suma de los digitos igual a----"+suma);
				
			

			
				
		}
		
		
		
		
		
	
	
	
	
	}
}
