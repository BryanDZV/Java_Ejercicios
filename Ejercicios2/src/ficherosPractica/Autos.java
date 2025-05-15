package ficherosPractica;

public class Autos implements Comparable<Autos> {
	private String marca;
	private Integer precio;
	private String matricula;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Autos(String marca, Integer precio, String matricula) {
		super();
		this.marca = marca;
		this.precio = precio;
		this.matricula = matricula;
	}

	@Override
	public String toString() {

		return marca + "\t" + precio + "\t" + matricula;

	}

	@Override
	public int compareTo(Autos o) {
		int orden = this.getMarca().compareTo(o.getMarca());
		if (orden == 0) {
			orden = this.getPrecio().compareTo(o.getPrecio());
			if (orden == 0) {
				orden = this.getMatricula().compareTo(o.getMatricula());
			}
		}
		return orden;
	}

}
