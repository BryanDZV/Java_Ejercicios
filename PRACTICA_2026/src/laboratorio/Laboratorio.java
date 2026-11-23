package laboratorio;

public class Laboratorio {

    private String texto;

    public Laboratorio(String texto) {
        validarCadena(texto);
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        validarCadena(texto);
        this.texto = texto;
    }

    private void validarCadena(String texto) {
        if (texto == null || texto.length() == 0) {
            throw new IllegalArgumentException("No se aceptan cadenas vacías");
        }

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c != 'A' && c != 'T' && c != 'C' && c != 'G') {
                throw new IllegalArgumentException("Cadena genética no válida");
            }
        }
    }

    public int contarCaracteresValidos() {
        return texto.length();
    }

    @Override
    public String toString() {
        return "Secuencia genética: " + texto;
    }
}
