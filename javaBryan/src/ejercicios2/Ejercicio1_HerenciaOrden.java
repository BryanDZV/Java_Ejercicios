package ejercicios2;

import java.util.*;

class Persona implements Comparable<Persona> {
    protected String nombre;
    protected int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public int compareTo(Persona otra) {
        return Integer.compare(this.edad, otra.edad);
    }

    public String toString() {
        return nombre + " - " + edad + " años";
    }
}

class Estudiante extends Persona {
    private String curso;

    public Estudiante(String nombre, int edad, String curso) {
        super(nombre, edad);
        this.curso = curso;
    }

    public String toString() {
        return super.toString() + " - Curso: " + curso;
    }
}

public class Ejercicio1_HerenciaOrden {
    public static void main(String[] args) {
        List<Estudiante> lista = new ArrayList<>();
        lista.add(new Estudiante("Laura", 20, "1º DAW"));
        lista.add(new Estudiante("Carlos", 18, "2º DAW"));
        lista.add(new Estudiante("Ana", 22, "1º DAM"));

        Collections.sort(lista);

        for (Estudiante est : lista) {
            System.out.println(est);
        }
    }
}