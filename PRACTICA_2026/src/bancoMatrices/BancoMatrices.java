package bancoMatrices;

import java.util.Arrays;

public class BancoMatrices {

    public static final int LIMITE = 3;

    private int[] resultados;
    private int indice;

    public BancoMatrices() {
        this.resultados = new int[LIMITE];
        this.indice = 0;
    }

    // Método que recibe un valor y lo guarda
    public void guardarResultado(int valor) {

        if (indice >= LIMITE) {
            throw new IllegalStateException("No quedan intentos");
        }

        resultados[indice] = valor;
        indice++;
    }

    public int[] getResultados() {
        return resultados;
    }

    @Override
    public String toString() {
        return "BancoMatrices " + Arrays.toString(resultados);
    }
}

