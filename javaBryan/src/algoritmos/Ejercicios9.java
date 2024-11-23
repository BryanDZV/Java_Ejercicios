package algoritmos;

import utilidades.Entrada;

public class Ejercicios9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduzca 10 numero para hacer la media");
		
		//declaro array y tamaño
		int []grupo= new int [10];
		int suma=0;
		//para decimales
		double decimales=0;
		
		//introducir y guardar en array manualmente
		grupo[0]=Entrada.entero();
		grupo[1]=Entrada.entero();
		grupo[2]=Entrada.entero();
		grupo[3]=Entrada.entero();
		grupo[4]=Entrada.entero();
		grupo[5]=Entrada.entero();
		grupo[6]=Entrada.entero();
		grupo[7]=Entrada.entero();
		grupo[8]=Entrada.entero();
		grupo[9]=Entrada.entero();
		
		
		//interar array para hacer media
		for (int i = 0; i < grupo.length; i++) {
			suma=suma +grupo[i];
			decimales=decimales+grupo[i];
			
			
			
		}
		System.out.println("la media truncada es "+suma/grupo.length);
		System.out.println("la media con decimales es "+decimales/grupo.length);
		
	}

}
