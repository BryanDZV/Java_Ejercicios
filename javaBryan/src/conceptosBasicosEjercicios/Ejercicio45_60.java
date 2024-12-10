package conceptosBasicosEjercicios;

public class Ejercicio45_60 {

	public static void main(String[] args) {
		/*
		 * Encuentra la penúltima palabra
		 * 
		 * Escriba un programa Java para encontrar la 
		 * penúltima palabra (la penúltima)
		 * de una oración.
		 */
		
		System.out.println("itroduzca un texto");
		String texto="El rápido zorro marrón salta sobre el perro perezoso.";

		penultimaPalbra(texto);
	}

	public static void penultimaPalbra(String texto) {
		// TODO Auto-generated method stub
		
		System.out.println("TAMAÑO DE STRING  :"+(texto.length()-(1)));
		
		for (int i = 0; i <= texto.length(); i++)//iempieza en 0 
		{
			
			
			String penultimoSubtring=texto.substring((texto.length()-(1)),(texto.length()));
		System.out.println(penultimoSubtring);
		
		}
		
		
		
		
		return ;
		
	}

}
