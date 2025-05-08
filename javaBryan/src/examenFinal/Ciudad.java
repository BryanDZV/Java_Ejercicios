package examenFinal;

public class Ciudad implements Comparable<Ciudad>{
	@Override
	public String toString() {
		return "Ciudad [codigo=" + codigo + ", poblacion=" + poblacion + "]";
	}
	public Ciudad(Integer codigo, String poblacion) {
		super();
		this.codigo = codigo;
		this.poblacion = poblacion;
	}
	private Integer codigo=2;
	private String poblacion="default";
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
	public int compareTo(Ciudad o) {
		int orden=this.poblacion.compareTo(o.poblacion);
		if (orden==0) {
			orden=-(this.codigo.compareTo(o.codigo));
		}
		return orden;
	}

}
