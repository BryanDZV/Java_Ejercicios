package ejemplos;

import java.util.Arrays;

import utilidades.Entrada;
import utilidades.Func;

public class LlamarFunciones {
	public static void main(String[] args) {
		
		int [] est=Func.estadisticaLetras("Europeo U18 en 2022 y MVP en el Mundial U19, dejó las cantera del Real Madrid con 16 años para continuar su carrera en Estados Unidos y ahora juega en Australia, desde donde espera dar el salto a la NBA. La perla del basket español se confiesa en una entrevista con MARCA");
		
		System.out.println(Arrays.toString(est));
	}

}
