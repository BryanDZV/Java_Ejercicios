package conceptosBasicosEjercicios;

public class Ejercicio9_patronConEspacios {

	public static void main(String[] args) {
		/*
		 * Escriba un programa Java para mostrar el 
		 * siguiente patrón. Patrón de ejemplo:
		 * Javva Jaavvaa JJ aaaaa VV aaaaa JJ aa V aa
		 * 
		 */
		String [] array= {"  Javva","  Jaavvaa","JJ aaaaa VV aaaaa"," JJ aa V aa"};
		String  a= "Javva";
		String b="Jaavvaa";
		String c="JJ aaaaa VV aaaaa";
		String d="JJ aa V aa";

		//System.out.println(a+"\n"+b+"\n"+c+"\n"+d);
		
		for (int i = 0; i < array.length; i++) {
			
			System.out.println(array[i]);
			
			
		}
			
		}
		
		


}
