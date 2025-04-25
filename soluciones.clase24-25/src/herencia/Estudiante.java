package herencia;

public class Estudiante extends Persona {
    // Atributo propio
    private String curso;

    // Constructor
    public Estudiante(String nombre, int edad, String curso) {
        super(nombre, edad); // Llama al constructor de Persona
        this.curso = curso;
    }

    // Método propio
    public void estudiar() {
        System.out.println(getNombre() + " está estudiando el curso " + curso);
    }

   @Override
    public void presentarse() {
        System.out.println("Soy el BRO: " + getNombre() + " y tengo mazo de años:" + getEdad());
    }
    
}