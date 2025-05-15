package aleatorios;
import java.util.Random;
public class UsoRandom {

	public static void main(String[] args) {
	
		//LLMANDO ALEATORIO
		
		for (int i = 0; i < 20; i++) {
		//Número aleatorio intervalo no incluido el limite derecho
		
		
		int n=tirarDado();
		
		System.out.println(n);
	
			
		}
		
		//LAMANDO ALEATORIO CON MONEDA
		int n=tirarMoneda();
		
		System.out.println(n);
		
	}

	private static int tirarMoneda() {
		//dos opciones
		Random r=new Random();
		int n=r.nextInt(1,3);
		return n;
	}

	//FUNCION ALEATORIA RANDOM
	private static int tirarDado() {
		// 5 opciones
		Random r=new Random();
		int n=r.nextInt(1,6);
		return n;
	}
	
	

}
