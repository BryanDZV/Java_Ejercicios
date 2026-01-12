package recorrer;

import utilidades.Entrada;

public class RecorreryMostrar {

    public static void main(String[] args) {

        // 1. Crear array de tamaño 5
        int[] arrayNumeros = new int[5];

        // 2. Leer los números
        for (int i = 0; i < arrayNumeros.length; i++) {
            System.out.println("Numero a guardar:");
            arrayNumeros[i] = Entrada.entero();
        }

        // 3. Mostrar los números en el mismo orden
        int x=1;
        for (int i = arrayNumeros.length-1; i >=0; i--) {
            System.out.println("Numero " + (x++) + ": " + arrayNumeros[i]);
        }
    }
}

