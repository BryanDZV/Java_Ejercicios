package modeloExamenOrdinariaJDBC;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class PrimosLocica {

    public static void main(String[] args) {
        boolean salir = false;
        List<Integer> l = new ArrayList<Integer>();
        while (!salir) {
            System.out.println("primos en un rango");
            System.out.println("introduce dos números para rango");
            System.out.print  ("número 1: ");
            String dato1 = Entrada.cadena();
            System.out.print  ("número 2: ");
            String dato2 = Entrada.cadena();

            // — corrección: usar OR para detectar cualquiera no numérico
            if (!dato1.matches("[0-9]+") || !dato2.matches("[0-9]+")) {
                System.out.println("solo números");
            } else {
                int num1 = Integer.parseInt(dato1);
                int num2 = Integer.parseInt(dato2);
                // — corrección: num1 ≥ 0 y num2 > num1
                if (num1 < 0 || num2 <= num1) {
                    System.out.println("número 2 debe ser mayor que número 1 y ambos ≥ 0");
                } else {
                    l = primosRango(num1, num2);
                }
            }

            // — corrección: imprimir el tamaño en lugar de solo llamarlo
            System.out.println("total de primos: " + l.size());
            System.out.println("los números primos son:");
            for (Integer integer : l) {
                System.out.println(integer + "::");
            }

            // (Aquí podrías añadir lógica para cambiar 'salir' a true si lo deseas)
        }
    }

    private static List<Integer> primosRango(int num1, int num2) {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = num1; i < num2; i++) {
            if (esPrimo(i)) {
                l.add(i);
            }
        }
        return l;
    }

    public static boolean esPrimo(int n) {
        // — corrección: tratar 0 y 1 como no primos
        if (n <= 1) {
            return false;
        }
        // probar divisores de 2 a √n
        int limite = (int) Math.sqrt(n);
        for (int divisor = 2; divisor <= limite; divisor++) {
            if (n % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
