package ordenacion;

public class Articulo implements Comparable<Articulo>{
	private String codigo; //No vacío
	private double pvp; //En euros >=0
	private String denominacion; //No vacío
	private double peso; //En gramos >=0
	private Categoria cat;
	
	public Articulo(String codigo, double pvp, String denominacion, double peso, Categoria cat) {
		super();
		setCodigo(codigo);
		setPvp(pvp);
		setDenominacion(denominacion);
		setPeso(peso);
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "(cod=" + codigo + ", pvp=" + pvp + ", denom=" + denominacion + ", peso=" + peso
				+ ", cat=" + cat + ")";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		if (codigo==null)
			throw new IllegalArgumentException("Debe asignar un String al código");
		codigo=codigo.trim();
		if (codigo.length()==0)
			throw new IllegalArgumentException("El código no puede estar vacío");
		this.codigo = codigo;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		if (pvp<0)
			throw new IllegalArgumentException("El PVP no puede ser negativo");
		this.pvp = pvp;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		if (denominacion==null)
			throw new IllegalArgumentException("Debe asignar un String a la denominación");
		denominacion=denominacion.trim();
		if (denominacion.length()==0)
			throw new IllegalArgumentException("La denominación no puede estar vacía");
		this.denominacion = denominacion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		if (peso<0)
			throw new IllegalArgumentException("El peso no puede ser negativo");
		this.peso = peso;
	}

	public Categoria getCat() {
		return cat;
	}

	public void setCat(Categoria cat) {
		this.cat = cat;
	}

	@Override
	public int compareTo(Articulo o) {
		// this y o
		int compCat=this.getCat().compareTo(o.getCat());
		if (compCat==0)//Igual categoría
			return this.getDenominacion().compareTo(o.getDenominacion());
		else	
			return compCat;
	}
	
	
	
}
