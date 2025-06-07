package aleatorios;

public class ConvertirCharString {

	public static String sustituirCaracter(String texto, char origen, char destino){
		String nuevo="";
		
		for (int i = 0; i < texto.length(); i++) {
			char c=texto.charAt(i);
			
			if (c==origen) {
				nuevo=nuevo+destino;
				
			}else {
				nuevo=nuevo+c;
				
			}
			
		}
		
		
		return nuevo; 
		
		
	}

}
