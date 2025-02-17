package matrices; // Define el paquete en el que se encuentra la clase

import java.util.Random; // Importa la clase Random para generar números aleatorios
import utilidades.Entrada; // Importa la clase Entrada para la entrada de datos

public class Suma {

    public static void main(String[] args) {
        // Solicita al usuario el número de filas y columnas para la primera matriz
        System.out.println("número de filas");
        int fila = Entrada.entero();
        System.out.println("número de columnas");
        int columna = Entrada.entero();
        
        // Solicita al usuario el número de filas y columnas para la segunda matriz
        System.out.println("ahora la otra matriz");
        System.out.println("número de filas");
        int fila2 = Entrada.entero();
        System.out.println("número de columnas");
        int columna2 = Entrada.entero();

        // Verifica que ambas matrices tengan el mismo tamaño para poder sumarlas
        if (fila != fila2 || columna != columna2) {
            System.out.println("Error: Para sumar matrices, ambas deben tener el mismo tamaño.");
            return; // Sale del programa si las dimensiones no coinciden
        }

        // Genera dos matrices aleatorias con las dimensiones dadas
        int[][] matriz1 = generarMatriz(fila, columna);
        int[][] matriz2 = generarMatriz(fila2, columna2);

        // Suma las dos matrices y guarda el resultado en otra matriz
        int[][] suma = sumarMatrices(matriz1, matriz2);

        // Muestra las matrices generadas y el resultado de la suma
        System.out.println("Matriz 1: ");
        imprimirMatriz(matriz1);

        System.out.println("Matriz 2:");
        imprimirMatriz(matriz2);
        
        System.out.println("Matriz Suma:");
        imprimirMatriz(suma);
    }

    /**
     * Genera una matriz de tamaño filas x columnas con números aleatorios entre 1 y 10.
     * @param filas Número de filas de la matriz.
     * @param columnas Número de columnas de la matriz.
     * @return Matriz generada con valores aleatorios.
     */
    public static int[][] generarMatriz(int filas, int columnas) {
        Random random = new Random(); // Objeto para generar números aleatorios
        int[][] matriz = new int[filas][columnas]; // Declara una matriz con el tamaño dado

        // Recorre la matriz y asigna un número aleatorio entre 1 y 10 a cada posición
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(10) + 1; // Genera números entre 1 y 10
            }
        }
        return matriz; // Devuelve la matriz generada
    }

    /**
     * Suma dos matrices del mismo tamaño.
     * @param matriz1 Primera matriz.
     * @param matriz2 Segunda matriz.
     * @return Matriz resultante de la suma.
     * @throws IllegalArgumentException Si las matrices no tienen el mismo tamaño.
     */
    public static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2) {
        // Verifica que ambas matrices tengan el mismo tamaño
        if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
            throw new IllegalArgumentException("Error: Para sumar matrices, ambas deben tener el mismo tamaño.");
        }

        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        int[][] suma = new int[filas][columnas]; // Declara la matriz de resultado

        // Recorre ambas matrices y suma los valores correspondientes
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                suma[i][j] = matriz1[i][j] + matriz2[i][j]; // Realiza la suma de cada elemento
            }
        }
        return suma; // Devuelve la matriz suma
    }

    /**
     * Imprime una matriz en formato tabular.
     * @param matriz Matriz a imprimir.
     */
    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) { // Recorre cada fila de la matriz
            for (int valor : fila) { // Recorre cada elemento de la fila
                System.out.print(valor + "\t"); // Imprime el valor con un tabulador
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }
}
