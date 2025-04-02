package ficherosPractica;

public class Pareja {
	private String clave;
	private Integer aparicion;
	private Double aparicionLetra;

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
		this.aparicionLetra = null; // Asegurar que no tenga valores incorrectos
	}

	public Pareja(String clave, Double aparicionLetra) {
		super();
		this.clave = clave;
		this.aparicionLetra = aparicionLetra;
		this.aparicion = null; // Evitar valores incorrectos
	}

	@Override
	public String toString() {
		if (aparicion != null) {
			return clave + "\t" + aparicion;
		} else {
			return clave + "\t" + aparicionLetra;
		}
	}

	public Double getAparicionLetra() {
		return aparicionLetra;
	}

	public void setAparicionLetra(Double aparicionLetra) {
		this.aparicionLetra = aparicionLetra;
	}

}
