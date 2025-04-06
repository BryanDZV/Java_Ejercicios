package herencia;

public class Main {
    public static void main(String[] args) {
        Estudiante est = new Estudiante("Laura", 20, "1º DAW");
        Persona p=new Persona("Pepe",99);

        est.presentarse();
        est.estudiar();
    }
}
