package herencia;

public class Persona {
    // Atributos privados
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    //modifica el comportamiento del to sTring (personalizar)
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}

	// Métodos públicos
    public void presentarse() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
