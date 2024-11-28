package ejercicios;

import utilidades.Entrada;

public class Ejercicio1 {

	public static void main(String[] args) {
		boolean correcto;
		int numero;
		
		
		do {
			System.out.print("Introduzca un número positivo: ");
			numero=Entrada.entero();
			correcto=numero>0;
			if (!correcto)
				System.out.println("Introduzca un número mayor que 0");
		} while (!correcto);
		
		if (esArmstrong(numero))
			System.out.println("SÍ es un número de Armstrong");
		else
			System.out.println("NO es un número de Armstrong");
		
		//Mostramos números Armstrong entre 100 y 999
		System.out.println("=== Números Armstrong de 3 dígitos ===");
		for (int i = 100; i <= 999; i++) {
			if (esArmstrong(i))
				System.out.println(i);
		}

	}

	private static boolean esArmstrong(int n) {
		int [] dig=partirDigitos(n);
		int suma=0;
		for (int i = 0; i < dig.length; i++) {
			suma=suma+(int)Math.pow(dig[i],dig.length);
		}
		return suma==n;
	}


	public static boolean esNumValido(int n) {
		return n>=100 && n<=999;
	}
	
	public static int[] partirDigitos(int n)
	{
		//Transforma negativo en positivo
		if (n<0)
			n=-n;
		int digitos[]=new int[numeroDigitos(n)];
		int cnt=0; //Cuenta el numero de divisiones que podemos hacer hasta obtener un cociente 0
		int cociente=n;
		do {
			int digito = cociente%10;//Obtiene cada dígito, el resto de cada division
			cociente=cociente/10;
			cnt++;
			digitos[digitos.length-cnt]=digito;
		} while (cociente!=0);
		
		return digitos;
	}
	
	//Nos devuelve el numero de digitos de un numero entero n
	public static int numeroDigitos(int n)
	{
		int cnt=0; //Cuenta el numero de divisiones que podemos hacer hasta obtener un cociente 0
		int cociente=n;
		do {
			cociente=cociente/10;
			cnt++;
		} while (cociente!=0);
		
		return cnt;
	}
}
