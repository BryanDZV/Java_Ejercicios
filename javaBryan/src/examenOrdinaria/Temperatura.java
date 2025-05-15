package examenOrdinaria;

public class Temperatura implements Comparable<Temperatura> {
	private String dia = "lunaes";

	@Override
	public String toString() {
		return "Temperatura [dia=::" + dia + "--- temperatura=::" + temperatura + "]";
	}

	private int temperatura = 1;

	public Temperatura(String dia, int temperatura) {
		super();
		this.dia = dia;
		this.temperatura = temperatura;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public int compareTo(Temperatura o) {
		int orden = (this.temperatura - o.temperatura);
		return orden;
	}

}
