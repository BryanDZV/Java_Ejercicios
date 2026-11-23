package banco;

public class Banco {

    private int numero;
    public static final int LIMITE = 100000;

    public Banco(int numero) {
        if (numero < 0 || numero > 12) {
            throw new IllegalArgumentException("Número no válido");
        }
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public int calcularFactorial() {
        int resultado = 1;
        int aux = this.numero;

        while (aux > 1) {
            resultado *= aux;
            aux--;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Banco [numero=" + numero + "]";
    }
}
