package patronAcumulador;

import utilidades.Entrada;

public class ResultadoMasResultado {

	public static void main(String[] args) {
		/*
		 * 3. CalculoIvaFactura Crea un algoritmo que permita calcular el IVA de una
		 * factura. Esto se hará a partir de una base imponible y un porcentaje de IVA
		 * que se pedirán al usuario. Se calculará el IVA a pagar a Hacienda y el
		 * importe total de la factura. También deberá informarse de la forma de pago
		 * del IVA: DIFERIDO (si supera 200) o INMEDIATO en caso contrario.
		 */
		System.out.println("introduce datos");
		boolean salir = true;
		int resultado = 0;
		do {
			System.out.println("iva");
			int iva = Entrada.entero();
			System.out.println("base");
			int base = Entrada.entero();

			if (iva > 0 && base > 0) {
				resultado = iva + base;

				salir = false;
			} else {
				System.out.println("solo positivos");
				salir = true;
			}

		} while (salir);
		
System.out.println("resultado total="+resultado);
	}
}
