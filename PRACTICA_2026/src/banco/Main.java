package banco;

import utilidades.Entrada;

public class Main {

    public static void main(String[] args) {

    	
        boolean salir = false;

        do {
            try {
                System.out.println("Introduce un número:");
                int n = Entrada.entero();

                Banco b = new Banco(n);
                int x=b.getNumero();
                System.out.println(x);
                int factorial = b.calcularFactorial();

                System.out.println("Resultado: " + factorial);

                if (factorial > Banco.LIMITE) {
                    System.out.println("Acceso bloqueado");
                } else {
                    System.out.println("Acceso permitido");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("¿Deseas salir? (s/n)");
            String r = Entrada.cadena();
            if (r.equalsIgnoreCase("s")) {
                salir = true;
            }

        } while (!salir);
    }
}

