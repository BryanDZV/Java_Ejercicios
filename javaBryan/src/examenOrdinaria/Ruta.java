package examenOrdinaria;

public class Ruta implements Comparable<Ruta>{
	private String calle1 = "default";
	private String calle2 = "default";
	@Override
	public String toString() {
		return "Ruta [calle1=" + calle1 + ", calle2=" + calle2 + ", distanciaCalles=" + distanciaCalles + "]";
	}

	private int distanciaCalles = 0;

	public Ruta(String calle1, String calle2, int distanciaCalles) {
		super();
		this.calle1 = calle1;
		this.calle2 = calle2;
		this.distanciaCalles = distanciaCalles;

	}

	public String getCalle1() {
		return calle1;
	}

	public void setCalle1(String calle1) {
		this.calle1 = calle1;
	}

	public String getCalle2() {
		return calle2;
	}

	public void setCalle2(String calle2) {
		this.calle2 = calle2;
	}

	public int getDistanciaCalles() {
		return distanciaCalles;
	}

	public void setDistanciaCalles(int distanciaCalles) {
		this.distanciaCalles = distanciaCalles;
	}

	@Override
	public int compareTo(Ruta o) {
	int orden= this.distanciaCalles-o.distanciaCalles;
		return orden;
	}

}
