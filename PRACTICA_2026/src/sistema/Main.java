package sistema;

import utilidades.Entrada;

public class Main {

    public static void main(String[] args) {

        boolean salir = false;

        do {
            try {
                System.out.println("1. Cálculo con valor por defecto");
                System.out.println("2. Cálculo con valor introducido");
                System.out.println("3. Salir");

                int opcion = Entrada.entero();

                switch (opcion) {
                    case 1:
                        Sistema s1 = new Sistema();
                        System.out.println("Resultado: " + s1.calculoEspecial());
                        break;

                    case 2:
                        System.out.println("Introduce número:");
                        int n = Entrada.entero();
                        Sistema s2 = new Sistema(n);
                        System.out.println("Resultado: " + s2.calculoEspecial());
                        break;

                    case 3:
						salir = true;
                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (!salir);
    }
}
