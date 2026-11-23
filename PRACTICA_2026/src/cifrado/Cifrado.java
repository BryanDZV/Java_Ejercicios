package cifrado;

public class Cifrado {

    private String texto;
    public static final int DESPLAZAMIENTO = 2;

    public Cifrado(String texto) {
        if (texto == null || texto.length() == 0) {
            throw new IllegalArgumentException("Texto no válido");
        }
        this.texto = texto.toUpperCase();
    }

    public String cifrar() {
        String resultado = "";

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c += DESPLAZAMIENTO;
                if (c > 'Z') {
                    c -= 26;
                }
            }
            resultado += c;
        }
        return resultado;
    }

    public String descifrar() {
        String resultado = "";

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c -= DESPLAZAMIENTO;
                if (c < 'A') {
                    c += 26;
                }
            }
            resultado += c;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Texto original: " + texto;
    }
}

