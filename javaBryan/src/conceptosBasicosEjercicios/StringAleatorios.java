package conceptosBasicosEjercicios;

import java.util.Random;

public class StringAleatorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int longitud=7;
		String abecedario="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		
		System.out.println(creado( longitud,abecedario));
		
		

	}

	public static String creado(int parA, String paraB) {
		// TODO Auto-generated method stub
		
		Random numAle=new Random();
		StringBuilder nomAle=new StringBuilder(parA);
		
		
		for (int i = 0; i < parA; i++) {
		  
			int indice = numAle.nextInt(nomAle.length());
			nomAle.append(nomAle.charAt(indice));
		}

		
		
		
		
		return nomAle.toString();
	}

}
