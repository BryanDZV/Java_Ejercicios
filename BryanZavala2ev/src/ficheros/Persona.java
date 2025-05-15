package ficheros;

public class Persona {
	@Override
	public String toString() {
		if (aparicion != null) {
			return palabra + "\t" + aparicion;
		} else {
			return palabra + "\t" + aparicionLetra;
		}
	}

	private String palabra;
	private Integer aparicion;

	public Double getAparicionLetra() {
		return aparicionLetra;
	}

	public Persona(String palabra, Double aparicionLetra) {
		super();
		this.palabra = palabra;
		this.aparicionLetra = aparicionLetra;
		this.aparicion = null; // Evitar valores incorrectos
	}

	public void setAparicionLetra(Double aparicionLetra) {
		this.aparicionLetra = aparicionLetra;
	}

	private Double aparicionLetra;

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public Integer getAparicion() {
		return aparicion;
	}

	public void setAparicion(Integer aparicion) {
		this.aparicion = aparicion;
	}

	public Persona(String palabra, Integer aparicion) {
		super();
		this.palabra = palabra;
		this.aparicion = aparicion;
		this.aparicionLetra = null; // Asegurar que no tenga valores incorrectos

	}

}
