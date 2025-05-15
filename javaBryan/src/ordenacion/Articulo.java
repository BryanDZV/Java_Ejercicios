package ordenacion;

public class Articulo implements Comparable<Articulo> {
	/**
	 * TEMA COPARATOR CRITERIO PRINCIPAL de ordenacion con:
	 * COMPARABLE-----CATEGORIA/DENOMINACION----- LUEGO AÑADIMOS LA 2 ORDENACION CON
	 * COMPARATOR
	 */
	private String codigo;// no vacio
	private double pvp;// >=0 en euros
	private String denominacion;// no vacio
	private double peso;// en gramos >=0
	private Categoria cat;// es un enum

	/** CONSTRUCTOR */
	public Articulo(String codigo, double pvp, String denominacion, double peso, Categoria cat) {
		super();
		this.codigo = codigo;
		this.pvp = pvp;
		this.denominacion = denominacion;
		this.peso = peso;
		this.cat = cat;
	}

	/** TO STRING */
	@Override
	public String toString() {
		return "Articulos [codigo=" + codigo + ", pvp=" + pvp + ", denominacion=" + denominacion + ", peso=" + peso
				+ ", cat=" + cat + "]";
	}

	/** GETTER Y STTERS */
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		if (codigo == null)
			throw new IllegalArgumentException("Debe asignar un String al código");
		codigo = codigo.trim();
		if (codigo.length() == 0)
			throw new IllegalArgumentException("El código no puede estar vacío");
		this.codigo = codigo;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		if (pvp < 0)
			throw new IllegalArgumentException("El PVP no puede ser negativo");
		this.pvp = pvp;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		if (denominacion == null)
			throw new IllegalArgumentException("Debe asignar un String a la denominación");
		denominacion = denominacion.trim();
		if (denominacion.length() == 0)
			throw new IllegalArgumentException("La denominación no puede estar vacía");
		this.denominacion = denominacion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		if (peso < 0)
			throw new IllegalArgumentException("El peso no puede ser negativo");
		this.peso = peso;
	}

	public Categoria getCat() {
		return cat;
	}

	public void setCat(Categoria cat) {
		this.cat = cat;
	}

	public static void main(String[] args) {

	}

	@Override
	public int compareTo(Articulo o) {
		// negativo 0 positivo comparamos this y o
		// criterio principal categoria/denominacion
		int compCat = this.getCat().compareTo(o.getCat());
		if (compCat == 0) {
			return o.getCat().compareTo(this.getCat());

		} else
			return compCat;
	}

}
