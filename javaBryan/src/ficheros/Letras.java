package ficheros;

public class Letras {
	private String letra;
	private Integer aparicion;
	
	public Letras(String letra, Integer aparicion) {
		super();
		this.letra = letra;
		this.aparicion = aparicion;
	}
	public String toString() {
		return "Letras [letra=" + letra + ", aparicion=" + aparicion + "]";
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public Integer getAparicion() {
		return aparicion;
	}
	public void setAparicion(Integer aparicion) {
		this.aparicion = aparicion;
	}

	

}
