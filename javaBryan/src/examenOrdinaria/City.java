package examenOrdinaria;

public class City implements Comparable<City> {
	private String ciudad="default";
	private Integer codigo=123;
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public City(String ciudad, Integer codigo) {
		super();
		this.ciudad = ciudad;
		this.codigo = codigo;
	}
	@Override
	public String toString() {
		return "City [ciudad=" + ciudad + ", codigo=" + codigo + "]";
	}
	@Override
	public int compareTo(City o) {
int orden=this.ciudad.compareTo(o.ciudad);
if (orden==0) {
	orden=-(this.codigo.compareTo(o.codigo));
}

return orden;
	}
	

}
