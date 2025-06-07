package examenFinal;

public class City implements Comparable<City> {
	private Integer codigo = 1234;
	
	public City(Integer codigo, String poblacion) {
		super();
		this.codigo = codigo;
		this.poblacion = poblacion;
	}

	private String poblacion = "default";

	@Override
	public String toString() {
		return codigo +"\t"+ poblacion;
	}


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}


	@Override
	public int compareTo(City o) {
		int orden=this.poblacion.compareTo(o.poblacion);
		if (orden==0) {
			orden=-(this.codigo.compareTo(o.codigo));
		}
		return orden;
	}

}
