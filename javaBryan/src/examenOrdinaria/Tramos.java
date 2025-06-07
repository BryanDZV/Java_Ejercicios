package examenOrdinaria;

public class Tramos implements Comparable<Tramos> {

	private Integer punto1 = 1234;
	private Integer punto2 = 12345;
	private Integer distancia;

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "Tramos [punto1=" + punto1 + ", punto2=" + punto2 + ", distancia=" + distancia + "]";
	}

	public Tramos(Integer punto1, Integer punto2) {
		super();
		this.punto1 = punto1;
		this.punto2 = punto2;
		this.distancia = calcularDistancia(punto1, punto2);
	}

	public Integer getPunto1() {
		return punto1;
	}

	public void setPunto1(Integer punto1) {
		this.punto1 = punto1;
	}

	public Integer getPunto2() {
		return punto2;
	}

	public void setPunto2(Integer punto2) {
		this.punto2 = punto2;
	}

	private static int calcularDistancia(int p1, int p2) {
		return Math.abs(p2 - p1);
	}

	@Override
	public int compareTo(Tramos o) {
		int orden = this.distancia.compareTo(o.distancia);
		return orden;
	};
}
