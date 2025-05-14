package examenOrdinaria;

public class Alturas implements Comparable<Alturas> {
	private int altura1 = 1;
	private int altura2 = 2;
	private int distancia;

	public Alturas(int altura1, int altura2) {
		super();
		this.altura1 = altura1;
		this.altura2 = altura2;
		this.distancia = calcularAlturas(altura1, altura2);
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getAltura1() {
		return altura1;
	}

	public void setAltura1(int altura1) {
		this.altura1 = altura1;
	}

	public int getAltura2() {
		return altura2;
	}

	public void setAltura2(int altura2) {
		this.altura2 = altura2;
	}

	@Override
	public String toString() {
		return "Alturas [altura1=" + altura1 + ", altura2=" + altura2 + ", distancia=" + distancia + "]";
	}

	private static int calcularAlturas(int altura1, int altura2) {
		int altura = Math.abs(altura2 - altura1);
		return altura;
	}

	@Override
	public int compareTo(Alturas o) {
		int orden = this.distancia - o.distancia;
		
		return orden;
	}

}
