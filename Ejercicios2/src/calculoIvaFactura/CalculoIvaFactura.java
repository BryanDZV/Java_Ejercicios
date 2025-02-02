package calculoIvaFactura;

import utilidades.Entrada;

public class CalculoIvaFactura {

	public static void main(String[] args) {
		/* validaciones aqui */

		/*
		 * CalculoIvaFactura Crea un algoritmo que permita calcular el IVA de una
		 * factura. Esto se hará a partir de una base imponible y un porcentaje de IVA
		 * que se pedirán al usuario. Se calculará el IVA a pagar a Hacienda y el
		 * importe total de la factura. También deberá informarse de la forma de pago
		 * del IVA: DIFERIDO (si supera 200) o INMEDIATO en caso contrario.
		 */

		/*
		 * pedir iva y base imponible calcular iva calcular total factura forma de pago
		 * diferio si>200 else imediato
		 */
		System.out.println("Calcula el iva de tu factura");
		System.out.println("introduce el iva");
		double iva = Entrada.entero();
		System.out.println("introduce base imponible");
		double baseImponible = Entrada.entero();

		/* validacion */

		while (iva < 0 || baseImponible < 0) {
			System.out.println("solo numeros positivos");
			System.out.println("introduce el iva");
			iva = Entrada.entero();
			System.out.println("introduce base imponible");
			baseImponible = Entrada.entero();
		}

		/* forma de pago */

		if (CalculoFactura(iva, baseImponible) > 200) {
			System.out.println("forma de pago DIFERIDA");

		} else {
			System.out.println("forma de pago INMEDIATA");

		}

		/* RESPUESTA METODO */

		System.out.println("el total de tu factura es: " + CalculoFactura(iva, baseImponible));

	}

	private static double CalculoFactura(double iva, double baseImponible) {

		/*
		 * total factura=base imponible+iva
		 * 
		 */

		double facturaTotal = baseImponible + (baseImponible*(iva / 100));

		return facturaTotal;
	}

}
