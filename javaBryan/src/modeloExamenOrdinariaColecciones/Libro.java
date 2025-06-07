package modeloExamenOrdinariaColecciones;

public class Libro implements Comparable<Libro> {
	private String titulo;
	private String autor;
	private String genero;
	private int añoPublicacion;

	public Libro(String titulo, String autor, String genero, int añoPublicacion) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.añoPublicacion = añoPublicacion;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", genero=" + genero + ", añoPublicacion="
				+ añoPublicacion + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAñoPublicacion() {
		return añoPublicacion;
	}

	public void setAñoPublicacion(int añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}

	@Override
	public int compareTo(Libro o) {
		int orden = this.titulo.compareTo(o.titulo);
		return orden;
	}

	// constructor, getters y setters
}
