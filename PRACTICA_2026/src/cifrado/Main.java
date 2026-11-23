package cifrado;

import utilidades.Entrada;

public class Main {

    public static void main(String[] args) {

        boolean salir = false;

        do {
            try {
                System.out.println("Introduce texto:");
                String texto = Entrada.cadena();

                Cifrado c = new Cifrado(texto);

                System.out.println("1. Cifrar");
                System.out.println("2. Descifrar");
                int op = Entrada.entero();

                switch (op) {
                    case 1:
                        System.out.println(c.cifrar());
                        break;
                    case 2:
                        System.out.println(c.descifrar());
                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("¿Salir? (s/n)");
            if (Entrada.cadena().equalsIgnoreCase("s")) {
                salir = true;
            }

        } while (!salir);
    }
}
