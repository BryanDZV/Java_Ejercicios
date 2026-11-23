package juego;

import utilidades.Entrada;

public class Juego {

    public static void main(String[] args) {

        boolean salir = false;
        Dado dado = new Dado();

        do {
            System.out.println("1. Lanzar dado");
            System.out.println("2. Calcular puntuación");
            System.out.println("3. Salir");

            int opcion = Entrada.entero();

            switch (opcion) {
                case 1:
                    dado.lanzar();
                    System.out.println(dado);
                    break;

                case 2:
                    System.out.println("Puntuación: " + dado.calcularPuntuacion());
                    break;

                case 3:
                    salir = true;
                    break;
            }

        } while (!salir);
    }
}
