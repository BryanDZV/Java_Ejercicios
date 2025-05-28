package modeloExamenOrdinariaColecciones;

import java.util.List;

public class MainNotas {

    public static void main(String[] args) {
        GestorNotas gestor = new GestorNotas();

        // 1) Añadimos varias notas de distintos alumnos y asignaturas
        gestor.agregarNota(new Nota(1, "Matemáticas", 8.5));
        gestor.agregarNota(new Nota(1, "Física",       7.0));
        gestor.agregarNota(new Nota(2, "Matemáticas", 9.0));
        gestor.agregarNota(new Nota(2, "Literatura",   6.5));
        gestor.agregarNota(new Nota(3, "Historia",     5.0));
        gestor.agregarNota(new Nota(3, "Matemáticas", 6.0));
        gestor.agregarNota(new Nota(1, "Historia",     9.5));

        // 2) Obtener notas por alumno (ordenadas por asignatura)
        System.out.println("--- Notas del alumno 1 (por asignatura) ---");
        List<Nota> notasAlumno1 = gestor.obtenerNotasPorAlumno(1);
        System.out.println(notasAlumno1);

        System.out.println("\n--- Notas del alumno 2 (por asignatura) ---");
        System.out.println(gestor.obtenerNotasPorAlumno(2));

        // 3) Obtener lista de IDs de alumnos por asignatura
        System.out.println("\n--- Alumnos que cursan Matemáticas ---");
        System.out.println(gestor.obtenerAlumnosPorAsignatura("Matemáticas"));

        System.out.println("\n--- Alumnos que cursan Historia ---");
        System.out.println(gestor.obtenerAlumnosPorAsignatura("Historia"));

        // 4) Media de cada alumno
        System.out.println("\n--- Media de notas ---");
     // 1) Recorremos un rango de IDs de alumno (aquí 1,2 y 3)
     for (int id = 1; id <= 3; id++) {
         // 2) Para cada id llamamos a mediaAlumno(id), que devuelve un double
         double media = gestor.mediaAlumno(id);
         // 3) Imprimimos un mensaje con printf, donde %d es el id y %.2f la media con 2 decimales
         System.out.printf("Alumno %d → media = %.2f%n", id, media);
     }


        // 5) Todas las asignaturas distintas (ordenadas)
        System.out.println("\n--- Todas las asignaturas ---");
        System.out.println(gestor.obtenerTodasLasAsignaturas());
    }
}
