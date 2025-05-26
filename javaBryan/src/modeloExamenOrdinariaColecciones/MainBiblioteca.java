package modeloExamenOrdinariaColecciones;

public class MainBiblioteca {

	public static void main(String[] args) {
		// 1. Crea y llena la biblioteca
        Biblioteca biblio = new Biblioteca();
        Libro l1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Realismo", 1967);
        Libro l2 = new Libro("Don Quijote",             "Miguel de Cervantes",    "Clásico",   1605);
        Libro l3 = new Libro("El otoño del patriarca",  "Gabriel García Márquez", "Realismo",  1975);

        biblio.agregarLibro(l1);
        biblio.agregarLibro(l2);
        biblio.agregarLibro(l3);
        
     // 2. Prueba obtenerLibrosPorAutor
        System.out.println("Prueba obtenerLibrosPorAutor");
        System.out.println("→ Libros de G. G. Márquez:");
        System.out.println(biblio.obtenerLibrosPorAutor("Gabriel García Márquez"));

        // 3. Prueba obtenerTodosLosGeneros
        System.out.println("Prueba obtenerTodosLosGeneros");

        System.out.println("→ Géneros disponibles:");
        System.out.println(biblio.obtenerTodosLosGeneros());

        // 4. Prueba obtenerLibrosPorGenero
        System.out.println("Prueba obtenerLibrosPorGenero");

        System.out.println("→ Realismo por año:");
        System.out.println(biblio.obtenerLibrosPorGenero("Realismo"));

		// 5. Prueba obtenerLibroMasAntiguoPorGenero
        System.out.println("Prueba obtenerLibroMasAntiguoPorGenero");

        System.out.println("→ Libro más antiguo en Realismo:");
        System.out.println(biblio.obtenerLibroMasAntiguoPorGenero("Realismo"));
	}

}
