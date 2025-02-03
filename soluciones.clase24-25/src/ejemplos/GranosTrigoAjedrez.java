 package ejemplos;

import utilidades.Entrada;

public class GranosTrigoAjedrez {

	public static void main(String[] args) {
		
		System.out.print("Introduzca número de granos:");
		int granos=Entrada.entero();
		System.out.println("Casillas necesarias: "+numeroDeCasillas(granos));
		
//		for(int casillas=1;casillas<=64;casillas++) {
//			long granos=granosAcumulados(casillas);
//			System.out.println(casillas+"-->"+granos);
//		}

	}

	private static int numeroDeCasillas(long granosSolicitados) {
		if (granosSolicitados<=0)
			throw new RuntimeException("El número de granos debe ser positivo: "+granosSolicitados);
		for (int casilla=1;casilla<=64;casilla++) {
			long granosAcumulados=granosAcumulados(casilla);
			if (granosAcumulados >= granosSolicitados)
				return casilla;
		}
		
		return 0;//Nunca saldrá por aquí, es para quitar error de Eclipse
	}

	private static long granosAcumulados(int casillas) {
		if (casillas<=0)
			throw new RuntimeException("El número de casillas debe ser positivo: "+casillas);
		// Cuanto granos se acumula con este número de casillas
		return (long)(Math.pow(2, casillas)-1);
	}

}
