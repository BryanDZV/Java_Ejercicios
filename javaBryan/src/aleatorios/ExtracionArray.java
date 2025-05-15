package aleatorios;

import java.util.Random;

public class ExtracionArray {

	public static void main(String[] args) {
		
		String[] pal= {"hola","adios","buenas tardes","buenas noches"};
		
		//obtner 1 palabra del array
		
		Random r=new Random();
		
		int cha=r.nextInt(0,pal.length);
		System.out.println(cha);
		
		//llamar 5 palabras
		
		System.out.println("Comienza Bucle");
		for (int i = 0; i < 5; i++) {
		
			cha=r.nextInt(0,pal.length);
			System.out.println(cha);
			
		}
	
	
	}
}
