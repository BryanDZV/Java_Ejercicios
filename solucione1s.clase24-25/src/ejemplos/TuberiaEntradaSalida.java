package ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TuberiaEntradaSalida {

	public static void main(String[] args) throws IOException {
		boolean modoSilencioso=false;
		boolean errorSintaxis=false;
		//Admite un parámetro -s (opcional)
		switch (args.length) {
		case 0://Sin parámetros
			break;
		case 1://un parámetros
			if (args[0].equals("-s"))
				modoSilencioso=true;
			else
				errorSintaxis=true; //un argumento pero no es -s
			break;
		default:
			errorSintaxis=true;
		}
		
		if (errorSintaxis) {
			System.err.println("Error de sintaxis\nEjecútame sin parámetros o con el parámetro -s.");
			System.exit(1);
		}
		
		File f=new File(".");
		if (!modoSilencioso)
			System.out.println("Directorio de trabajo: "+f.getAbsolutePath());
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while((linea=bfr.readLine())!=null) {
			System.out.println(linea);
			System.err.println("["+linea+"]");
		}
		bfr.close();
		if (!modoSilencioso)
			System.out.println("Sigo vivo");
	}

}
