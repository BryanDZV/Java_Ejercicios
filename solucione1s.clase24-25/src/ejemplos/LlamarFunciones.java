package ejemplos;

import java.util.Arrays;

import utilidades.Entrada;
import utilidades.Func;

public class LlamarFunciones {
	public static void main(String[] args) {
		
		String dniNormalizado=Func.validarDniNie("   Y6787010M    ");
		if (dniNormalizado!=null)
			System.out.println("Documento válido: "+dniNormalizado);
		else
			System.out.println("Documento no válido");
	}

}
