package colecionesTipoExamenOrdinaria;

public class Articulo implements Comparable<Articulo> {
	private String codigo;
	private String nombre;
	private int stock;

	@Override
	public String toString() {
		return "Articulo [codigo=" + codigo + ", nombre=" + nombre + ", stock=" + stock + "]";
	}


	public Articulo(String codigo, String nombre, int stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.stock = stock;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	@Override
	public int compareTo(Articulo o) {
		int orden=this.stock-o.stock;
		return orden;
	}

}
