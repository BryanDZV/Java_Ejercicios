package ejemplos;

public class LineaDeComandos {

	public static void main(String[] args) {
		System.out.println("Parámetros recibidos: "+args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}

	}

}
