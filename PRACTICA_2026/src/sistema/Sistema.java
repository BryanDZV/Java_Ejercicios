package sistema;

public class Sistema {

    private int numero;
    public static final int VALOR_DEFECTO = 5;

    public Sistema() {
        this.numero = VALOR_DEFECTO;
    }

    public Sistema(int numero) {
        validar(numero);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        validar(numero);
        this.numero = numero;
    }

    // SOBRECARGA
    public int calculoEspecial() {
        return calculoEspecial(numero);
    }

    public int calculoEspecial(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    private void validar(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Solo números positivos");
        }
    }

    @Override
    public String toString() {
        return "Sistema [numero=" + numero + "]";
    }
}

