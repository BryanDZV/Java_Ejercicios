package juego;

public class Dado {

    private int valor;
    public static final int LIMITE = 6;

    public Dado() {
        lanzar();
    }

    public void lanzar() {
        valor = (int)(Math.random() * LIMITE) + 1;
        System.out.println((double)valor);
    }

    public int getValor() {
        return valor;
    }

    public int calcularPuntuacion() {
        int potencia = 2; // fija y controlada
        return (int) Math.pow(valor, potencia);
    }

    @Override
    public String toString() {
        return "Dado [valor=" + valor + "]";
    }
}

