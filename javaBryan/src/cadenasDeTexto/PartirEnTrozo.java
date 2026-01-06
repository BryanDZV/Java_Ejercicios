package cadenasDeTexto;

public class PartirEnTrozo {

	public static void main(String[] args) {
		String t="La pera, limonera: está rica";
		
		String [] palabras=t.split("[,:]");
		for (int i = 0; i < palabras.length; i++) {
			System.out.println("["+palabras[i]+"]");
			
		}

	}

}
