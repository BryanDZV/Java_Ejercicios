package bancoMatrices;

import utilidades.Entrada;

public class Main {

	public static void main(String[] args) {
		boolean salir = false;
		BancoMatrices b = new BancoMatrices();

		do {

			try {
				System.out.println("1.meter numero");
				System.out.println("2.ver intentos");
				System.out.println("3.salir");
				int accion = Entrada.entero();
				switch (accion) {
				case 1:
					System.out.println("introduce numero");
					int numero = Entrada.entero();

					b.guardarResultado(numero);
					System.out.println("guardado");

					break;
				case 2:

					System.out.println(b.toString());

					break;
				case 3:
					System.out.println("saliendo");
					salir = true;

					break;

				default:
					System.out.println("opcion no valida");
					break;
				}

			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException e) {
				System.out.println("no hay datos aun  ");
			}
		} while (!salir);
	}

}
