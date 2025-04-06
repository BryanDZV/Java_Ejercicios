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

    // Sobrescribir método presentarse
    @Override
    public void presentarse() {
        super.presentarse(); // Llama al método de la clase padre
        System.out.println("Y soy estudiante del curso: " + curso);
    }
}
