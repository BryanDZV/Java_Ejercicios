package forja;

public class Forja {

    private int numero;

    public Forja(int numero) {
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

    public boolean esPrimo() {
        if (numero <= 1) return false;

        for (int i = 2; i <= numero / 2; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void validar(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Solo números positivos");
        }
    }

    @Override
    public String toString() {
        return "Forja [numero=" + numero + "]";
    }
}

