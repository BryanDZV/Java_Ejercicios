package forja;

import utilidades.Entrada;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("Introduce número:");
            int n = Entrada.entero();

            Forja f = new Forja(n);

            if (f.esPrimo()) {
                System.out.println("Número aceptado (primo)");
            } else {
                System.out.println("Número no aceptado");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

