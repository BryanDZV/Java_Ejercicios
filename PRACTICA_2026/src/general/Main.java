package general;

import utilidades.Entrada;

public class Main {

	public static void main(String[] args) {
		boolean salir = false;
		General g = new General(2);
		do {
			try {
				System.out.println("1.Guardar Mensaje");
				System.out.println("2.Ver Mensaje");
				System.out.println("3.salir");
				int accion = Entrada.entero();
				switch (accion) {
				case 1:
					System.out.println("pon tu mensaje");
					String mensaje = Entrada.cadena();
					g.guardarMensaje(mensaje);
					System.out.println("guardado");
					break;
				case 2:
					System.out.println("1.ver Cifrado");
					System.out.println("2.ver desifrado");
					System.out.println("3.salir");
					int accionX = Entrada.entero();
					switch (accionX) {
					case 1:
						String[] array = g.getMensajes();
						for (int i = 0; i < array.length; i++) {
							System.out.println("mensajes--" + array[i]);
						}
						System.out.println("eso es todo");
						break;
					case 2:
						String[] arrayV = g.getMensajes();
						for (int i = 0; i < arrayV.length; i++) {
							System.out.println("mensajes--" + g.decifrarMensaje(arrayV[i]));
						}
						System.out.println("eso es todo");
						break;
					case 3:
						salir = true;
					default:
						System.out.println("no es opcion");
						break;
					}

					break;
				case 3:
					salir = true;
					break;

				default:
					System.out.println("no es opcion");

					break;
				}

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}catch(IllegalStateException e){
				System.out.println(e.getMessage());
			}

		} while (!salir);

	}

}
