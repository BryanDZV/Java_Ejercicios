package ficherosPractica;

public class Pareja {
	private String clave;
	private Integer aparicion;
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Integer getAparicion() {
		return aparicion;
	}
	public void setAparicion(Integer aparicion) {
		this.aparicion = aparicion;
	}
	public Pareja(String clave, Integer aparicion) {
		super();
		this.clave = clave;
		this.aparicion = aparicion;
	}

	@Override
	public String toString() {
		return clave + "\t" + aparicion;
	}
	
	

}
