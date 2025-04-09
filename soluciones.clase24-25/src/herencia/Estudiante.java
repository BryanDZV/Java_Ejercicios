package herencia;

public class Estudiante extends Persona {
	/*upcasting no necesito hacer cast mirar/downcasting necesito cast explicito*/
	/*getClass
	 * instance of los dos para deteerminar que tipos*/
	/*en OBJETOS dowcasting no esta permitida pero puedo castear el upcasting si vale*/
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