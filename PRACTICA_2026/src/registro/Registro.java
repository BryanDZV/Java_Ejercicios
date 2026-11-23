package registro;

public class Registro {

    private String idCifrado;
    private String nombre;
    private int edad;

    public static final int DESPLAZAMIENTO = 4;

    public Registro(String id, String nombre, int edad) {
        validarDatos(id, nombre, edad);
        this.idCifrado = cifrar(id);
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getId() {
        return descifrar(idCifrado);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setId(String id) {
        validarTexto(id);
        this.idCifrado = cifrar(id);
    }

    public void setNombre(String nombre) {
        validarTexto(nombre);
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Edad no válida");
        }
        this.edad = edad;
    }

    private String cifrar(String texto) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            resultado += (char)(c + DESPLAZAMIENTO);
        }
        return resultado;
    }

    private String descifrar(String texto) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            resultado += (char)(c - DESPLAZAMIENTO);
        }
        return resultado;
    }

    private void validarDatos(String id, String nombre, int edad) {
        validarTexto(id);
        validarTexto(nombre);
        if (edad < 0) {
            throw new IllegalArgumentException("Edad no válida");
        }
    }

    private void validarTexto(String texto) {
        if (texto == null || texto.isEmpty()) {
            throw new IllegalArgumentException("No se permiten textos vacíos");
        }
    }

    @Override
    public String toString() {
        return "Registro [id=" + getId() + ", nombre=" + nombre + ", edad=" + edad + "]";
    }
}
