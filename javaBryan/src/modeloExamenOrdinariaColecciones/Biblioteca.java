package modeloExamenOrdinariaColecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
	private Map<String, List<Libro>> librosPorAutor;
	private Map<String, List<Libro>> librosPorGenero;

	public Biblioteca() {
		librosPorAutor = new HashMap<String, List<Libro>>();
		librosPorGenero = new HashMap<String, List<Libro>>();

	}

	// Métodos a implementar:

	// 1) void agregarLibro(Libro libro)
	// – Añade el libro a ambos mapas.
	
	void agregarLibro(Libro libro) {
	    // Autor
	    if (!librosPorAutor.containsKey(libro.getAutor())) {
	        librosPorAutor.put(libro.getAutor(), new ArrayList<>());
	    }
	    librosPorAutor.get(libro.getAutor()).add(libro);

	    // Género
	    if (!librosPorGenero.containsKey(libro.getGenero())) {
	        librosPorGenero.put(libro.getGenero(), new ArrayList<>());
	    }
	    librosPorGenero.get(libro.getGenero()).add(libro);
	}


	// 2) List<Libro> obtenerLibrosPorAutor(String autor)
	// – Devuelve lista ordenada alfabéticamente por título.
	public List<Libro> obtenerLibrosPorAutor(String autor) {
		List<Libro> lista = new ArrayList<Libro>();
		lista = librosPorAutor.get(autor);
		lista.sort(null);

		return lista;
	};

	// 3) List<String> obtenerTodosLosGeneros()
	// – Devuelve la lista de géneros distintos ordenados alfabéticamente.
	public List<String> obtenerTodosLosGeneros() {
		List<String> l = new ArrayList<String>(librosPorGenero.keySet());
		l.sort(null);
		return l;
	};

	// 4) List<Libro> obtenerLibrosPorGenero(String genero)
	// – Devuelve lista ordenada por año de publicación (ascendente).
	public List<Libro> obtenerLibrosPorGenero(String genero) {
		List<Libro> lista = new ArrayList<Libro>();
		lista = librosPorGenero.get(genero);
		lista.sort(new OrdenAnio());

		return lista;
	};

	// 5) Libro obtenerLibroMasAntiguoPorGenero(String genero)
	// – Devuelve el libro con año de publicación mínimo en ese género.

	public Libro obtenerLibroMasAntiguoPorGenero(String genero) {
		List<Libro> l = new ArrayList<Libro>();
		l = obtenerLibrosPorGenero(genero);

		Libro minimo = l.get(0);

		return minimo;

	};

}
