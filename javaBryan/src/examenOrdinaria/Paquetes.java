package examenOrdinaria;

public class Paquetes implements Comparable<Paquetes> {
	private Integer codigo1 = 1234;
	private Integer codigo2 = 1234;
	private Integer intervalo = 1234;

	public Paquetes(Integer codigo1, Integer codigo2) {
		super();
		this.codigo1 = codigo1;
		this.codigo2 = codigo2;
		this.intervalo = calcularIntervalo();
	}

	@Override
	public String toString() {
		return codigo1 + codigo2 + "----->" + intervalo;
	}

	public Integer getCodigo1() {
		return codigo1;
	}

	public void setCodigo1(Integer codigo1) {
		this.codigo1 = codigo1;
	}

	public Integer getCodigo2() {
		return codigo2;
	}

	public void setCodigo2(Integer codigo2) {
		this.codigo2 = codigo2;
	}

	public Integer getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}

	private int calcularIntervalo() {
		return Math.abs(codigo2 - codigo1);
	}

	@Override
	public int compareTo(Paquetes o) {
		int orden = this.intervalo - o.intervalo;
		return orden;
	}

}
