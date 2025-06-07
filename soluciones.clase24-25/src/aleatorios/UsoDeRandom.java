package aleatorios;

import java.util.Random;

public class UsoDeRandom {

	public static void main(String[] args) {

		for (int i = 1; i <= 20; i++) {
			// Número aleatorio entero entre 1 y 6
			int n=tirarDado();
			System.out.print(n+" ");
		}
		System.out.println();
		for (int i = 1; i <= 20; i++) {
			System.out.print(tirarMoneda()+" ");
		}
		System.out.println();
	}
	
	private static String tirarMoneda() {
		Random r=new Random();
		int n = r.nextInt(1,3);//1 ó 2
		if (n==1)
			return "cara";
		else
			return "cruz";
	}
	
	private static int tirarDado() {
		Random r=new Random();
		int n = r.nextInt(1,7);//1..6
		return n;
	}

}
