package ficheros;

public class Palabras {
	private String clave;
	private Integer apariciones;
	public String getClave() {
		return clave;
	}
	public Palabras(String clave, Integer apariciones) {
		super();
		this.clave = clave;
		this.apariciones = apariciones;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getApariciones() {
		return apariciones;
	}
	public void setApariciones(int apariciones) {
		this.apariciones = apariciones;
	}
	@Override
	public String toString() {
		return clave  +"---"+apariciones ;
	}

}
