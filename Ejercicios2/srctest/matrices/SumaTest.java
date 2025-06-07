package matrices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumaTest {


	@Test
    void testSumarMatrices_Valido() {
        int[][] matriz1 = {
            {1, 2},
            {3, 4}
        };
        int[][] matriz2 = {
            {5, 6},
            {7, 8}
        };
        int[][] esperado = {
            {6, 8},
            {10, 12}
        };

        int[][] resultado = Suma.sumarMatrices(matriz1, matriz2);
        assertArrayEquals(esperado, resultado, "La suma de matrices no es correcta");
    }

    @Test
    void testSumarMatrices_ErrorDimensionesDiferentes() {
        int[][] matriz1 = { {1, 2}, {3, 4} };
        int[][] matriz2 = { {5, 6, 7}, {8, 9, 10} }; // Dimensiones distintas

        Exception excepcion = assertThrows(IllegalArgumentException.class, () -> {
            Suma.sumarMatrices(matriz1, matriz2);
        });

        assertEquals("Error: Para sumar matrices, ambas deben tener el mismo tamaño.", excepcion.getMessage());
    }

    @Test
    void testGenerarMatriz_TamanioCorrecto() {
        int filas = 3, columnas = 4;
        int[][] matriz = Suma.generarMatriz(filas, columnas);
        assertNotNull(matriz);
        assertEquals(filas, matriz.length);
        assertEquals(columnas, matriz[0].length);
    }
}
