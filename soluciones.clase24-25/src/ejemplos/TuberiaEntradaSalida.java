package ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TuberiaEntradaSalida {

	public static void main(String[] args) throws IOException {
		boolean modoSilencioso = false;
		if (args.length == 0) {
			System.out.println("Argumentos: "+args.length+"  modo silencioso desactivado");
			modoSilencioso=false;
		} else {
			if (args.length > 1) {
				System.out.println("Argumentos:"+args.length+ "  SOLO EJECUTAR CON 1 PARAMETRO (-s) O CERO PARAMETROS");
				System.exit(0);;
			} else {
				if (args.length == 1) {
					System.out.println("Argumentos: "+args.length+"  modo silencioso activado");
					modoSilencioso = true;

				}
			}
		}

		if (!modoSilencioso) {
			File f = new File(".");
			System.out.println("Directorio de trabajo: " + f.getAbsolutePath());
			BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
			String linea;
			while ((linea = bfr.readLine()) != null) {
				System.out.println(linea);
				System.err.println("[" + linea + "]");
			}
			bfr.close();

			System.out.println("Sigo vivo");

		} else {
			File f = new File(".");
			// System.out.println("Directorio de trabajo: " + f.getAbsolutePath());
			BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
			String linea;
			while ((linea = bfr.readLine()) != null) {
				System.out.println(linea);
				System.err.println("[" + linea + "]");
			}
			bfr.close();

			// System.out.println("Sigo vivo");
		}

	}

}
