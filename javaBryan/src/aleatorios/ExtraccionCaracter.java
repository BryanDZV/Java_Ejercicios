package aleatorios;

import utilidades.Entrada;

public class ExtraccionCaracter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("intrudcir una palabra");
		String pal=Entrada.cadena().toUpperCase();
		char [] arrayChar= new char [pal.length()];
		int cnt=0;
		for (int i = 0; i < pal.length(); i++) {
			//System.out.print(pal.charAt(i));
			arrayChar[cnt]=pal.charAt(i);
			cnt++;
		
		}
		
	for (char c : arrayChar) {
		System.out.println("soy array"+c);
	}
		
		
	}

}
