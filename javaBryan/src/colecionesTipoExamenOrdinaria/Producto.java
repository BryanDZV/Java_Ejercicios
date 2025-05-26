package colecionesTipoExamenOrdinaria;

public class Producto implements Comparable<Producto> {
	private String id;
	private String nombre;
	private Double precio;

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

	

	public Producto(String id, String nombre, Double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int compareTo(Producto o) {
		int orden=this.nombre.compareTo(o.nombre);
		if (orden==0) {
			orden=(int) -(this.precio-o.precio);
		}
		return orden;
	}

}
