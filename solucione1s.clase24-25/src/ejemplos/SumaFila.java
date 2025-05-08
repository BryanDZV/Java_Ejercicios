package ejemplos;

public class SumaFila implements Comparable<SumaFila>{
	private int indiceFila;
	private int suma;

	public SumaFila(int indiceFila, int suma) {
		this.indiceFila = indiceFila;
		this.suma = suma;
	}

	public int getIndiceFila() {
		return indiceFila;
	}

	public void setIndiceFila(int indiceFila) {
		this.indiceFila = indiceFila;
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}

	@Override
	public String toString() {
		return "("+indiceFila+","+suma+")";
	}

	@Override
	public int compareTo(SumaFila o) {
		if (this.getSuma() > o.getSuma())
			return -1; //this anterior a o
		else {
			if (this.getSuma() < o.getSuma())
				return 1; //this posterior a o
			else
				return 0;
		}
	}

	
	
}
