package cadenasDeTexto;

public class Caracteres {

	public static void main(String[] args) {
		String t="Devaganari aw:\u0975 Rey negro:\u265b";
		System.out.println(t);
		
		for (char c = 'A'; c <= 'Z'; c++) {
		    System.out.print(c + " ");  // Imprime: A B C ... Z
		}
		
		char c='8';
		if (c>='A' && c<='Z')
			System.out.println(c+" es una mayúscula");
	}

	
}
